package com.insat.demo.entity;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Table(name = "journaliste")
public class Journaliste implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id_journaliste;
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    private String birthday;
    @OneToMany(mappedBy = "journaliste")
    private List<Personality> personalityList = new ArrayList<>();

    @OneToMany(mappedBy = "journaliste")
    private List<Journal> journalList = new ArrayList<>();

    @OneToMany(mappedBy = "journaliste")
    private List<Article> articleList = new ArrayList<>();

    public Journaliste(long id, String name, String birthday, List personalityList, List journalList, List articleList) {
        this.id_journaliste = id;
        this.name = name;
        this.birthday = birthday;
        this.personalityList = personalityList;
        this.journalList = journalList;
        this.articleList = articleList;
    }

    public Journaliste(String name, String birthday, List personalityList, List journalList, List articleList) {
        this.name = name;
        this.birthday = birthday;
       /* this.personalityList = personalityList;
        this.journalList = journalList;
        this.articleList = articleList;*/
    }

    public Journaliste(){}

    public Long getId() {
        return id_journaliste;
    }

    public void setId(Long id) {
        this.id_journaliste = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public List getPersonality() {
        return personalityList;
    }

    public void setPersonality(List personalityList) {
        this.personalityList = personalityList;
    }

    public List getJournalList() {
        return journalList;
    }

    public void setJournalList(List journalList) {
        this.journalList = journalList;
    }

    public List getArticleList() {
        return articleList;
    }

    public void setArticleList(List articleList) {
        this.articleList = articleList;
    }

}
