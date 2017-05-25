package ch.bernmobil.vibe.testenvironment.data;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Journey;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JourneyMockData {
    private LocalDateTime update = LocalDateTime.parse("2017-04-29T10:15:30");
    private final RouteMockData routeMockData;
    private List<Journey> dataSource = new ArrayList<>(3);

    @Autowired
    public JourneyMockData(RouteMockData routeMockData) {
        this.routeMockData = routeMockData;
        IntStream.range(0, idList.length)
            .forEach(i -> dataSource.add(create(i)));
    }


    private UUID[] idList = {
            UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
            UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
            UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private String[] headsignList = {
        "Unterägeri, Zentrum",
        "Küssnacht, Bhf",
        "Zug, Postplatz",
    };

    private Journey create(int index) {
        Journey j = new Journey();
        j.setId(idList[index]);
        j.setHeadsign(headsignList[index]);
        j.setRoute(routeMockData.get(index));
        j.setUpdateTimestamp(update);
        //TODO: update
        return j;
    }

    public Journey get(int index) {
        return dataSource.get(index);
    }

    public List<Journey> getDataSource() {
        return dataSource;
    }

}
