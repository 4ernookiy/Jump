package jmp.training.nosql.entity;

import java.util.Date;

/**
 * Created by d4 on 18.10.2016.
 */
public class Movie {
    private String id;
    private String name;
    private Date publication;

    public Movie() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getPublication() {
        return publication;
    }

    public void setPublication(Date publication) {
        this.publication = publication;
    }
}
