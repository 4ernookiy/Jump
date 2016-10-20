package jmp.training.nosql.tutorial;

import com.mongodb.Block;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by Alexey_Zinovyev on 12-Oct-16.
 */
public class SelectSample {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("local");
        MongoCollection<Document> artists = db.getCollection("artists");
        FindIterable<Document> iterable = artists.find();

        // 1 option
        final MongoCursor<Document> iterator = iterable.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

        // 2 option
        iterable.forEach((Block<? super Document>) System.out::println);

    }
}
