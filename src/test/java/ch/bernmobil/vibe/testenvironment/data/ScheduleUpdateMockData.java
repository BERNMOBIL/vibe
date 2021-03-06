package ch.bernmobil.vibe.testenvironment.data;

import ch.bernmobil.vibe.dataaccesslayer.entity.ScheduleUpdate;

import java.time.LocalTime;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ScheduleUpdateMockData extends TestData<ScheduleUpdate> {
    private final ScheduleMockData scheduleMockData;

    private final UUID[] idList = {
        UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
        UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
        UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private final LocalTime[] actualArrivalList = {
            LocalTime.parse("15:48:00"),
            LocalTime.parse("18:04:25"),
            LocalTime.parse("15:49:00"),
    };

    private final LocalTime[] actualDepartureList = {
            LocalTime.parse("15:49:00"),
            LocalTime.parse("18:04:30"),
            LocalTime.parse("15:50:00"),
    };

    public ScheduleUpdateMockData(ScheduleMockData scheduleMockData) {
        this.scheduleMockData = scheduleMockData;
        dataSource = IntStream.range(0, idList.length)
            .mapToObj(this::create)
            .collect(Collectors.toList());
    }

    private ScheduleUpdate create(int index) {
        ScheduleUpdate s = new ScheduleUpdate();
        s.setId(idList[index]);
        s.setActualArrival(actualArrivalList[index]);
        s.setActualDeparture(actualDepartureList[index]);
        s.setSchedule(scheduleMockData.get(index));
        return s;
    }
}
