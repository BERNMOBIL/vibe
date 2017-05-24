package ch.bernmobil.vibe.dataaccesslayer.converter;

import com.google.gson.JsonObject;
import org.junit.Test;
import org.postgresql.util.PGobject;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JsonObjectConverterTest {
    @Test
    public void pgObjectToJson() throws Exception {
        JsonObject expected = new JsonObject();
        expected.addProperty("testProp", "value");
        PGobject obj = new PGobject();
        obj.setType("json");
        obj.setValue(expected.toString());

        JsonObjectConverter converter = new JsonObjectConverter();
        JsonObject actual = converter.convertToEntityAttribute(obj);

        assertThat(actual, is(expected));
    }

    @Test
    public void jsonToPgObject() throws Exception {
        JsonObject json = new JsonObject();
        json.addProperty("testProp", "value");

        PGobject expected = new PGobject();
        expected.setType("json");
        expected.setValue(json.toString());

        JsonObjectConverter converter = new JsonObjectConverter();
        PGobject actual = (PGobject)converter.convertToDatabaseColumn(json);

        assertThat(actual, is(expected));
    }
}