package ch.bernmobil.vibe.testenvironment.data;

import ch.bernmobil.vibe.dataaccesslayer.entitiy.Route;
import ch.bernmobil.vibe.dataaccesslayer.entitiy.Route.RouteType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteMockData {
    private List<Route> dataSource = new ArrayList<>();

    @Autowired
    public RouteMockData() {
        IntStream.range(0, idList.length)
            .forEach(i -> dataSource.add(create(i)));
    }

    private UUID[] idList = {
        UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
        UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
        UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private String[] lineList = {
        "622", "993", "995"
    };

    private RouteType[] typeList = {
        RouteType.BUS,
        RouteType.BUS,
        RouteType.BUS
    };

    private Route create(int index) {
        Route r = new Route();
        r.setId(idList[index]);
        r.setLine(lineList[index]);
        r.setType(typeList[index]);
        //TODO: update
        return r;
    }

    public Route get(int index) {
        return dataSource.get(index);
    }

    public List<Route> getDataSource() {
        return dataSource;
    }

}
