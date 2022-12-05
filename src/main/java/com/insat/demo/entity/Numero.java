package com.insat.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "numero")
public class Numero {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id_num;
    @Column(name="date")
    private String date;
    @Column(name="tirage")
    private String tirage;

    @OneToMany(mappedBy = "journaliste")
    private List<Article> articleList = new ArrayList<>();

    public Numero(String date,Long id_num
            , String tirage,List articleList
    ) {
        this.id_num=id_num;
        this.date = date;
        this.tirage = tirage;
        this.articleList=articleList;
    }

    public Numero(){}

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTirage() {
        return tirage;
    }

    public void setTirage(String tirage) {
        this.tirage = tirage;
    }
    public List getArticleList() {
        return articleList;
    }

    public void setArticleList(List articleList) {
        this.articleList = articleList;
    }

}
