package jmp.training.nosql;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by Alexey_Zinovyev on 12-Oct-16.
 */
public class DDLSample {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("local");
//        db.createCollection("artists");
        MongoCollection<Document> artists = db.getCollection("artists");
        System.out.println(artists.getReadConcern());

    }
}
