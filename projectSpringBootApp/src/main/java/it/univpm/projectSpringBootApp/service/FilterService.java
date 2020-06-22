package it.univpm.projectSpringBootApp.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import it.univpm.projectSpringBootApp.model.PostInstagram;
import it.univpm.projectSpringBootApp.utility.DownloadJSON;
import it.univpm.projectSpringBootApp.utility.Filter;
import it.univpm.projectSpringBootApp.utility.ParseJSON;

public class FilterService {
	
	/** package contenente le classi che implementano l'interfaccia Filter 
	*/
	private final static String path = "it.univpm.projectSpringBootApp.filter.";
	
   private static ArrayList<PostInstagram> PostInstagrams = ParseJSON.JSONParsr(DownloadJSON.getCompleteJSON());
   
   /*
    * Permette di istanziare un oggetto Filter dalle classi presenti nel package 
    * it.univpm.ProgettoOOP.util.filter. indicando i paramatri di filtraggio desiderati. 
	 * @param     column campo su cui si vuole eseguire il filtraggio. (es: Hashtag)
	 * @param     operator tipo di filtraggio selezionato. (es: Included)
	 * @param     param parametro ingresso necessario al filro selezionato. 
	 * @return    un oggetto che implementa l'interfaccia Filter.(ossia il filtro desiderato)
	 * @throws    FilterNotFoundException il filtro richiesto non è presente nel package. 
	 * @throws    FilterIllegalArgumentException il parametro d'ingresso al filtro non è
	 *            valido per il filro selezionato. 
	 * @throws    InternalGeneralException errori interni. (se si verifica è necessaria una 
	 * 			  revisione del codice)
    */
	public static Filter instanceFilter(String column,String operator,Object param) {
		   //throws FilterNotFoundException, FilterIllegalArgumentException,InternalGeneralException{
		
		Filter filtro = null;
		String filterName = new String("Filter"+column+operator);
		System.out.println(filterName);
		String ClassFilterName = path.concat(filterName);
	    
		try {
			
			Class<?> cls = Class.forName(ClassFilterName); //seleziono la classe
		
			Constructor<?> ct = cls.getDeclaredConstructor(Object.class); //seleziono il costruttore
	    
			filtro =(Filter)ct.newInstance(param);  //istanzo oggetto filtro
		}
		
	    //entra qui se il nome filtro non è corretto 
	    catch(ClassNotFoundException e){
	    	//throw new FilterNotFoundException("The filter in field: '"+column+"' with operator: '"+
	          //                                  operator +"' does not exist");
	    }
		
		//entra qui se sbagliate maiuscole e minuscole
	    catch(NoClassDefFoundError e){
	    	//throw new FilterNotFoundException(
	    	//		"Error typing: '"+filterName+"' uppercase and lowercase error");
	    }

	    //entra qui se il costruttore chiamato da newInstance lancia un eccezione 
	   	catch (InvocationTargetException e) {  
	   		//genero una nuova eccezione 
	   		// throw new FilterIllegalArgumentException(e.getTargetException().getMessage()
	   		//		+ " Expected in '"+column+"'");
	   	}
		
	    catch (LinkageError | NoSuchMethodException | SecurityException 
	    		| InstantiationException | IllegalAccessException e ) {
		       e.printStackTrace();
		    	//throw new InternalGeneralException("try later");
		    }

		
	    return filtro;
	    
	}
		
	/**
	 * Questo metodo scorre un ArrayList di PostInstagram e restitusce un nuovo ArrayList di PostInstagram composto
	 * da soli PostInstagram che risultano positivi al filtro.
	 * @param filtro che si desidera utilizzare.
	 * @param previousArray ArrayList di PostInstagram su cui si vuol eseguire l'operazione di filtraggio.
	 * @return ArrayList di PostInstagram frutto dell'operazione di filtraggio.
	 */
	public static ArrayList<PostInstagram> runFilterAND(Filter filtro, ArrayList<PostInstagram> previousArray){

		ArrayList<PostInstagram> filteredArray = new ArrayList<PostInstagram>();
		
		for(PostInstagram PostInstagram :  previousArray) {

			if(filtro.filter(PostInstagram))
				filteredArray.add(PostInstagram);
		}				

		return filteredArray;
	}

	/**
	 * Questo metodo ci restituisce un ArrayList di PostInstagram contenenti tutti quei PostInstagram che 
	 * rispettano o uno o l'altro filtro.
	 * @param filtro che si desidera utilizzare.
	 * @param previousArray ArrayList di PostInstagram su cui si vuol eseguire l'operazione di filtraggio.
	 * @return ArrayList di PostInstagram frutto dell'operazione di filtraggio.
	 */
	public static  ArrayList<PostInstagram> runFilterOR(Filter filtro, ArrayList<PostInstagram> previousArray){

		ArrayList<PostInstagram> filteredArray = new ArrayList<PostInstagram>();
		
		for(PostInstagram PostInstagram : PostInstagrams) {

			if(filtro.filter(PostInstagram))
				filteredArray.add(PostInstagram);
		}	
		
		previousArray.removeAll(filteredArray);
		previousArray.addAll(filteredArray);
		return previousArray;
	}
	
}