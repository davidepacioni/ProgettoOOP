package it.univpm.projectSpringBootApp.utility;

import java.text.ParseException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import it.univpm.projectSpringBootApp.model.PostInstagram;

public class ParseJSON {

	public static ArrayList<PostInstagram> JSONParsr(JSONObject json) {
		ArrayList<PostInstagram> lista = new ArrayList<PostInstagram>();
		if (json != null) {

			JSONArray dataset = json.optJSONArray("data");
			if (dataset != null) {

				for (int i = 0; i < dataset.length(); i++) {

					PostInstagram post = new PostInstagram();
					post.setId(dataset.getJSONObject(i).getString("id"));
					post.setType(dataset.getJSONObject(i).getString("media_type"));
					try {
						post.setCreation_date(dataset.getJSONObject(i).getString("timestamp"));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					lista.add(post);
				}
			}
		}
		return lista;
	}
}
