package com.wrathofathens.startrekapi.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ship
 */
@Entity
@Table(name="Federation")
public class Federation {

    // define fields
    @Id
    @Column(name="Registry")
    private int registry;
    @Column(name="Name")
    private String name;
    @Column(name="Crew")
    private int crew;
    @Column(name="Status")
    private String status;

    // define constructors
    public Federation(){

    }

    public Federation(int registry, String name, int crew, String status) {
        this.registry = registry;
        this.name = name;
        this.crew = crew;
        this.status = status;
    }

    // define getter/setter
    public int getRegistry() {
        return registry;
    }
    public void setRegistry(int registry) {
        this.registry = registry;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getCrew() {
        return crew;
    }
    public void setCrew(int crew) {
        this.crew = crew;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    // define tostring
    @Override
    public String toString() {
        return "Federation [Registry=" + registry + ", Name=" + name + ", Crew=" + crew + ", Status=" + status + "]";
    }
    
}