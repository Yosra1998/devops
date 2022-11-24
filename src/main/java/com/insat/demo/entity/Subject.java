package com.insat.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "subject")
public class Subject implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id_subj;
    @Column(name = "label")
    private String label;

    @OneToMany(mappedBy = "subject")
    private List<Article> articleList ;

    public Subject(long id, String label, List articleList) {
        this.id_subj = id;
        this.label = label;
        this.articleList = articleList;
    }

    public Subject(){}

    public long getId() {
        return id_subj;
    }

    public void setId(long id) {
        this.id_subj = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List getArticleList() {
        return articleList;
    }

    public void setArticleList(List articleList) {
        this.articleList = articleList;
    }
}
