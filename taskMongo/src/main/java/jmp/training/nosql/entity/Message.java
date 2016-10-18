package jmp.training.nosql.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by d4 on 18.10.2016.
 */
public class Message {
    private String id;
    private String body;
    private Date send;
    private User owner;
    private List<User> likes;

    public Message() {
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getLikes() {
        return likes;
    }

    public void setLikes(List<User> likes) {
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getSend() {
        return send;
    }

    public void setSend(Date send) {
        this.send = send;
    }
}
