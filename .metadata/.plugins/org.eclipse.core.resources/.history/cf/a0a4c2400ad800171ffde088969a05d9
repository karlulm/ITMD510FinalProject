package main;

import java.io.*;
import java.net.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class TestRESTJASONstuff {	
	
	static String urlToRead = "http://api.brewerydb.com/v2/categories?key=cc0090d9b6bfb3ff92bcb9cdaa15a599";
	
	
	   public static String getHTML() throws Exception {
		   
		   String urlToRead = "http://api.brewerydb.com/v2/categories?key=cc0090d9b6bfb3ff92bcb9cdaa15a599";
		   
		      StringBuilder result = new StringBuilder();
		      URL url = new URL(urlToRead);
		      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		      conn.setRequestMethod("GET");
		      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		      String line;
		      while ((line = rd.readLine()) != null) {
		         result.append(line);
		      }
		      rd.close();

		      
		      String JSON_DATA = result.toString();
		      
		      final JSONObject obj = new JSONObject(JSON_DATA);
		      final JSONArray geodata = obj.getJSONArray("data");
		      final int n = geodata.length();
		      for (int i = 0; i < n; ++i) {
		        final JSONObject person = geodata.getJSONObject(i);
		        System.out.println(person.getInt("id"));
		        System.out.println(person.getString("name"));
		        System.out.println(person.getString("createDate"));
//		        System.out.println(person.getDouble("latitude"));
//		        System.out.println(person.getDouble("longitude"));
		      }
		      
		      return result.toString();
		      
		   }
	   
	   
	   
	   
	public static void parse(){
		
		 URI uri;
		try {
			uri = new URI(urlToRead);
			 JSONTokener tokener;
			try {
				tokener = new JSONTokener(uri.toURL().openStream());
				
				
				 JSONObject root = new JSONObject(tokener);
				 
				 
				 System.out.println(root);
				
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
			
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	   
	  



}
