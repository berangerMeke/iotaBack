
package com.iota.orign.domain;

import java.util.Objects;
import org.springframework.stereotype.Component;


@Component
public class EmailModel {
    public String destinaire;
    public String object;
    public String message;
    public boolean Multipart;
    public boolean Html;


    EmailModel() {}

    EmailModel(String destinaire, String object, String message, boolean Multipart, boolean Html) {
        this.destinaire = destinaire;
        this.object = object;
        this.message = message;
        this.Multipart = Multipart;
        this.Html = Html;   
    }



}