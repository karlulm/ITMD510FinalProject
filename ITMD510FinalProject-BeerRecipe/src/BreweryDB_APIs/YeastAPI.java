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
import BeerRecipe.Yeasts;

public class YeastAPI {
	
	   public static List<Hops> getHopAPI(){
		   
		   String urlToRead = "hhttp://api.brewerydb.com/v2/yeasts?key=cc0090d9b6bfb3ff92bcb9cdaa15a599";
		   
		   List<Yeasts> yeastsList = new ArrayList<Yeasts>();
		   
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
					
					Yeasts addYeast = new Yeasts();
					
					final JSONObject JasonYeasts = geodata.getJSONObject(i);
					
					int yeastID = JasonYeasts.getInt("id"); 
					
					String yeastName = JasonYeasts.getString("name");
					
					String yeastCatagry = JasonYeasts.getString("categoryDisplay");
					
					String yeastDescription = null;
					
					if (JasonYeasts.has("productId")){
						
						yeastDescription =JasonYeasts.getString("productId");
						
					}
					
					String yeastSupplier = null;
					
					if (JasonYeasts.has("supplier")){
						
						yeastSupplier =JasonYeasts.getString("supplier");
						
					}
					
					String yeastYeastFormatn = null;
					
					if (JasonYeasts.has("yeastFormat")){
						
						yeastYeastFormatn =JasonYeasts.getString("yeastFormat");
						
					}
					
					String yeastCategoryDisplay = null;
					
					if (JasonYeasts.has("categoryDisplay")){
						
						yeastCategoryDisplay =JasonYeasts.getString("categoryDisplay");
						
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
