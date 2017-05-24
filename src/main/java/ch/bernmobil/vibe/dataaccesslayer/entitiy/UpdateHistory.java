package ch.bernmobil.vibe.dataaccesslayer.entitiy;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UpdateHistory {

    @Id
    private LocalDateTime time;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
