package com.insat.demo.entity;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "article")
public class Article implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "content")
    private String content;
    @ManyToOne
    @JoinColumn(name = "id_subj", nullable = true,insertable = false, updatable = false)
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "id_journaliste", nullable = true,insertable = false, updatable = false)
    private Journaliste journaliste;
    @ManyToOne
    @JoinColumn(name = "id_num", nullable = true,insertable = false, updatable = false)
    private Numero numero;
    public Article(String content,Long id
            , Subject subject, Journaliste journaliste,Numero numero
    ) {
        this.id=id;
        this.content = content;
        this.subject = subject;
        this.journaliste=journaliste;
        this.numero=numero;
    }

    public Article(){}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Subject getSubject() {
       return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    public Journaliste getJournalist() {
        return journaliste;
    }

    public void setJournaliste(Journaliste journaliste) {
        this.journaliste = journaliste;
    }
    public Numero getNumero() {
        return numero;
    }

    public void setNumero(Numero numero) {
        this.numero = numero;
    }
}
