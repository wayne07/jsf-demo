package de.seliger.jsf.demo.event;

import javax.enterprise.event.Observes;

import org.apache.log4j.Logger;

public class EventLogger {

    private final static Logger LOGGER = Logger.getLogger(EventLogger.class);

    public void logEvent(@Observes Object event) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Event erhalten von: " + event.getClass().getName());
        } else {
            LOGGER.warn("Event erhalten von: " + event.getClass().getName());
        }
    }
}
