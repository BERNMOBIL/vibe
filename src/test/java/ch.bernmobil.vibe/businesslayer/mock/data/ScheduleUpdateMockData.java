package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Journey;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.ScheduleUpdate;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ScheduleUpdateMockData {
    private static List<ScheduleUpdate> dataSource;

    public static long[] ids = {
        1,
        2,
        3
    };

    public static Time[] actual_arrivals = { //TODO: Link correctly
        new Time(0),
        new Time(0),
        new Time(0),
    };

    public static Time[] actual_departures = { //TODO: Link
        new Time(0),
        new Time(0),
        new Time(0),
    };
    public static Schedule[] schedules = { //TODO: Link
        null,
        null,
        null
    };

    public static ScheduleUpdate create(int index) {
        return new ScheduleUpdate(){{
            setId(ids[index]);
            setActual_arrival(actual_arrivals[index]);
            setActual_departure(actual_departures[index]);
            setSchedule(schedules[index]);
        }};
    }


    public static List<ScheduleUpdate> getDataSource() {
        if(dataSource == null) {
            dataSource = new ArrayList<>();

            for(int i = 0; i < ids.length; i++) {
                dataSource.add(create(i));
            }
        }

        return dataSource;
    }

}
