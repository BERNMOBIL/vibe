package ch.bernmobil.vibe.dataaccesslayer.converter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import org.junit.Test;


public class LocalDateConverterTest {
    @Test
    public void localDateToDate() throws Exception {
        LocalDateConverter converter = new LocalDateConverter();

        Date expectedResult = new Date(new SimpleDateFormat("dd-MM-yyyy").parse("13-03-2017").getTime());
        LocalDate localDate = LocalDate.parse("2017-03-13");

        Date result = converter.convertToDatabaseColumn(localDate);

        assertThat(result, is(expectedResult));
    }

    @Test
    public void dateToLocalDate() throws Exception{
        LocalDateConverter converter = new LocalDateConverter();

        Date date = new Date(new SimpleDateFormat("dd-MM-yyyy").parse("13-03-2017").getTime());
        LocalDate expectedResult = LocalDate.parse("2017-03-13");

        LocalDate result = converter.convertToEntityAttribute(date);

        assertThat(result, is(expectedResult));
    }

}
