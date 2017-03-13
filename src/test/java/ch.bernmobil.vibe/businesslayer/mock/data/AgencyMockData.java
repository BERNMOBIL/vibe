package ch.bernmobil.vibe.businesslayer.mock.data;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Agency;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.FareRule;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop;
import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity.Stop.WheelchairBoarding;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.TimeZone;

public class AgencyMockData {
    public static long[] ids = {
        1,
        2,
        3
    };

    public static String[] names = {
        "name 1",
        "name 2",
        "name 3",
    };

    public static String[] urls = {
        "www.url1.ch",
        "www.url2.ch",
        "www.url3.ch",
    };

    public static String[] timezones = {
        "timezone 1",
        "timezone 2",
        "timezone 3",
    };

    public static String[] langs = {
        "lang 1",
        "lang 2",
        "lang 3",
    };

    public static String[] phones = {
        "phone 1",
        "phone 2",
        "phone 3",
    };


    public static Agency create(int index) {
        return new Agency(){{
            setId(ids[index]);
            setName(names[index]);
            setUrl(urls[index]);
            setTimezone(timezones[index]);
            setLang(langs[index]);
            setPhone(phones[index]);
        }};
    }

}
