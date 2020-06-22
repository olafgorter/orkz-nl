package com.orkznl.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "resident_id", nullable = false)
    private Resident resident;

    private Date date;

    private Long paid;

    @Version
    private Integer version;

    public Invoice() {
    }

    public Invoice( Resident resident, Date date, Long paid ) {

        this.resident = resident;
        this.date = date;
        this.paid = paid;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", resident='" + resident +
                ", date='" + date +
                ", paid='" + paid +  '\'' +
                '}';
    }

    public Long getId () {
        return id;
    }

    public void setId (Long id){
        this.id = id;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getPaid() {
        return paid;
    }

    public void setPaid(Long paid) {
        this.paid = paid;
    }

    public Integer getVersion () {
        return version;
    }
}
