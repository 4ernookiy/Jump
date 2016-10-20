package jmp.training.nosql.converter;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import jmp.training.nosql.entity.Adress;
import jmp.training.nosql.entity.Movie;
import jmp.training.nosql.entity.User;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d4 on 18.10.2016.
 */
public class UserConverter implements Converter<User>{

    public Document toDocument(User user) {
        List<Document> adresses = new ArrayList<>();
        for (Adress adress: user.getAdresses()){
            Document item = new Document();
            item.append("city",adress.getCity());
            item.append("zip",adress.getZip());
            item.append("street",adress.getStreet());
            adresses.add(item);
        }
        Document doc = new Document()
                .append("name", user.getName())
                .append("email", user.getEmail())
                .append("adresses", adresses)
                .append("friends", user.getFriends())
                .append("movies", user.getMovies());

        if (user.getId() != null) {
            doc.append("_id", new ObjectId(user.getId()));
        }
        return doc;
    }

    @Override
    public User toObject(Document doc)
    {
        return null;
    }

    public  User toObject(DBObject obj) {
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
