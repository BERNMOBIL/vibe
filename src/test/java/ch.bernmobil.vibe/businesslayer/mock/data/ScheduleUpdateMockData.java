package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.shared.entity.hibernate.Schedule;
import ch.bernmobil.vibe.shared.entity.hibernate.ScheduleUpdate;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ScheduleUpdateMockData {
    private static List<ScheduleUpdate> dataSource;

    private static UUID[] ids = {
            UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
            UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
            UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
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
