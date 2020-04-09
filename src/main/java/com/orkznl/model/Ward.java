package com.orkznl.model;

import javax.persistence.*;

@Entity
public class Ward {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private Integer sortorder;

    @Version
    private Integer version;

    public Ward() {
    }

    public Ward(String description, Integer sortorder) {

        this.description = description;
        this.sortorder = sortorder;
    }

    @Override
    public String toString() {
        return "Ward{" +
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

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    public Integer getVersion() {
        return version;
    }

}
