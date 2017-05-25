package ch.bernmobil.vibe.testenvironment.data;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Area;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

public class AreaMockData {
    private List<Area> dataSource = new ArrayList<>(3);
    private LocalDateTime update = LocalDateTime.parse("2017-04-29T10:15:30");

    public AreaMockData() {
        IntStream.range(0, idList.length)
            .forEach(i -> dataSource.add(create(i)));
    }
    private UUID[] idList = {
        UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
        UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
        UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private String[] nameList = {
            "Area 1", "Area 2", "Area 3"
    };

    private Area create(int index) {
        Area a = new Area();
        a.setId(idList[index]);
        a.setName(nameList[index]);
        a.setUpdateTimestamp(update);
        return a;
    }

    public Area get(int index) {
        return dataSource.get(index);
    }

    public List<Area> getDataSource() {
        return dataSource;
    }

    public void setUpdate(LocalDateTime update) {
        this.update = update;
    }
}
