package com.nbc.testautomation.chillertv.service;

import com.nbc.testautomation.chillertv.businessobject.Event;
import com.nbc.testautomation.chillertv.page.EventDetailsPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link EventService} for retrieving the data about event from UI
 */
@Component
@Scope("prototype")
public class EventUiService implements EventService {

    @Autowired
    protected EventDetailsPage eventDetailsPage;

    public Event getEventById(String eventId) {
        String eventTitle;
        String eventImage;
        String eventLongDescription;

        eventDetailsPage.navigate(eventId);
        eventTitle = eventDetailsPage.getEventTitle().getText();
        eventImage = eventDetailsPage.getEventImage().getSource().toString();
        eventLongDescription = eventDetailsPage.getEventLongDescription().getText();

        Event event = new Event();
        event.setId(eventId);
        event.setTitle(eventTitle);
        event.setImageUrl(eventImage);
        event.setLongDescription(eventLongDescription);

        return event;
    }
}
