package ch.bernmobil.vibe.dataaccesslayer.converter;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.sql.SQLException;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.postgresql.util.PGobject;

/**
 * Class to convert a PostgreSQL JSON object wrapped in a {@link PGobject}
 * into a {@link JsonObject}. PostgresSQL uses its own Java objects to map its specific types, as the
 * PostgreSQL Json type.
 */
@Converter
public class JsonObjectConverter implements AttributeConverter<JsonObject, Object> {
    /**
     * Convert a {@link JsonObject} into a managed {@link PGobject} instance.
     * @param attribute The JSON object which needs to be persisted in the database
     * @return A {@link PGobject}, casted to an object, so JPA can use it.
     */
    @Override
    public Object convertToDatabaseColumn(JsonObject attribute) {
        try {
            PGobject out = new PGobject();
            out.setType("json");
            out.setValue(attribute.toString());
            return out;
        } catch (SQLException e) {
            throw new IllegalArgumentException("Unable to serialize JsonObject", e);
        }
    }

    /**
     * Convert a {@link PGobject} as object into a {@link JsonObject}.
     * @param dbData A {@link PGobject} which holds the JSON String from the database.
     * @return The converted {@link JsonObject}.
     */
    @Override
    public JsonObject convertToEntityAttribute(Object dbData) {
        if(dbData instanceof PGobject && "json".equals(((PGobject)dbData).getType())) {
            JsonParser parser = new JsonParser();
            return parser.parse(((PGobject) dbData).getValue()).getAsJsonObject();
        }
        return null;
    }
}
