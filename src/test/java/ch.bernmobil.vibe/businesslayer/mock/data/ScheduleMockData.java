package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Journey;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Schedule;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ScheduleMockData {
    private static List<Schedule> dataSource;

    private static UUID[] ids = {
            UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
            UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
            UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private static String[] platforms = {
        "Plattform 1",
        "Plattform 2",
        "Plattform 3",
    };

    private static LocalTime[] planned_arrivals = { //TODO: Link correctly
        LocalTime.parse("15:47:00"),
        LocalTime.parse("18:04:00"),
        LocalTime.parse("15:46:00"),
    };

    private static LocalTime[] planned_departures = { //TODO: Link correctly
        LocalTime.parse("15:47:00"),
        LocalTime.parse("18:04:00"),
        LocalTime.parse("15:46:00"),
    };

    private static Stop[] stops = { //TODO: Link
        StopMockData.getDataSource().get(0),
        StopMockData.getDataSource().get(1),
        StopMockData.getDataSource().get(2)
    };
    private static Journey[] journeys = { //TODO: Link
        null,
        null,
        null,
    };

    private static Schedule create(int index) {
        return new Schedule(){{
            setId(ids[index]);
            setPlatform(platforms[index]);
            setPlannedArrival(planned_arrivals[index]);
            setPlannedDeparture(planned_departures[index]);
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
