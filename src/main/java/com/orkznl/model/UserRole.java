package com.orkznl.model;

import javax.persistence.*;

@Entity
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Role role;



    @Version
    private Integer version;

    public UserRole() {
    }

    public UserRole(User user, Role role) {

        this.user = user;
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", user='" + user +
                ", role='" + role + '\'' +
                '}';
    }
    public Long getId() { return id; }
    public void setId(Long id) {
        this.id = id;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public Integer getVersion() {
        return version;
    }
}
