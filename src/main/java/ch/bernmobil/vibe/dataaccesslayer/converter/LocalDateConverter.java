package ch.bernmobil.vibe.dataaccesslayer.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;
import java.time.LocalDate;

/**
 * Converter class to convert {@link java.time.LocalDate} to and from {@link java.sql.Date}.
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Date> {
    /**
     * Convert {@link java.time.LocalDate} to {@link java.sql.Date}.
     * @param attribute An instance of {@link java.time.LocalDate} which could be null.
     * @return The converted {@link java.sql.Date} instance.
     */
    @Override
    public Date convertToDatabaseColumn(LocalDate attribute) {
        if(attribute != null) {
            return Date.valueOf(attribute);
        }
        return null;
    }

    /**
     * Convert {@link java.sql.Date} to {@link java.time.LocalDate}.
     * @param dbData An instance of {@link java.sql.Date} which could be null.
     * @return The converted {@link java.time.LocalDate} instance.
     */
    @Override
    public LocalDate convertToEntityAttribute(Date dbData) {
        if(dbData != null) {
            return dbData.toLocalDate();
        }
        return null;
    }
}
