package jmp.training.nosql.entity;

import java.util.List;
import java.util.UUID;

/**
 * Created by d4 on 18.10.2016.
 */
public class User {

    private String id;
    private String name;
    private String email;
    private List<User> friends;
    private List<Movie> movies;

    public static User generateRandom(){
        String s = UUID.randomUUID().toString();
        String name = "name.user_"+s.substring(0,6);
        User u = new User();
        u.setName(name);
        u.setEmail(name+"@gmail.com");
        return u;
    }
    public User() {
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
