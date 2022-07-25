package com.ynov.controle_front.backend;

import java.util.Date;

public class MessageDTO {

    private int id;

    private Date date = new Date();

    private String mail;

    private String texte;

    public MessageDTO(){

    }

    public MessageDTO(int id,Date date,String mail,String texte) {
        this.id = id;
        this.date = date;
        this.mail = mail;
        this.texte = texte;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }
}
