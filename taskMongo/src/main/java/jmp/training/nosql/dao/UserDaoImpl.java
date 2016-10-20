package jmp.training.nosql.dao;

import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jmp.training.nosql.MongoDBClient;
import jmp.training.nosql.converter.Converter;
import jmp.training.nosql.converter.UserConverter;
import jmp.training.nosql.entity.User;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 * Created by d4 on 18.10.2016.
 */
public class UserDaoImpl implements IUserDAO
{
    //    private DBCollection col;
    private Converter<User> userConverter = new UserConverter();
    private MongoCollection<Document> users;

    public UserDaoImpl()
    {
        this.users = MongoDBClient.getCollection("users");
        ;
    }

    public UserDaoImpl(MongoDatabase database)
    {
        this.users = database.getCollection("users");
    }

    public User insert(User user)
    {
        Document doc = userConverter.toDocument(user);
        users.insertOne(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        user.setId(id.toString());
        return user;
    }
}
