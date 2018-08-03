package com.nbc.testautomation.chillertv.service;

import com.nbc.testautomation.chillertv.businessobject.Event;
import com.nbc.testautomation.chillertv.support.ObjectConverter;
import com.nbc.testautomation.chillertv.support.api.BaseApiService;
import com.nbc.testautomation.chillertv.support.api.pojo.event.EventDetails;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link EventService} for retrieving the data about event from API
 */
@Component
@Scope("prototype")
public class EventApiService extends BaseApiService implements EventService {

    public Event getEventById(String eventId) {
        String path = String.format(apiEndpoints.getEventDetails(), eventId);

        EventDetails eventDetails = httpProvider.get(environmentConfiguration.getApiHost(), path, EventDetails.class);
        return new ObjectConverter().toEvent(eventDetails);
    }
}
