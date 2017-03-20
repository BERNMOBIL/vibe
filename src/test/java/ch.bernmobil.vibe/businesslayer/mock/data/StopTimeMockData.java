package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.StopTime;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.StopTime.DropOffType;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.StopTime.PickupType;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.StopTime.Timepoint;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Trip;
import java.time.LocalTime;

public class StopTimeMockData {
    public static long[] ids = {
        1,
        2,
        3
    };

    public static Trip[] trips = {
        new Trip(),
        new Trip(),
        new Trip()
    };

    public static LocalTime[] arrivalTimes = {
        LocalTime.now(),
        LocalTime.now(),
        LocalTime.now()
    };

    public static LocalTime[] departureTimes = {
        LocalTime.now(),
        LocalTime.now(),
        LocalTime.now()
    };

    public static Stop[] stops = {
        new Stop(),
        new Stop(),
        new Stop()
    };

    public static int[] stopSequences = {
        1,
        2,
        3
    };

    public static PickupType[] pickupTypes = {
        PickupType.NO_PICKUP_AVAILABLE,
        PickupType.PHONE_AGENCY_REQUEST_PICKUP,
        PickupType.COORDINATE_WITH_DRIVER
    };

    public static DropOffType[] dropOffTypes = {
        DropOffType.NO_DROP_OFF_AVAILABLE,
        DropOffType.COORDINATE_WITH_DRIVER,
        DropOffType.REGULARLY_SCHEDULED_DROP_OFF
    };

    public static int[] shapeDistTravaleds = {
        1,
        2,
        3
    };

    public static String[] stopHeadsigngs = {
        "Head1",
        "Head2",
        "Head3"
    };

    public static Timepoint[] timepoints = {
        Timepoint.APPROXIMATE,
        Timepoint.EXACT,
        Timepoint.APPROXIMATE
    };

    public static StopTime create(int index) {
        return new StopTime() {{
            setId(ids[index]);
            setTrip(trips[index]);
            setArrivalTime(arrivalTimes[index]);
            setDepartureTime(departureTimes[index]);
            setStop(stops[index]);
            setStopSequence(stopSequences[index]);
            setPickupType(pickupTypes[index]);
            setDropOffType(dropOffTypes[index]);
            setShapeDistTraveled(shapeDistTravaleds[index]);
            setStopHeadsign(stopHeadsigngs[index]);
            setTimepoint(timepoints[index]);
        }};
    }
}
