package jmp.training.nosql.tutorial;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

/**
 * Created by Alexey_Zinovyev on 12-Oct-16.
 */
public class UpdateSample {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("local");
        MongoCollection<Document> artists = db.getCollection("artists");


        UpdateResult result = db.getCollection("artists").updateOne(new Document("name", "Van Gogh"),
                new Document("$set", new Document("country", "Russia")));
        System.out.println(result.getModifiedCount());
        artists.find().forEach((Block<? super Document>) System.out::println);
    }
}
