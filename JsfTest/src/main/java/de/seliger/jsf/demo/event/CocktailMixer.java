package de.seliger.jsf.demo.event;

import javax.enterprise.event.Observes;
import javax.inject.Named;

import org.apache.log4j.Logger;

@Named
public class CocktailMixer {
	
	private final static Logger LOGGER = Logger.getLogger(CocktailMixer.class);

	public CocktailMixer() {
	}

	public void mixCocktail(@Observes CocktailOrder order) {
		LOGGER.info("I'm mixing the Cocktail: "+ order.getName());
	}
	
}
