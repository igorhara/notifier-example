package com.igorhara.example.ejb.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by serafig on 05/07/2017.
 */
@Entity
public class Owner {


    @Id
    @GeneratedValue
    private Long id;

    @Basic
    private String name;

    @ElementCollection
    private Set<String> addresses = new HashSet<>();


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

    public Set<String> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<String> addresses) {
        this.addresses = addresses;
    }
}
