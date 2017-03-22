package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteMockData {
    private static List<Route> dataSource;

    private static long[] ids = {
        21,
        35,
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
