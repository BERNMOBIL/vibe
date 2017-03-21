package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Area;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import java.util.ArrayList;
import java.util.List;

public class StopMockData {
    private static List<Stop> dataSource;

    public static long[] ids = {
        2,
        4,
        6
    };

    public static String[] names = { //TODO: Link correctly
        "Abtwil AG, Auwerstrasse",
        "Abtwil AG, Hofmatt",
        "Abtwil AG, Langegg"
    };

    public static Area[] areas = { //TODO: Link
        null,
        null,
        null
    };


    public static Stop create(int index) {
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
