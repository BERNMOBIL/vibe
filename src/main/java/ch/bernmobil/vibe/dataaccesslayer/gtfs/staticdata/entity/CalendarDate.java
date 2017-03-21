package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CalendarDate {

  @Id
  private Long id;
  //private String days; //TODO: ADD days
  private LocalDate validFrom;
  private LocalDate validUntil;

  @OneToOne
  @JoinColumn(name = "journey")
  private Journey journey;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
}
