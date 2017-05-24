package ch.bernmobil.vibe.dataaccesslayer.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * Converter class to convert {@link java.time.LocalDateTime} to and from {@link java.sql.Timestamp}.
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {
    /**
     * Convert {@link java.time.LocalDateTime} to {@link java.sql.Timestamp}.
     * @param attribute An instance of {@link java.time.LocalDateTime} which could be null.
     * @return The converted {@link java.sql.Timestamp} instance.
     */
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        if(attribute == null){
            return null;
        }
        return Timestamp.valueOf(attribute);
    }

    /**
     * Convert {@link java.sql.Timestamp} to {@link java.time.LocalDateTime}.
     * @param dbData An instance of {@link java.sql.Timestamp} which could be null.
     * @return The converted {@link java.time.LocalDateTime} instance.
     */
    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        if(dbData == null){
            return null;
        }
        return dbData.toLocalDateTime();
    }
}
