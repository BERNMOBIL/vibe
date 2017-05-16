package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.shared.entity.hibernate.CalendarDate;
import ch.bernmobil.vibe.shared.entity.hibernate.Journey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CalendarDateMockData {
    private static List<CalendarDate> dataSource;

    private static UUID[] ids = {
            UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
            UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
            UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private static LocalDate[] validFroms = {
        LocalDate.now(),
        LocalDate.now().plusDays(5),
        LocalDate.now().plusDays(5),
    };
    private static LocalDate[] validUntils = {
        LocalDate.now(),
        LocalDate.now().plusDays(5),
        LocalDate.now().plusDays(5),
    };

    private static Journey[] journeys = { //TODO: Link
        JourneyMockData.getDataSource().get(0),
        JourneyMockData.getDataSource().get(1),
        JourneyMockData.getDataSource().get(2),
    };

    private static CalendarDate create(int index) {
        return new CalendarDate(){{
            setId(ids[index]);
            setValidFrom(validFroms[index]);
            setValidUntil(validUntils[index]);
            setJourney(journeys[index]);
        }};
    }


    public static List<CalendarDate> getDataSource() {
        if(dataSource == null) {
            dataSource = new ArrayList<>();

            for(int i = 0; i < ids.length; i++) {
                dataSource.add(create(i));
            }
        }

        return dataSource;
    }

}
