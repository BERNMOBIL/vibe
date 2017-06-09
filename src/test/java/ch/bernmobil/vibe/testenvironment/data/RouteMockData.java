package ch.bernmobil.vibe.testenvironment.data;

import ch.bernmobil.vibe.dataaccesslayer.entity.Route;
import ch.bernmobil.vibe.dataaccesslayer.entity.Route.RouteType;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RouteMockData extends TestData<Route> {
    private final UUID[] idList = {
        UUID.fromString("635977d7-28be-4cbc-833b-f817fbc47225"),
        UUID.fromString("1b50cc76-83be-4aa0-bde9-74fc188a8978"),
        UUID.fromString("86deb4f8-aaa3-4734-a772-1ee38f3e0344")
    };

    private final String[] lineList = {
        "622", "993", "995"
    };

    private final RouteType[] typeList = {
        RouteType.BUS,
        RouteType.BUS,
        RouteType.BUS
    };

    @Autowired
    public RouteMockData() {
        dataSource = IntStream.range(0, idList.length)
            .mapToObj(this::create)
            .collect(Collectors.toList());
    }

    private Route create(int index) {
        Route r = new Route();
        r.setId(idList[index]);
        r.setLine(lineList[index]);
        r.setType(typeList[index]);
        return r;
    }
}
