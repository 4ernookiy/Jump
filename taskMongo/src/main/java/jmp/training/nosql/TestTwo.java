package jmp.training.nosql;

import com.mongodb.client.MongoCollection;
import jmp.training.nosql.dao.IUserDAO;
import jmp.training.nosql.dao.UserDaoImpl;
import jmp.training.nosql.entity.Adress;
import jmp.training.nosql.entity.User;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by d4 on 17.10.2016.
 */
public class TestTwo {
    private final static Logger logger = LoggerFactory.getLogger(TestTwo.class);

    public static void main(String[] args) {
        MongoCollection<Document> users = MongoDBClient.getCollection("users");
        IUserDAO userDAO = new UserDaoImpl();

        User fromCity = new User();
        Adress adress = new Adress();
        adress.setCity("Gomel");
        fromCity.getAdresses().add(adress);

        List<User> list = userDAO.findLimit(20);
//        System.out.println(list);

        User user = list.get(5);
        System.out.println("user 5:" + user);
//        User user = userDAO.findByName("Danik","Petrov");

        user.setEmail("4ernookiy@gmail.com");
        System.out.println("updating user: " + user.getName());
        userDAO.update(user);
        user = userDAO.findOne(user.getId());
        System.out.println(user);
        System.out.println("deleting user: " + user.getName());
        userDAO.remove(user.getId());

        list = userDAO.findLimit(20);
        System.out.println("user 5:" + list.get(5));

        user = userDAO.findOne(list.get(10).getId());
        System.out.println(user);

//        MongoDBClient.println(users);

    }
}
