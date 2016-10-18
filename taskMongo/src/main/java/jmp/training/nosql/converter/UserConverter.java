package jmp.training.nosql.converter;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import jmp.training.nosql.entity.Movie;
import jmp.training.nosql.entity.User;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.List;

/**
 * Created by d4 on 18.10.2016.
 */
public class UserConverter {
    public static DBObject toDbObject(User user) {
        BasicDBObjectBuilder builder = new BasicDBObjectBuilder().start();
        builder.append("name", user.getName());
        builder.append("email", user.getEmail());
        builder.append("friends", user.getFriends());
        builder.append("movies", user.getMovies());
        if (user.getId() != null)
            builder = builder.append("_id", new ObjectId(user.getId()));
        return builder.get();
    }

    public static Document toDocument(User user) {
        Document doc = new Document()
                .append("name", user.getName())
                .append("email", user.getEmail())
                .append("friends", user.getFriends())
                .append("movies", user.getMovies());
        if (user.getId() != null) {
            doc.append("_id", new ObjectId(user.getId()));
        }
        return doc;
    }

    public static User toUser(DBObject obj) {
        User u = new User();
        u.setName((String) obj.get("name"));
        u.setEmail((String) obj.get("email"));
        ObjectId id = (ObjectId) obj.get("_id");
        u.setId(id.toString());
        u.setFriends((List<User>) obj.get("friends"));
        u.setMovies((List<Movie>) obj.get("movies"));
        return u;
    }
}
