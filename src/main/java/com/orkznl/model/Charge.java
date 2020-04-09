package com.orkznl.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Charge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    @OneToMany
    private Set<ChargePrice> chargePrices;

    @Version
    private Integer version;

    public Charge() {
    }

    public Charge(String description) {

        this.description = description;
    }

    @Override
    public String toString() {
        return "Charge{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVersion() {
        return version;
    }

    public Set<ChargePrice> getChargePrices() {
        return chargePrices;
    }

    public void setChargePrices(Set<ChargePrice> chargePrices) {
        this.chargePrices = chargePrices;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}