package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Area;
import java.util.ArrayList;
import java.util.List;

public class AreaMockData {
    private static List<Area> dataSource;

    private static long[] ids = {

    };

    private static String[] names = {
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
