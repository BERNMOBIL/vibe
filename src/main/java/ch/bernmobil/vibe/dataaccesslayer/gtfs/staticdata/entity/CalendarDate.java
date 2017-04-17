package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.JsonObjectConverter;
import com.google.gson.JsonObject;
import java.time.LocalDate;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CalendarDate {

    @Id
    private long id;
    @Convert(converter = JsonObjectConverter.class)
    private JsonObject days;
    private LocalDate validFrom;
    private LocalDate validUntil;

    @OneToOne
    @JoinColumn(name = "journey")
    private Journey journey;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDate validUntil) {
        this.validUntil = validUntil;
    }

    public Journey getJourney() {
        return journey;
    }

    public void setJourney(Journey journey) {
        this.journey = journey;
    }

    public JsonObject getDays() {
        return days;
    }

    public void setDays(JsonObject days) {
        this.days = days;
    }
}
