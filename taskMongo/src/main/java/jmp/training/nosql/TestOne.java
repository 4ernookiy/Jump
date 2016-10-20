package jmp.training.nosql;

import com.mongodb.client.MongoCollection;
import jmp.training.nosql.dao.IUserDAO;
import jmp.training.nosql.dao.UserDaoImpl;
import jmp.training.nosql.entity.User;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by d4 on 17.10.2016.
 */
public class TestOne {
    private final static Logger logger = LoggerFactory.getLogger(TestOne.class);

    public static void main(String[] args) {
        MongoCollection<Document> users = MongoDBClient.getCollection("users");
        IUserDAO userDAO = new UserDaoImpl();
        Long begin = System.currentTimeMillis();
        Long dif, tmp;
        for ( int i = 0; i < 5_00;i++) {
            User user = User.generateRandom();
            userDAO.insert(user);
            if (i % 1_000 == 0){
                tmp = System.currentTimeMillis();
                dif = tmp - begin;
                begin = tmp;
                logger.info(" inserted {} for {}",i, dif);
            }
        }

        MongoDBClient.println(users);

    }
}
