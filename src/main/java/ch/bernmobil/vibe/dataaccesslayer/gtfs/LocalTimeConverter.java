package ch.bernmobil.vibe.dataaccesslayer.gtfs;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.LocalTime;

@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, String>{
    @Override
    public String convertToDatabaseColumn(LocalTime attribute) {
        if(attribute == null) {
            return null;
        }
        return attribute.toString();
    }

    @Override
    public LocalTime convertToEntityAttribute(String dbData) {
        if(dbData == null) {
            return null;
        }
        String[] digits = dbData.split(":");
        int hour = Integer.parseInt(digits[0]);
        if(hour > 33) {
            digits[0] = Integer.toString(hour - 24);
        }
        else if(hour > 23) {
            digits[0] = String.format("0%s", Integer.toString(hour - 24));
        }
        String newDbData = String.format("%s:%s:%s", digits[0], digits[1], digits[2]);
        return LocalTime.parse(newDbData);
    }
}
