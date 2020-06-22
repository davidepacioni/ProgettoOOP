package it.univpm.projectSpringBootApp.utility.other;

import it.univpm.projectSpringBootApp.model.PostInstagram;

public interface Filter {

	//restistuisce true se il post è conforme al filtro
	public boolean filter(PostInstagram post);
}
