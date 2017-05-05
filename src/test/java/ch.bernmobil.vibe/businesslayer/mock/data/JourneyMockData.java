package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Journey;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Route;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JourneyMockData {
    private static List<Journey> dataSource;

    private static UUID[] ids = {
            UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
            UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
            UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private static String[] headsigns = {
        "Unterägeri, Zentrum",
        "Küssnacht, Bhf",
        "Zug, Postplatz",
    };

    private static Route[] routes = { //TODO: Link correctly
        RouteMockData.getDataSource().get(0),
        RouteMockData.getDataSource().get(0),
        RouteMockData.getDataSource().get(1),
    };

    private static Journey create(int index) {
        return new Journey(){{
            setId(ids[index]);
            setHeadsign(headsigns[index]);
            setRoute(routes[index]);
        }};
    }


    public static List<Journey> getDataSource() {
        if(dataSource == null) {
            dataSource = new ArrayList<>();

            for(int i = 0; i < ids.length; i++) {
                dataSource.add(create(i));
            }
        }

        return dataSource;
    }

}
