package com.nbc.testautomation.chillertv.data;

import com.nbc.testautomation.chillertv.businessobject.Event;
import com.nbc.testautomation.chillertv.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;

public class ApiEventRepository implements EventRepository {

    @Autowired
    protected EventService eventApiService;

    public Event getById(String id) {
        return eventApiService.getEventById(id);
    }
}
