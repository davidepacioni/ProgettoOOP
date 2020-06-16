package controller;
	
	import java.util.ArrayList;

	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;
	import org.springframework.web.bind.annotation.RestController;
	
	/** Rappresenta la classe che gestisce tutte le chiamate al Server 
	 * permesse al Client.
	 * @author Davide Pacioni
	 * @author Alex Giaccio
	*/

	@RestController
	public class Controllore {
		
		/**
		 * Risponde all richiesta GET /metadata 
		 * @return ArrayList di oggetti Metadata
		 */

		@RequestMapping(value = "metadata", method=RequestMethod.GET)
		public ArrayList<Metadata> getMetadata(){
			
			return DatabaseClass.getArrayMetadata();
		}
		
		/**
		 * Risponde all richiesta GET /data
		 * @return ArrayList di oggetti Record
		 */
		
		@RequestMapping(value = "data", method=RequestMethod.GET)
		public ArrayList<Record> getDataWithGet() {
			
			return DatabaseClass.getRecords();
		}
		
		/**
		 * Risponde all richiesta POST /data
		 * @param     filter contiene un JSON con i filtri da applicare al dataset.
		 * @return    ArrayList di oggetti Record filtrati.
		 * @throws    InternalGeneralException se vengono generati errori generali interni al server.
		 * @throws    FilterNotFoundException se vengono generati errori di Filtro non trovato.
		 * @throws    FilterIllegalArgumentException se vengono generati errori di parametro non valido in ingresso al filtro.
		 */
		
		@RequestMapping(value = "data", method=RequestMethod.POST)

		public ArrayList<Record> getDataWithPost(@RequestBody Object filter) 
	    throws InternalGeneralException, FilterNotFoundException, FilterIllegalArgumentException {

			
			return JsonParser.jsonParserColumn(filter);
		}
		
		/**
		 * Risponde all richiesta POST /stats
		 * @param column rappresenta il campo sul quale si vuole effettuare la statistica. 
		 * @param filter contentiene un JSON con i filtri da applicare al dataset.
		 * @return un oggetto stats, che contiene le statistiche richieste
		 * @throws    InternalGeneralException se vengono generati errori generali interni al server.
		 * @throws    StatsNotFoundException se vengono generati errori di richiesta su colonna non esistente 
		 * @throws    FilterNotFoundException se vengono generati errori di Filtro non trovato.
		 * @throws    FilterIllegalArgumentException se vengono generati errori di parametro non valido in ingresso al filtro.
		 */
		
		@RequestMapping(value = "stats", method=RequestMethod.POST)
		public Stats getStatsWithPost(@RequestParam(value = "field") String column,
									  @RequestBody Object filter) 
		throws InternalGeneralException, StatsNotFoundException, FilterNotFoundException, FilterIllegalArgumentException {
			
			ArrayList<Record> filteredArray = JsonParser.jsonParserColumn(filter);
			StatsCalculator sc = StatsService.instanceStatsCalculator(column, filteredArray);
			return sc.run();
		}
		
		/**
		 * Risponde all richiesta GET /stats
		 * @param column rappresenta il campo sul quale si vuole effettuare la statistica. 
		 * @return un oggetto stats, che contiene le statistiche richieste
		 * @throws    InternalGeneralException se vengono generati errori generali interni al server.
		 * @throws    StatsNotFoundException se vengono generati errori di richiesta su colonna non esistente 
		 * @throws    FilterNotFoundException se vengono generati errori di Filtro non trovato.
		 * @throws    FilterIllegalArgumentException se vengono generati errori di parametro non valido in ingresso al filtro.
		 */
		
		@RequestMapping(value = "stats", method=RequestMethod.GET)
		public Stats getStats(@RequestParam(value = "field") String column) 
		throws InternalGeneralException, StatsNotFoundException, FilterNotFoundException, FilterIllegalArgumentException {

			
			ArrayList<Record> records = DatabaseClass.getRecords();
			StatsCalculator sc = StatsService.instanceStatsCalculator(column, records);
			return sc.run();
		}
	}