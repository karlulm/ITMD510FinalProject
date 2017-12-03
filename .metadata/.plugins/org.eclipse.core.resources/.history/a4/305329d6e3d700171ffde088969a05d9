package BreweryDB_APIs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import BeerRecipe.Hops;

public class HopsAPI {
	
	
	   public static List<Hops> getHopAPI(){
		   
		   String urlToRead = "http://api.brewerydb.com/v2/hops?key=cc0090d9b6bfb3ff92bcb9cdaa15a599";
		   
		   List<Hops> hopList = new ArrayList<Hops>();
		   
			try {
				
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
				
				JSONObject obj = new JSONObject(JSON_DATA);
				JSONArray geodata = obj.getJSONArray("data");
				int n = geodata.length();
							
				for (int i = 0; i < n; ++i) {
					
					Hops addHop = new Hops();
					
					final JSONObject JasonHops = geodata.getJSONObject(i);
					
					int hopID = JasonHops.getInt("id"); 
					
					String hopName = JasonHops.getString("name");
					
					String hopCatagry = JasonHops.getString("categoryDisplay");
					
					String hopDescription = null;
					
					if (JasonHops.has("description")){
						
						hopDescription =JasonHops.getString("description");
						
					}
					
					String hopCounryIsoCode = null;
					
					String hopCounryName = null;
					
					if (JasonHops.has("country")){
						
						//hopCounryIsoCode =  hopList.get(i).(JasonHops.getString("isoCode"));  //JasonHops.get("isoCode");
						
						hopCounryIsoCode = JasonHops.getJSONObject("country").getString("isoCode");
						
						hopCounryName = JasonHops.getJSONObject("country").getString("displayName");
					}				
					
					addHop.setHopsID(hopID);
					addHop.setHopName(hopName);
					addHop.setCategoryDisplay(hopCatagry);
					addHop.setHopDescription(hopDescription);
					addHop.setCountryisoCode(hopCounryIsoCode);
					addHop.setCountryName(hopCounryName);
					
					hopList.add(addHop);
					
				}
		      
		      
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
			return hopList;
			
	   }

}
