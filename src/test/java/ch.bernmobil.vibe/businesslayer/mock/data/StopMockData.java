package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Area;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StopMockData {
    private static List<Stop> dataSource;

    private static UUID[] ids = {
            UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
            UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
            UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private static String[] names = { //TODO: Link correctly
        "Abtwil AG, Auwerstrasse",
        "Abtwil AG, Hofmatt",
        "Abtwil AG, Langegg"
    };

    private static Area[] areas = { //TODO: Link
        null,
        null,
        null
    };


    private static Stop create(int index) {
        return new Stop(){{
            setId(ids[index]);
            setName(names[index]);
            setArea(areas[index]);
        }};
    }


    public static List<Stop> getDataSource() {
        if(dataSource == null) {
            dataSource = new ArrayList<>();

            for(int i = 0; i < ids.length; i++) {
                dataSource.add(create(i));
            }
        }

        return dataSource;
    }

}
