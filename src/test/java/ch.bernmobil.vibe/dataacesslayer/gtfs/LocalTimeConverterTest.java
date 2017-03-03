package ch.bernmobil.vibe.dataacesslayer.gtfs;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.LocalTimeConverter;
import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LocalTimeConverterTest {
    @Test
    public void stringToLocalTime() throws Exception{
        LocalTimeConverter converter = new LocalTimeConverter();
        String timeString = "12:02:03";
        LocalTime expected = LocalTime.parse(timeString);
        LocalTime result = converter.convertToEntityAttribute(timeString);
        assertThat(result, is(expected));
    }

    @Test
    public void hour24ToLocalTime() throws Exception {
        LocalTimeConverter converter = new LocalTimeConverter();
        LocalTime expected = LocalTime.parse("00:02:03");
        LocalTime result = converter.convertToEntityAttribute("24:02:03");
        assertThat(result, is(expected));
    }

    @Test
    public void hour34ToLocalTime() throws Exception {
        LocalTimeConverter converter = new LocalTimeConverter();
        LocalTime expected = LocalTime.parse("10:02:03");
        LocalTime result = converter.convertToEntityAttribute("34:02:03");
        assertThat(result, is(expected));
    }

    @Test
    public void localTimeToString() throws Exception {
        LocalTimeConverter converter = new LocalTimeConverter();
        String expected = "08:22:59";
        LocalTime time = LocalTime.parse(expected);
        String result = converter.convertToDatabaseColumn(time);
        assertThat(result, is(expected));
    }

    @Test
    public void timeStringShort() throws Exception {
        LocalTimeConverter converter = new LocalTimeConverter();
        String timeString = "04:40";
        LocalTime expected = LocalTime.parse(timeString);
        LocalTime actual = converter.convertToEntityAttribute(timeString);
        assertThat(expected, is(actual));
    }
}
