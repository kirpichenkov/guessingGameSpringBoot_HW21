package ru.LearnUp.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.LearnUp.anotation.LogMethod;
import ru.LearnUp.anotation.WorkTime;

@Component
public class EventPub implements ApplicationContextAware {
private ApplicationContext context;

    @LogMethod
    @WorkTime
    public void pubEvent(String event) {
        context.publishEvent(new Event(event));
}
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
