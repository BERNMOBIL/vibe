package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Journey;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.JourneyDistruption;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleMockData {
    private static List<Schedule> dataSource;

    public static long[] ids = {
        1,
        2,
        3
    };

    public static String[] platforms = {
        "Plattform 1",
        "Plattform 2",
        "Plattform 3",
    };

    public static LocalTime[] planned_arrivals = { //TODO: Link correctly
        LocalTime.parse("15:47:00"),
        LocalTime.parse("18:04:00"),
        LocalTime.parse("15:46:00"),
    };

    public static LocalTime[] planned_departures = { //TODO: Link correctly
        LocalTime.parse("15:47:00"),
        LocalTime.parse("18:04:00"),
        LocalTime.parse("15:46:00"),
    };

    public static Stop[] stops = { //TODO: Link
        StopMockData.getDataSource().get(0),
        StopMockData.getDataSource().get(1),
        StopMockData.getDataSource().get(2)
    };
    public static Journey[] journeys = { //TODO: Link
        null,
        null,
        null,
    };

    public static Schedule create(int index) {
        return new Schedule(){{
            setId(ids[index]);
            setPlatform(platforms[index]);
            setPlanned_arrival(planned_arrivals[index]);
            setPlanned_departure(planned_departures[index]);
            setStop(stops[index]);
            setJourney(journeys[index]);
        }};
    }


    public static List<Schedule> getDataSource() {
        if(dataSource == null) {
            dataSource = new ArrayList<>();

            for(int i = 0; i < ids.length; i++) {
                dataSource.add(create(i));
            }
        }

        return dataSource;
    }

}
