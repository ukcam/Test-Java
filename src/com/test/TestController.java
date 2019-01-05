package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;



/**
 * 
 * This is the class for the TestController
 * 
 * 
 * @author macku.sanchez
 *
 */
@Controller
public class TestController {
	TestService testService = new TestService();
	 List<People> peopleList = new ArrayList<People>(); 
	 People people = new People();
	 
	 /**
	  * Basically redirects the page to HomePage
	  * 
	  * @return returns HomePage jsp
	  */
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String redirect() {
      return "redirect:HomePage";
   }
   
   /**
    * This is the controller for HomePage
    * 
    * @return model containing the JSP Page and the Objects 
    */
   @RequestMapping(value = "/HomePage", method = RequestMethod.GET)
   public ModelAndView homePageController() {
	   		peopleList =  new ArrayList<People>();	
	      try {
			peopleList = TestService.testFunc();
		} catch (Exception e) {
			e.printStackTrace();
		}
	      
	      ModelAndView model = new ModelAndView("HomePage");
	      model.addObject("lists", peopleList);
	      return model;
	}
   
   /**
    * Controller for the Profile Page that shows the full details of the profile
    * 
    * 
    * @param id ID of the data chosen
    * @param model is used to render view
    * @return "Profile" returns the JSP named profile for the view
    */
   @RequestMapping(value = "/Profile/{id}", method = RequestMethod.GET)
   public String profilePageController(@PathVariable String id,ModelMap model) {
	   String peopleId;
	   for (int i = 0; i < peopleList.size(); i++) {
   	    	peopleId = peopleList.get(i).getId().toString();
   	    	if(id.equals(peopleId)) {
   	    		model.addAttribute("id",peopleList.get(i).getId());
   	    		model.addAttribute("completeName",peopleList.get(i).getCompleteName());
   	    		model.addAttribute("profile",peopleList.get(i).getProfile());
   	    		model.addAttribute("email",peopleList.get(i).getEmail());
   	    		model.addAttribute("phone",peopleList.get(i).getPhone());
   	    		model.addAttribute("address",peopleList.get(i).getAddress());
   	    		model.addAttribute("age",peopleList.get(i).getAge());
   	    		model.addAttribute("balance",peopleList.get(i).getBalance());
   	    		model.addAttribute("picture",peopleList.get(i).getPicture());
   	    	}
	   }
	      return "Profile";
	}
}