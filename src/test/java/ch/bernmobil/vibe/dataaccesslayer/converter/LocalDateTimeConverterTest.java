package ch.bernmobil.vibe.dataaccesslayer.converter;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LocalDateTimeConverterTest {
    @Test
    public void LocalDateTimeToTimestamp() throws Exception {
        LocalDateTimeConverter converter = new LocalDateTimeConverter();
        LocalDateTime dateTime = LocalDateTime.parse("2017-04-03T10:15:30");
        Timestamp expected = Timestamp.valueOf("2017-04-03 10:15:30");
        Timestamp actual = converter.convertToDatabaseColumn(dateTime);
        assertThat(actual, is(expected));
    }

    @Test
    public void TimestampToLocalDateTime() throws Exception{
        LocalDateTimeConverter converter = new LocalDateTimeConverter();
        Timestamp timestamp = Timestamp.valueOf("2017-04-03 10:15:30");
        LocalDateTime expected = LocalDateTime.parse("2017-04-03T10:15:30");
        LocalDateTime actual = converter.convertToEntityAttribute(timestamp);
        assertThat(actual, is(expected));
    }
}