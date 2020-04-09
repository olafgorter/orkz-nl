package com.orkznl.model;

import javax.persistence.*;

@Entity
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    private String bankAccount;

    @Version
    private Integer version;

    public Resident() {
    }

    public Resident(String full_name, Room room, String bank_account) {

        this.fullName = full_name;
        this.room = room;
        this.bankAccount = bank_account;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "id=" + id +
                ", room='" + room +
                ", bank_account='" + bankAccount + '\'' +
                '}';
    }
        public Long getId () {
            return id;
        }

        public void setId (Long id){
            this.id = id;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName){
            this.fullName = fullName;
        }

        public Room getRoom () {
            return room;
        }

        public void setRoom (Room room){
            this.room = room;
        }

        public String getBankAccount() {
            return bankAccount;
        }

        public void setBankAccount(String bankAccount){
            this.bankAccount = bankAccount;
        }

        public Integer getVersion () {
            return version;
        }
}
