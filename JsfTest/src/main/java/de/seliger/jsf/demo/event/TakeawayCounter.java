package de.seliger.jsf.demo.event;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.inject.Named;

import org.apache.log4j.Logger;

@Named
@SessionScoped
public class TakeawayCounter implements Serializable {

    private static final long serialVersionUID = 2168558462804551689L;
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

    public void resetTakeawayCounter() {
        this.counter = 0;
    }

}
