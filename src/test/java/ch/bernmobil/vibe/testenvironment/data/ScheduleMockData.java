package ch.bernmobil.vibe.testenvironment.data;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Schedule;
import java.time.LocalTime;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;

public class ScheduleMockData extends TestData<Schedule> {
    private final StopMockData stopMockData;
    private final JourneyMockData journeyMockData;

    private UUID[] ids = {
            UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
            UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
            UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private String[] platforms = {
        "1",
        "2",
        "3",
    };

    private LocalTime[] plannedArrivals = {
        LocalTime.parse("15:47:00"),
        LocalTime.parse("18:04:00"),
        LocalTime.parse("15:46:00"),
    };

    private LocalTime[] plannedDepartures = {
        LocalTime.parse("15:47:00"),
        LocalTime.parse("18:04:00"),
        LocalTime.parse("15:46:00"),
    };

    @Autowired
    public ScheduleMockData(StopMockData stopMockData, JourneyMockData journeyMockData) {
        this.stopMockData = stopMockData;
        this.journeyMockData = journeyMockData;
        dataSource = IntStream.range(0, ids.length)
            .mapToObj(this::create)
            .collect(Collectors.toList());
    }

    private Schedule create(int index) {
        Schedule s = new Schedule();
        s.setId(ids[index]);
        s.setPlatform(platforms[index]);
        s.setPlannedArrival(plannedArrivals[index]);
        s.setPlannedDeparture(plannedDepartures[index]);
        s.setStop(stopMockData.get(index));
        s.setJourney(journeyMockData.get(index));
        return s;
    }
}
