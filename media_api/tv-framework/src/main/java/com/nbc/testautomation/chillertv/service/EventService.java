package com.nbc.testautomation.chillertv.service;

import com.nbc.testautomation.chillertv.businessobject.Event;

/**
 * Service for retrieving the data about event via UI or API
 */
public interface EventService {

    Event getEventById(String eventId);
}
