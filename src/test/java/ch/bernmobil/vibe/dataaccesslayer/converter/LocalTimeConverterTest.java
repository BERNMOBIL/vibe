package ch.bernmobil.vibe.dataaccesslayer.converter;

import org.junit.Test;

import java.sql.Time;
import java.time.LocalTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LocalTimeConverterTest {
    @Test
    public void stringToLocalTime() throws Exception{
        LocalTimeConverter converter = new LocalTimeConverter();
        String timeString = "12:02:03";
        Time time = Time.valueOf(timeString);
        LocalTime expected = LocalTime.parse(timeString);
        LocalTime result = converter.convertToEntityAttribute(time);
        assertThat(result, is(expected));
    }

    @Test
    public void localTimeToString() throws Exception {
        LocalTimeConverter converter = new LocalTimeConverter();
        String string = "08:22:59";
        Time expected = Time.valueOf(string);
        LocalTime time = LocalTime.parse(string);
        Time result = converter.convertToDatabaseColumn(time);
        assertThat(result, is(expected));
    }
}
