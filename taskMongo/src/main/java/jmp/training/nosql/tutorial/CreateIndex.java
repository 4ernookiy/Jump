package jmp.training.nosql.tutorial;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

/**
 * Created by Alexey_Zinovyev on 12-Oct-16.
 */
public class CreateIndex {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("local");
        MongoCollection<Document> artists = db.getCollection("artists");

        String result = artists.createIndex(new Document("name", 1));
        System.out.println(result);
        FindIterable<Document> iterable2 = artists.find(eq("name", "Shishkin"));
        iterable2.forEach((Block<? super Document>) System.out::println);
    }
}
