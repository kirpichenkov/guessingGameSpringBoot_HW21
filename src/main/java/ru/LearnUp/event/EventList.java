package ru.LearnUp.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class EventList implements ApplicationListener<Event> {
    private static final Logger log = LoggerFactory.getLogger(EventList.class);
    @Override
    public void onApplicationEvent(Event event) {
        log.info(event.getData());
    }
}
