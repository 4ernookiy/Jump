package jmp.training.nosql.converter;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import jmp.training.nosql.entity.Adress;
import jmp.training.nosql.entity.Movie;
import jmp.training.nosql.entity.Name;
import jmp.training.nosql.entity.User;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by d4 on 18.10.2016.
 */
public class UserConverter implements Converter<User> {

    private Converter<Name> nameConverter = new NameConverter();
    private Converter<Adress> adressConverter = new AdressConverter();


    public Document toDocument(User user) {
        // embedded adress as list
        List<Document> adresses = new ArrayList<>();
        for (Adress adress : user.getAdresses()) {
            Document item = adressConverter.toDocument(adress);
            adresses.add(item);
        }
        // embedded name too as one obj
        Document name = nameConverter.toDocument(user.getName());
        Document doc = new Document();
        appendField(doc, "name", name);
        appendField(doc, "email", user.getEmail());
        appendField(doc, "adresses", adresses);
        appendField(doc, "friends", user.getFriends());
        appendField(doc, "movies", user.getMovies());
        if (user.getId() != null) {
            doc.append("_id", new ObjectId(user.getId().toString()));
        }
        return doc;
    }

    @Override
    public User toObject(Document doc) {
        if (doc == null){
            return null;
        }
        User u = new User();
        Name name = nameConverter.toObject((Document) doc.get("name"));
        u.setName(name);
        u.setEmail((String) doc.get("email"));
        ObjectId id = (ObjectId) doc.get("_id");
        if (id != null){
            u.setId(id);
        }
        List<Document> adresses = (List<Document>) doc.get("adresses");
        for(Document docAdress: adresses){
            Adress adress = adressConverter.toObject(docAdress);
            u.getAdresses().add(adress);
        }


//        u.setFriends((List<User>) doc.get("friends"));
//        u.setMovies((List<Movie>) doc.get("movies"));
        return u;
    }

    public User toObject(DBObject obj) {
        User u = new User();
//        u.setName((String) obj.get("name"));
        u.setEmail((String) obj.get("email"));
        ObjectId id = (ObjectId) obj.get("_id");
        u.setId(id);
        u.setFriends((List<User>) obj.get("friends"));
        u.setMovies((List<Movie>) obj.get("movies"));
        return u;
    }
}
