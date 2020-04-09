package com.orkznl.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ChargePrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Charge charge;
    private Double price;
    private Date start_date;
    private Date end_date;

    @Version
    private Integer version;

    public ChargePrice() {
    }

    public ChargePrice(Charge charge, Double price, Date start_date, Date end_date) {

        this.charge = charge;
        this.price = price;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    @Override
    public String toString() {
        return "ChargePrice{" +
                "id=" + id +
                ", charge='" + charge +
                ", price='" + price +
                ", start_date='" + start_date +
                ", end_date='" + end_date + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Charge getCharge() {
        return charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Integer getVersion() {
        return version;
    }

}
