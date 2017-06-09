package ch.bernmobil.vibe.testenvironment.data;

import ch.bernmobil.vibe.dataaccesslayer.entity.CalendarDate;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalendarDateMockData extends TestData<CalendarDate> {
    private final LocalDateTime update = LocalDateTime.parse("2017-04-29T10:15:30");
    private final JourneyMockData journeyMockData;

    private final UUID[] idList = {
            UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
            UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
            UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private final LocalDate[] validFromList = {
        LocalDate.now(),
        LocalDate.now().plusDays(5),
        LocalDate.now().plusDays(5),
    };

    private final LocalDate[] validUntilList = {
        LocalDate.now(),
        LocalDate.now().plusDays(5),
        LocalDate.now().plusDays(5),
    };

    @Autowired
    public CalendarDateMockData(JourneyMockData journeyMockData) {
        this.journeyMockData = journeyMockData;
        dataSource = IntStream.range(0, idList.length)
            .mapToObj(this::create)
            .collect(Collectors.toList());
    }


    private CalendarDate create(int index) {
        CalendarDate d = new CalendarDate();
        d.setId(idList[index]);
        d.setValidFrom(validFromList[index]);
        d.setValidUntil(validUntilList[index]);
        d.setJourney(journeyMockData.get(index));
        d.setUpdateTimestamp(update);
        return d;
    }
}
