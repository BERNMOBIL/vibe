package ch.bernmobil.vibe.dataaccesslayer.gtfs.staticdata.entity;

import javax.persistence.*;
import java.util.Currency;

@Entity
public class FareAttribute {
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    private FareRule fareRule;
    private double price;
    private Currency currentyType;
    @Enumerated(EnumType.ORDINAL)
    private PaymentMethod paymentMethod;
    @Enumerated(EnumType.ORDINAL)
    private Transfers transfers;
    private int transferDuration;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public FareRule getFareRule() {
        return fareRule;
    }

    public void setFareRule(FareRule fareRule) {
        this.fareRule = fareRule;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Currency getCurrentyType() {
        return currentyType;
    }

    public void setCurrentyType(Currency currentyType) {
        this.currentyType = currentyType;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Transfers getTransfers() {
        return transfers;
    }

    public void setTransfers(Transfers transfers) {
        this.transfers = transfers;
    }

    public int getTransferDuration() {
        return transferDuration;
    }

    public void setTransferDuration(int transferDuration) {
        this.transferDuration = transferDuration;
    }

    public enum Transfers {
        NOT_PERMITTED, ONCE, TWIICE, UNLIMITED
    }
    public enum PaymentMethod {
        ON_BOARD, BEFORE_BOARDING
    }
}
