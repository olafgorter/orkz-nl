package com.orkznl.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Resident resident;

    private Double amount;
    private Date payment_date;
    private String description;
    private String change_name;
    private Date change_date;

    @Version
    private Integer version;

    public Payment() {
    }

    public Payment(Resident resident, Double amount, Date payment_date, String description, String change_name, Date change_date) {

        this.resident = resident;
        this.amount = amount;
        this.payment_date = payment_date;
        this.description = description;
        this.change_name = change_name;
        this.change_date = change_date;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", resident='" + resident +
                ", amount='" + amount +
                ", payment_date='" + payment_date +
                ", description='" + description +
                ", change_name='" + change_name +
                ", change_date='" + change_date + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getChange_name() {
        return change_name;
    }

    public void setChange_name(String change_name) {
        this.change_name = change_name;
    }

    public Date getChange_date() {
        return change_date;
    }

    public void setChange_date(Date change_date) {
        this.change_date = change_date;
    }

    public Integer getVersion() {
        return version;
    }

}
