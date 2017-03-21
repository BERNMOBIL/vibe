package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.CalendarDate;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.CalendarException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarExceptionMockData {
    private static List<CalendarException> dataSource;

    public static long[] ids = {
    };

    public static LocalDate[] dates = {
    };
    public static String[] types = { //TODO: Link correctly
    };

    public static CalendarDate[] calendarDates = { //TODO: Link
    };

    public static CalendarException create(int index) {
        return new CalendarException(){{
            setId(ids[index]);
            setDate(dates[index]);
            setType(types[index]);
            setCalendar_date(calendarDates[index]);
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
