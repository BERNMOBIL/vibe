package ch.bernmobil.vibe.testenvironment.data;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Stop;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StopMockData {
    private LocalDateTime update = LocalDateTime.parse("2017-04-29T10:15:30");
    private List<Stop> dataSource;
    private AreaMockData areaMockData;

    @Autowired
    public StopMockData(AreaMockData areaMockData) {
        this.areaMockData = areaMockData;
        dataSource = IntStream.range(0, idList.length)
            .mapToObj(this::create)
            .collect(Collectors.toList());
    }

    private UUID[] idList = {
            UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
            UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
            UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private String[] nameList = {
        "Rapperswil, Scheidweg",
        "Rapperswil, Bahnhof",
        "Jona, Kreuz"
    };

    private Stop create(int index) {
        Stop s = new Stop();
        s.setId(idList[index]);
        s.setName(nameList[index]);
        s.setArea(areaMockData.get(index));
        s.setUpdateTimestamp(update);
        return s;
    }

    public Stop get(int index) {
        return dataSource.get(index);
    }

    public List<Stop> getDataSource() {
        return dataSource;
    }

}
