package jmp.training.nosql.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.mongodb.util.JSON;
import jmp.training.nosql.MongoDBClient;
import jmp.training.nosql.converter.Converter;
import jmp.training.nosql.converter.NameConverter;
import jmp.training.nosql.converter.UserConverter;
import jmp.training.nosql.entity.Name;
import jmp.training.nosql.entity.User;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d4 on 18.10.2016.
 */
public class UserDaoImpl implements IUserDAO {
    //    private DBCollection col;
    private Converter<User> userConverter = new UserConverter();
    private MongoCollection<Document> users;

    public UserDaoImpl() {
        this.users = MongoDBClient.getCollection("users");

    }

    public UserDaoImpl(MongoDatabase database) {
        this.users = database.getCollection("users");
    }

    @Override
    public User findOne(ObjectId id) {
        User u = new User();
        u.setId(id);
        return findOne(userConverter.toDocument(u));
    }

    @Override
    public void remove(ObjectId id) {
        User u = new User();
        u.setId(id);
        Document doc = userConverter.toDocument(u);
        DeleteResult dr = users.deleteOne(doc);
        System.out.println(dr);
    }

    @Override
    public List<User> findLimit(int limit) {
//        Document doc = userConverter.toDocument(user);
        // { "adresses" : {$elemMatch:{"city" : "Gomel"}}}

        Iterable<Document> documents = users.find().limit(limit);
        List<User> list = new ArrayList<>();
        for (Document item : documents) {
            list.add(userConverter.toObject(item));
        }
        ;
        return list;
    }

    public User insert(User user) {
        Document doc = userConverter.toDocument(user);
        users.insertOne(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        user.setId(id);
        return user;
    }

    @Override
    public User update(User user) {
        if (user.getId() != null && !user.getId().toString().isEmpty()) {
            Document doc = userConverter.toDocument(user);
            UpdateResult result = users.updateOne(new Document("_id", user.getId()),
                    new Document("$set", doc));
            System.out.println("was updated: " + result.toString());
            return findOne(doc);
        }
        return user;
    }

    public User findByName(String firstName, String lastName) {
        return findByName(new Name(firstName, lastName));
    }

    public User findByName(Name name) {
        User user = new User();
        user.setName(name);
        return findOne(userConverter.toDocument(user));
    }

    private User findOne(Document document) {
        Document unique = users.find(document).first();
        return userConverter.toObject(unique);
    }

}
