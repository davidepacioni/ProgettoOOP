package it.univpm.projectSpringBootApp.utility.other;

import java.util.ArrayList;

public class FilterArrayString {
	
	protected ArrayList<String> param = new ArrayList<String>();

	
	/** Costruttore 
	 * @param parameters deve essere un ArrayList String.
	 * @throws IllegalArgumentException il valore inserito non è del tipo richiesto
	*/
	public FilterArrayString(Object parameters) {
		
		if(parameters instanceof ArrayList<?>) {
			
			for(Object ele : (ArrayList<?>)parameters) {
				
				if(ele instanceof String) {
					param.add((String)ele);
				}else {
					throw new IllegalArgumentException("Type: String ");
				}
			}

		}else {			
			throw new IllegalArgumentException("Type: Array ");
		}
	}
	
	
	/** Set 
	 * @param parameters deve essere un ArrayList di stringhe
	 * @throws IllegalArgumentException il valore inserito non è del tipo richiesto 
	*/
	public void SetFilterParameters(Object parameters) {
		
		
		if(parameters instanceof ArrayList<?>) {
			
			for(Object ele : (ArrayList<?>)parameters) {
				
				if(ele instanceof String) {
					param.add((String)ele);
				}else {
					throw new IllegalArgumentException("Type: String ");
				}
			}

		}else {			
			throw new IllegalArgumentException("Type: Array ");
		}
	}
	
}