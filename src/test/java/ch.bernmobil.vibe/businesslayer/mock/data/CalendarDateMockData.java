package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.CalendarDate;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Journey;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarDateMockData {
    private static List<CalendarDate> dataSource;

    public static long[] ids = {
        1,
        2,
        3
    };

    public static LocalDate[] validFroms = {
        LocalDate.now(),
        LocalDate.now().plusDays(5),
        LocalDate.now().plusDays(5),
    };
    public static LocalDate[] validUntils = {
        LocalDate.now(),
        LocalDate.now().plusDays(5),
        LocalDate.now().plusDays(5),
    };

    public static Journey[] journeys = { //TODO: Link
        JourneyMockData.getDataSource().get(0),
        JourneyMockData.getDataSource().get(1),
        JourneyMockData.getDataSource().get(2),
    };

    public static CalendarDate create(int index) {
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
