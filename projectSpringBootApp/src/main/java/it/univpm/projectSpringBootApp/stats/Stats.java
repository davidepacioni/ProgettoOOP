package it.univpm.projectSpringBootApp.stats;

import java.util.ArrayList;
import it.univpm.projectSpringBootApp.model.PostInstagram;

/**
 * Classe che implementa tutti i metodi per eseguire le statistiche
 * 
 * @author Davide Pacioni
 * @author Alex Giaccio
 */
public class Stats {
	
	/**
	 * Viene calcolata la media
	 * 
	 * @param post I post da cui vengono prese le informazioni per il calcolo della media
	 * @param field Il campo sul quale verrà calcolata la media
	 * @return La media
	 */
	public double Average(ArrayList<PostInstagram> post, String field) {

		return Sum(post,field) / List(post,field).size();

	}

	/**
	 * Viene calcolata la somma
	 * 
	 * @param post I post da cui vengono prese le informazioni per il calcolo della somma
	 * @param field Il campo sul quale verrà calcolata la somma
	 * @return La somma
	 */
	public double Sum(ArrayList<PostInstagram> post,String field) {
		double sum = 0;
		for (int i = 0; i < List(post,field).size(); i++)
			sum += List(post,field).get(i);
		return sum;
	}
	
	/**
	 * 
	 * @param post I post da cui vengono prese le informazioni per il calcolo delle statistiche
	 * @param field Il campo  sul quale verranno calcolate le statistiche
	 * @return La lista dei post relativi ad un certo campo
	 */
	public ArrayList<Double> List(ArrayList<PostInstagram> post, String field){
		
		ArrayList<Double> listaPost = new ArrayList<Double>();
		
		for(int i =0; i < post.size();i++) {
				if(field.equals("Type"))
					listaPost.add((double)post.get(i).getType());
				else if(field.equals("Date"))
					listaPost.add((double)post.get(i).getCreation_date());
		}
		return listaPost;
	}
}