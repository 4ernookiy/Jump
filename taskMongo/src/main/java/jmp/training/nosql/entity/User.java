package jmp.training.nosql.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by d4 on 18.10.2016.
 */
public class User
{

    private static Random generator = new Random();
    private static List<String> cities = new ArrayList<>(Arrays.asList("Gomel", "Minsk", "Grodno", "Vitebsk", "Brest", "Mogilev"));
    private static List<String> zipCodes = new ArrayList<>(Arrays.asList("246000", "220050", "230000", "210001", "224000", "212001"));

    private String id;
    private String name;
    private String email;
    private List<User> friends = new ArrayList<>();
    private List<Adress> adresses = new ArrayList<>();
    private List<Movie> movies = new ArrayList<>();

    public static User generateRandom()
    {
        String s = UUID.randomUUID().toString();
        String name = "name.user_" + s.substring(0, 6);
        User u = new User();
        u.setName(name);
        u.setEmail(name + "@gmail.com");
        Adress adress = new Adress();
        int index = generator.nextInt(cities.size());
        String city = cities.get(index);
        String zip = zipCodes.get(index);
        adress.setCity(city);
        adress.setZip(zip);
        u.getAdresses().add(adress);

        return u;
    }

    public User()
    {
    }

    public List<Adress> getAdresses()
    {
        return adresses;
    }

    public void setAdresses(List<Adress> adresses)
    {
        this.adresses = adresses;
    }

    public List<Movie> getMovies()
    {
        return movies;
    }

    public void setMovies(List<Movie> movies)
    {
        this.movies = movies;
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public List<User> getFriends()
    {
        return friends;
    }

    public void setFriends(List<User> friends)
    {
        this.friends = friends;
    }
}
