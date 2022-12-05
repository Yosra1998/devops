package com.insat.demo.entity;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Entity
public class Personality implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "nation")
    private String nation;
    @ManyToOne
    @JoinColumn(name = "id_journaliste", nullable = true,insertable = false, updatable = false)
    private Journaliste journaliste;

    public Personality(long id, String firstname, String lastname, String nation, Journaliste journaliste) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.nation = nation;
        //this.journaliste = journaliste;
    }

    public Personality(String firstname, String lastname, String nation, Journaliste journaliste) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nation = nation;
        //this.journaliste = journaliste;
    }

    public Personality(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Journaliste getJournaliste() {
        return journaliste;
    }

    public void setJournaliste(Journaliste journaliste) {
        this.journaliste = journaliste;
    }
}
