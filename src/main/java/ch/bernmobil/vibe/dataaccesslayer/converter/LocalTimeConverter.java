package ch.bernmobil.vibe.dataaccesslayer.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;
import java.time.LocalTime;

/**
 * Converter class to convert {@link java.time.LocalTime} to and from {@link java.sql.Time}.
 */
@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time>{
    /**
     * Convert {@link java.time.LocalTime} to {@link java.sql.Time}.
     * @param attribute An instance of {@link java.time.LocalTime} which could be null.
     * @return The converted {@link java.sql.Time} instance.
     */
    @Override
    public Time convertToDatabaseColumn(LocalTime attribute) {
        if(attribute == null) {
            return null;
        }
        return Time.valueOf(attribute);
    }

    /**
     * Convert {@link java.sql.Time} to {@link java.time.LocalTime}.
     * @param dbData An instance of {@link java.sql.Time} which could be null.
     * @return The converted {@link java.time.LocalTime} instance.
     */
    @Override
    public LocalTime convertToEntityAttribute(Time dbData) {
        if(dbData == null) {
            return null;
        }
        return dbData.toLocalTime();
    }

}
