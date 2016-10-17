package jmp.training.nosql;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 * Created by d4 on 17.10.2016.
 */
public class TestOne {
    public static void main(String[] args) {
        MongoCollection<Document> users = MongoDBClient.getCollection("users");

        Document doc = new Document()
                .append("name", "Леша")
                .append("country", "Belgium")
                .append("ого", "ага");

        users.insertOne(doc);

        MongoDBClient.println(users);

    }
}
