package jmp.training.nosql.entity;

import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by d4 on 18.10.2016.
 */
public class User{

    private static Random generator = new Random();
    private static List<String> cities = new ArrayList<>(Arrays.asList("Gomel", "Minsk", "Grodno", "Vitebsk", "Brest", "Mogilev"));
    private static List<String> zipCodes = new ArrayList<>(Arrays.asList("246000", "220050", "230000", "210001", "224000", "212001"));
    private static List<String> firstNames = new ArrayList<>(Arrays.asList("Katya", "Misha", "Dima", "Danik", "Tanya", "Aleh", "Sveta", "Nastya", "Kiril", "Pavel"));
    private static List<String> lastNames = new ArrayList<>(Arrays.asList("Sverdlov", "Smirnof", "Ivanov", "Petrov", "White", "Sisnik", "Lesnik", "Yaga"));

    private ObjectId id;
    private Name name;
    private String email;
    private List<User> friends = new ArrayList<>();
    private List<Adress> adresses = new ArrayList<>();
    private List<Movie> movies = new ArrayList<>();

    private static <T> T generate(List<T> list) {
        int index = generator.nextInt(list.size());
        T t = list.get(index);
        return t;
    }

    private static Name generateName() {
        String first = generate(firstNames);
        String last = generate(lastNames);
        return new Name(first, last);
    }


    public static User generateRandom() {
        String s = UUID.randomUUID().toString();
        User u = new User();
        Name n = generateName();
        n.setLast(n.getLast()+"_"+s.substring(0, 6));
        u.setName(n);
        u.setEmail(n.getFirst() + "." + n.getLast() + "@gmail.com");
        Adress adress = new Adress();
        int index = generator.nextInt(cities.size());
        String city = cities.get(index);
        String zip = zipCodes.get(index);
        adress.setCity(city);
        adress.setZip(zip);
        u.getAdresses().add(adress);
        return u;
    }

    public User() {
    }

    public List<Adress> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adress> adresses) {
        this.adresses = adresses;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
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


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name=" + name +
                ", email='" + email + '\'' +
                ", adresses=" + adresses +
                '}';
    }

}
