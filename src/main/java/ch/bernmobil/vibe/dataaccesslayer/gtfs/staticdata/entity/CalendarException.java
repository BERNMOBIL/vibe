package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class CalendarException {

  @Id
  private Long id;
  private LocalDate date;
  private String type;

  @OneToOne
  @JoinColumn(name = "calendar_date")
  private CalendarDate calendar_date;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public CalendarDate getCalendar_date() {
    return calendar_date;
  }

  public void setCalendar_date(
      CalendarDate calendar_date) {
    this.calendar_date = calendar_date;
  }
}
