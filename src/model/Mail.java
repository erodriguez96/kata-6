/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author eduardo
 */
public class Mail {

    private final String mail;
    private final Integer id;

    public Mail(Integer id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    public Integer getId() {
        return id;
    }

    public String getMail() {
        return mail;
    }
}

