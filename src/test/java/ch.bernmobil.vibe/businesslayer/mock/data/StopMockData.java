package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.FareRule;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop.WheelchairBoarding;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TimeZone;

public class StopMockData {
    public static long[] ids = {
        1,
        2,
        3
    };

    public static String[] stopCodes = {
        "stopCode1",
        "stopCode2",
        "stopCode3"
    };

    public static String[] stopNames = {
        "stopName1",
        "stopName2",
        "stopName3"
    };

    public static String[] stopDescriptions = {
        "description 1",
        "description 2",
        "description 3",
    };

    public static double[] stopLatitudes = {
        1,
        2,
        3
    };

    public static double[] stopLongitudes = {
        1,
        2,
        3
    };

    public static FareRule[] zones = {
        new FareRule(),
        new FareRule(),
        new FareRule()
    };

    public static String[] stopUrls = {
        "http://www.url1.ch",
        "http://www.url2.ch",
        "http://www.url3.ch",
    };

    public static String[] locationTypes = {
        "location 1",
        "location 2",
        "location 3"
    };

    public static String[] parentStations = {
        "parent 1",
        "parent 2",
        "parent 3"
    };

    public static TimeZone[] stopTimezones = {
        TimeZone.getDefault(),
        TimeZone.getDefault(),
        TimeZone.getDefault()
    };

    public static WheelchairBoarding[] wheelchairBoardings = {
        WheelchairBoarding.NO_INFORMATION,
        WheelchairBoarding.NOT_ACCESSIBLE,
        WheelchairBoarding.SOME_ACCESSIBLE_VEHICLES
    };


    public static Stop create(int index) {
        Stop stop = new Stop(){{
            setStopId(ids[index]);
            setStopName(stopNames[index]);
            setStopLatitude(stopLatitudes[index]);
            setStopLongitude(stopLongitudes[index]);
            setLocationType(locationTypes[index]);
            setParentStation(parentStations[index]);
            setStopCode(stopCodes[index]);
            setStopDescription(stopDescriptions[index]);
            setZone(zones[index]); //TODO: link to another mock item?
            setStopTimezone(stopTimezones[index]);
            setWheelchairBoarding(wheelchairBoardings[index]);
        }};

        try { stop.setStopUrl(new URL(StopMockData.stopUrls[index]));
        } catch (MalformedURLException e) { e.printStackTrace(); }

        return stop;
    }

}
