package com.igorhara.example.ejb.entity;

import javax.persistence.*;

@Entity
public class Notifier {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;


    @ManyToOne
    private Owner owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
