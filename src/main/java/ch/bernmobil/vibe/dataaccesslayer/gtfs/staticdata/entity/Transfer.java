package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import javax.persistence.*;

@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    private Stop fromStop;
    @OneToOne
    private Stop toStop;
    @Enumerated(EnumType.ORDINAL)
    private TransferType transferType;
    private int minTransferTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Stop getFromStop() {
        return fromStop;
    }

    public void setFromStop(Stop fromStop) {
        this.fromStop = fromStop;
    }

    public Stop getToStop() {
        return toStop;
    }

    public void setToStop(Stop toStop) {
        this.toStop = toStop;
    }

    public TransferType getTransferType() {
        return transferType;
    }

    public void setTransferType(TransferType transferType) {
        this.transferType = transferType;
    }

    public int getMinTransferTime() {
        return minTransferTime;
    }

    public void setMinTransferTime(int minTransferTime) {
        this.minTransferTime = minTransferTime;
    }

    public enum TransferType {
        RECOMMENDED, TIMED_TRANSFER, MINIMUM_REQUIRED_TIME, NOT_POSSIBLE
    }
}
