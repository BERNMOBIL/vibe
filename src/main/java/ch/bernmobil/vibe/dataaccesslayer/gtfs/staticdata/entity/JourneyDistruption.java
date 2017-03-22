package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class JourneyDistruption {

  @Id
  private Long id;
  private String message;
  private Timestamp start;
  private Timestamp planned_end;

  @OneToOne
  @JoinColumn(name = "journey")
  private Journey journey;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Timestamp getStart() {
    return start;
  }

  public void setStart(Timestamp start) {
    this.start = start;
  }

  public Timestamp getPlanned_end() {
    return planned_end;
  }

  public void setPlanned_end(Timestamp planned_end) {
    this.planned_end = planned_end;
  }

  public Journey getJourney() {
    return journey;
  }

  public void setJourney(Journey journey) {
    this.journey = journey;
  }
}
