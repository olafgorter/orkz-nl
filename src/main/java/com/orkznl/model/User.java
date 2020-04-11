package com.orkznl.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String email;

    @ManyToOne
    private Resident resident;

    @Version
    private Integer version;

    public User() {
    }

    public User(String username, String password, String email, Resident resident) {

        this.username = username;
        this.password = password;
        this.email = email;
        this.resident = resident;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Resident getResident() { return resident; }

    public void setResident(Resident resident) {this.resident = resident; }

    public Integer getVersion() {
        return version;
    }



}

