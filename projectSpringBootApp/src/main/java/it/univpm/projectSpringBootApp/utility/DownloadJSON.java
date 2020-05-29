package it.univpm.projectSpringBootApp.utility;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONException;
import org.json.JSONObject;

public class DownloadJSON {
	
	
	public static JSONObject JSONfromURL() throws JSONException {
		String url = "https://graph.instagram.com/me/media?fields=id,media_type,timestamp&access_token=IGQVJVZA3Q1RzA1VzNna3VfUzhOOG5UeVRaaDloWTYyZAzg5T05sVDkwdHNZAenNLd09xN19Oa29jZAUZAkZAEhiN3BHeG5yNVJfdTV2ajduLTVwTjQ2QVNyU2xkSXhuTmRDaFBvMnhKemk5NDNVYVpKbkdTWgZDZD";
		String data = "";
		String line = "";

		try {
			URLConnection openConnection = new URL(url).openConnection();
			openConnection.addRequestProperty("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");

			InputStream in = openConnection.getInputStream();

			try {
				InputStreamReader inR = new InputStreamReader(in);
				BufferedReader buf = new BufferedReader(inR);

				while ((line = buf.readLine()) != null) {
					data += line;
				}
			} finally {
				in.close();
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
