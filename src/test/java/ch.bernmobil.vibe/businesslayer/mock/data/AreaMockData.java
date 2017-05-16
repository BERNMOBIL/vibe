package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.shared.entity.hibernate.Area;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AreaMockData {
    private static List<Area> dataSource;

    private static UUID[] ids = {
        UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
        UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
        UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private static String[] names = {
            "Area 1", "Area 2", "Area 3"
    };


    private static Area create(int index) {
        return new Area(){{
            setId(ids[index]);
            setName(names[index]);
        }};
    }

    public static List<Area> getDataSource() {
        if(dataSource == null) {
            dataSource = new ArrayList<>();

            for(int i = 0; i < ids.length; i++) {
                dataSource.add(create(i));
            }
        }

        return dataSource;
    }

}
