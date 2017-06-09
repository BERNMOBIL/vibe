package ch.bernmobil.vibe.testenvironment.data;

import ch.bernmobil.vibe.dataaccesslayer.entity.Journey;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JourneyMockData extends TestData<Journey> {
    private final LocalDateTime update = LocalDateTime.parse("2017-04-29T10:15:30");
    private final RouteMockData routeMockData;

    private final UUID[] idList = {
            UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
            UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
            UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };


    private final String[] headsignList = {
        "Unterägeri, Zentrum",
        "Küssnacht, Bhf",
        "Zug, Postplatz",
    };

    @Autowired
    public JourneyMockData(RouteMockData routeMockData) {
        this.routeMockData = routeMockData;
        dataSource = IntStream.range(0, idList.length)
            .mapToObj(this::create)
            .collect(Collectors.toList());
    }

    private Journey create(int index) {
        Journey j = new Journey();
        j.setId(idList[index]);
        j.setHeadsign(headsignList[index]);
        j.setRoute(routeMockData.get(index));
        j.setUpdateTimestamp(update);
        return j;
    }
}
