package de.seliger.jsf.demo.event;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CocktailModel {

    @Inject
    @Inhouse
    private Event<CocktailOrder> inhouseCocktailOrderEvent;

    @Inject
    @Takeaway
    private Event<CocktailOrder> takeawayCocktailOrderEvent;

    private String cocktailName;

    public void doInhouseOrder() {
        finishOrder(new CocktailOrder(cocktailName), false);
    }

    public void doTakeawayOrder() {
        finishOrder(new CocktailOrder(cocktailName), true);
    }

    private void finishOrder(CocktailOrder cocktailOrder, boolean forTakeaway) {
        if (forTakeaway) {
            takeawayCocktailOrderEvent.fire(cocktailOrder);
        } else {
            inhouseCocktailOrderEvent.fire(cocktailOrder);
        }
    }

    public String getCocktailName() {
        return cocktailName;
    }

    public void setCocktailName(String cocktailName) {
        this.cocktailName = cocktailName;
    }

}
