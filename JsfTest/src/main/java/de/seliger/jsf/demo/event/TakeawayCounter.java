package de.seliger.jsf.demo.event;

import javax.enterprise.event.Observes;
import javax.inject.Named;

import org.apache.log4j.Logger;

@Named
public class TakeawayCounter {

    private final static Logger LOGGER = Logger.getLogger(TakeawayCounter.class);
    private int counter = 0;

    public TakeawayCounter() {
    }

    public void count(@Observes @Takeaway CocktailOrder order) {
        LOGGER.info("New Takeaway-Cocktail: " + order.getName());
        this.counter++;
    }

    public int getTakeawayCounter() {
        return counter;
    }
}
