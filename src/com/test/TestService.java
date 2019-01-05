package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


/**
 * TestService handles the data gathering in which
 * the java back-end communicated with the JSON and
 * gets its data 
 * 
 * @author macku.sanchez
 *
 */
public class TestService {
	/**
	 * getText()
	 * 
	 * Function for extracting JSON data from the URL
	 * 
	 * @param url where the JSON Data comes from.
	 * @return toBeReturned String that contains the JSON Data that is converted to a String.
	 * @throws Exception 
	 */
	public static String getJSONData(String url) throws Exception {
        URL website = new URL(url);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream(),"UTF8"));

        StringBuilder sb = new StringBuilder();
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            sb.append(inputLine);

        in.close();
        
        String toBeReturned = sb.toString();

        return toBeReturned;
    }

	/**testFunc()
	 * 
	 * function that gets called by the controller to extract the JSON Data from the URL and stores
	 * the data in the People class.
	 * 
	 * @return peopleList List containing the people object
	 * @throws Exception Exception thrown to be caught in the controller
	 */
	public static List<People> testFunc() throws Exception {
	
		JSONArray jsonArray=new JSONArray(getJSONData("http://s3-ap-southeast-1.amazonaws.com/fundo/js/profiles.json")); 
		JSONObject obj=null;
		List<People> peopleList = new ArrayList<People>();
	    
	         for(int i=0;i<jsonArray.length();i++){
	        	People people = new People();
	            //get the JSON Object inside the JSON Array
	            obj=jsonArray.getJSONObject(i); 
	            JSONObject insideJSON = obj.getJSONObject("name");
	            people.setId(obj.getString("id"));
	            people.setActive(obj.getBoolean("active"));
	            people.setBlocked(obj.getBoolean("blocked"));
	            people.setBalance(obj.getString("balance"));
	            people.setPicture(obj.getString("picture"));
	            people.setAge(obj.getInt("age"));
	            people.setFirstName(insideJSON.getString("first"));
	            people.setMiddleName(insideJSON.getString("middle"));
	            people.setLastName(insideJSON.getString("last"));
	            people.setCompleteName(insideJSON.getString("first")+" "+insideJSON.getString("middle")+" "+insideJSON.getString("last"));
	            people.setEmail(obj.getString("email"));
	            people.setPhone(obj.getString("phone"));
	            people.setAddress(obj.getString("address"));
	            people.setProfile(obj.getString("profile"));
	            people.setDate_registered(obj.getLong("date_registered"));
	            peopleList.add(people);
	         
	         }
	   return peopleList;
	}
}