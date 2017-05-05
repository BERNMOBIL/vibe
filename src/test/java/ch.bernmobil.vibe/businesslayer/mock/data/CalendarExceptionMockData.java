package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.CalendarDate;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.CalendarException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CalendarExceptionMockData {
    private static List<CalendarException> dataSource;

    private static UUID[] ids = {

    };

    private static LocalDate[] dates = {
    };
    private static String[] types = { //TODO: Link correctly
    };

    private static CalendarDate[] calendarDates = { //TODO: Link
    };

    private static CalendarException create(int index) {
        return new CalendarException(){{
            setId(ids[index]);
            setDate(dates[index]);
            setType(types[index]);
            setCalendarDate(calendarDates[index]);
        }};
    }


    public static List<CalendarException> getDataSource() {
        if(dataSource == null) {
            dataSource = new ArrayList<>();

            for(int i = 0; i < ids.length; i++) {
                dataSource.add(create(i));
            }
        }

        return dataSource;
    }

}
