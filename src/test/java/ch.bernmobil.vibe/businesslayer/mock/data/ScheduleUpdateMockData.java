package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.ScheduleUpdate;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ScheduleUpdateMockData {
    private static List<ScheduleUpdate> dataSource;

    private static long[] ids = {
        1,
        2,
        3
    };

    private static Time[] actual_arrivals = { //TODO: Link correctly
        new Time(0),
        new Time(0),
        new Time(0),
    };

    private static Time[] actual_departures = { //TODO: Link
        new Time(0),
        new Time(0),
        new Time(0),
    };
    private static Schedule[] schedules = { //TODO: Link
        null,
        null,
        null
    };

    private static ScheduleUpdate create(int index) {
        return new ScheduleUpdate(){{
            setId(ids[index]);
            setActualArrival(actual_arrivals[index]);
            setActualDeparture(actual_departures[index]);
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
