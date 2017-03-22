package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.JourneyDistruption;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class JourneyDisruptionMockData {
    private static List<JourneyDistruption> dataSource;

    private static long[] ids = {
        1,
        2,
        3
    };

    private static String[] messages = {
        "msg1",
        "msg2",
        "msg3",
    };
    private static Timestamp[] starts = { //TODO: Link correctly
        new Timestamp(0),
        new Timestamp(0),
        new Timestamp(0),
    };

    private static Timestamp[] planned_ends = { //TODO: Link
        new Timestamp(0),
        new Timestamp(0),
        new Timestamp(0),
    };

    private static JourneyDistruption create(int index) {
        return new JourneyDistruption(){{
            setId(ids[index]);
            setMessage(messages[index]);
            setStart(starts[index]);
            setPlanned_end(planned_ends[index]);
        }};
    }


    public static List<JourneyDistruption> getDataSource() {
        if(dataSource == null) {
            dataSource = new ArrayList<>();

            for(int i = 0; i < ids.length; i++) {
                dataSource.add(create(i));
            }
        }

        return dataSource;
    }

}