package ch.bernmobil.vibe.testenvironment.data;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.ScheduleUpdate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class ScheduleUpdateMockData {

    private static List<ScheduleUpdate> dataSource = new ArrayList<>(3);
    private final ScheduleMockData scheduleMockData;

    public ScheduleUpdateMockData(ScheduleMockData scheduleMockData) {
        this.scheduleMockData = scheduleMockData;
        IntStream.range(0, idList.length)
            .forEach(i -> dataSource.add(create(i)));
    }

    private UUID[] idList = {
        UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
        UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
        UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private LocalTime[] actualArrivalList = {
        LocalTime.now(),
        LocalTime.now(),
        LocalTime.now()
    };

    private LocalTime[] actualDepartureList = {
        LocalTime.now(),
        LocalTime.now(),
        LocalTime.now()
    };

    private ScheduleUpdate create(int index) {
        ScheduleUpdate s = new ScheduleUpdate();
        s.setId(idList[index]);
        s.setActualArrival(actualArrivalList[index]);
        s.setActualDeparture(actualDepartureList[index]);
        s.setSchedule(scheduleMockData.get(index));
        return s;
    }

    public List<ScheduleUpdate> getDataSource() {
        return dataSource;
    }

    public ScheduleUpdate get(int index) {
        return dataSource.get(index);
    }

}
