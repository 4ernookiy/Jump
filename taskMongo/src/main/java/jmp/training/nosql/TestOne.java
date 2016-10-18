package jmp.training.nosql;

import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import jmp.training.nosql.converter.UserConverter;
import jmp.training.nosql.dao.IUserDAO;
import jmp.training.nosql.dao.UserDaoImpl;
import jmp.training.nosql.entity.User;
import org.bson.Document;

/**
 * Created by d4 on 17.10.2016.
 */
public class TestOne {
    public static void main(String[] args) {
        MongoCollection<Document> users = MongoDBClient.getCollection("users");
        IUserDAO userDAO = new UserDaoImpl();

        for ( int i = 0; i < 10;i++) {
            User user = User.generateRandom();
            userDAO.insert(user);
        }

        MongoDBClient.println(users);

    }
}
