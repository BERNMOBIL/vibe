package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Journey;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Route;
import java.util.ArrayList;
import java.util.List;

public class JourneyMockData {
    private static List<Journey> dataSource;

    private static long[] ids = {
        27,
        32,
        34
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
