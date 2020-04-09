package com.orkznl.model;

import javax.persistence.*;

@Entity
public class ResidentCharge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "charge_id", nullable = false)
    private Charge charge;

    @ManyToOne
    @JoinColumn(name = "resident_id", nullable = false)
    private Resident resident;

    private String mandatory;

    @Version
    private Integer version;

    public ResidentCharge() {
    }

    public ResidentCharge(Charge charge, Resident resident, String mandatory) {

        this.charge = charge;
        this.resident = resident;
        this.mandatory = mandatory;
    }

    @Override
    public String toString() {
        return "ResidentCharge{" +
                "id=" + id +
                ", charge='" + charge +
                ", resident='" + resident +
                ", mandatory='" + mandatory + '\'' +
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

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public String getMandatory() {
        return mandatory;
    }

    public void setMandatory(String mandatory) {
        this.mandatory = mandatory;
    }

    public Integer getVersion() {
        return version;
    }
}
