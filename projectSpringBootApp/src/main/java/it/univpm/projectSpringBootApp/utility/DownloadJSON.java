package it.univpm.projectSpringBootApp.utility;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class DownloadJSON {

	public static JSONObject getCompleteJSON(){
		String newurl = "https://graph.instagram.com/me/media?fields=id,media_type,timestamp&access_token=IGQVJVZA3Q1RzA1VzNna3VfUzhOOG5UeVRaaDloWTYyZAzg5T05sVDkwdHNZAenNLd09xN19Oa29jZAUZAkZAEhiN3BHeG5yNVJfdTV2ajduLTVwTjQ2QVNyU2xkSXhuTmRDaFBvMnhKemk5NDNVYVpKbkdTWgZDZD";
		
		String next = null;
		ArrayList<JSONObject> items = new ArrayList<JSONObject>();
		
		do {
			JSONObject json = JSONfromURL(newurl);
			
			JSONArray array = (JSONArray) json.get("data");
			for(int n = 0; n < array.length(); n++)
			{
			    JSONObject e = array.getJSONObject(n);
			    //System.out.println(e.toString());
			    items.add(e);
			}
			
			JSONObject jo = (JSONObject) json.get("paging");
			
			try {
				next = (String) jo.get("next");
			}catch(JSONException e) {
				next = null;
			}
			
			//System.out.println(next);
			newurl = next;
		}while(next != null);
		
		JSONObject complete = new JSONObject();
		complete.put("data", items);
		return complete;
	}
	
	public static JSONObject JSONfromURL(String nexturl) throws JSONException {
		String url = nexturl;
		String data = "";
		String line = "";

		try {
			URLConnection openConnection = new URL(url).openConnection();
			openConnection.addRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");

			InputStream input = openConnection.getInputStream();

			try {
				InputStreamReader reader = new InputStreamReader(input);
				BufferedReader buffer = new BufferedReader(reader);

				while ((line = buffer.readLine()) != null) {
					data += line;
				}
			} finally {
				input.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONObject json = new JSONObject(data.toString());
		return json;

	}
}
