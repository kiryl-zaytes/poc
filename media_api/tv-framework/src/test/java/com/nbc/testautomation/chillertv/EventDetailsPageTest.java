package com.nbc.testautomation.chillertv;

import com.nbc.testautomation.chillertv.businessobject.Event;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class EventDetailsPageTest extends BaseTest {

    public static final String EVENT_ID = "70db102c-52d8-4a78-8cb0-0cdf79713b3f";

    @DataProvider(name = "eventDataProvider")
    public Object[][] getEventData() {
        Event event = eventRepository.getById(EVENT_ID);

        return new Object[][]{
                {event}
        };
    }

    @Test(dataProvider = "eventDataProvider")
    public void verifyEventDetails(Event expectedEvent) {

        Event actualEvent = eventUiService.getEventById(EVENT_ID);

        Assert.assertEquals(actualEvent, expectedEvent);
    }

}
