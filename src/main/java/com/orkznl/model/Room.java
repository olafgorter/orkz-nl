package com.orkznl.model;

import javax.persistence.*;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Ward ward;
    @Column( name="room_number")
    private Integer roomnumber;

    @Version
    private Integer version;

    public Room() {
    }

    public Room(Ward ward, Integer roomnumber) {

        this.ward = ward;
        this.roomnumber = roomnumber;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", ward='" + ward +
                ", roomnumber='" + roomnumber + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Ward getWard() {
        return ward;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }
    public Integer getRoomnumber() {
        return roomnumber;
    }

    public void setRoomnumber(Integer roomnumber) {
        this.roomnumber = roomnumber;
    }
    public Integer getVersion() {
        return version;
    }

}
