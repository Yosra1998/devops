package com.insat.demo.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "journal")
public class Journal implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @ManyToOne
    @JoinColumn(name = "id_journaliste", nullable = true,insertable = false, updatable = false)
    private Journaliste journaliste;

    public Journal(String name, String address,Long id
            , Journaliste journaliste
    ) {
        this.id=id;
        this.name = name;
        this.address = address;
        this.journaliste = journaliste;
    }

    public Journal(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Journaliste getJournaliste() {
        return journaliste;
    }

    public void setJournaliste(Journaliste journaliste) {
        this.journaliste = journaliste;
    }
}
