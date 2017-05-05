package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.JourneyDisruption;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class JourneyDisruptionMockData {
    private static List<JourneyDisruption> dataSource;

    private static UUID[] ids = {
            UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
            UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
            UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
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

    private static JourneyDisruption create(int index) {
        return new JourneyDisruption(){{
            setId(ids[index]);
            setMessage(messages[index]);
            setStart(starts[index]);
            setPlannedEnd(planned_ends[index]);
        }};
    }


    public static List<JourneyDisruption> getDataSource() {
        if(dataSource == null) {
            dataSource = new ArrayList<>();

            for(int i = 0; i < ids.length; i++) {
                dataSource.add(create(i));
            }
        }

        return dataSource;
    }

}
