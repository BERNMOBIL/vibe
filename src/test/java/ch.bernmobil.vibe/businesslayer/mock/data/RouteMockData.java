package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Route;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class RouteMockData {
    private static List<Route> dataSource;

    private static UUID[] ids = {
            UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
            UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
    };

    private static Integer[] types = {
        3,
        3
    };

    private static Route create(int index) {
        return new Route(){{
            setId(ids[index]);
            setType(types[index]);
        }};
    }


    public static List<Route> getDataSource() {
        if(dataSource == null) {
            dataSource = new ArrayList<>();

            for(int i = 0; i < ids.length; i++) {
                dataSource.add(create(i));
            }
        }

        return dataSource;
    }

}
