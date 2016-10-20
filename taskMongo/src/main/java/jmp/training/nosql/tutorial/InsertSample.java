package jmp.training.nosql.tutorial;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * Created by Alexey_Zinovyev on 12-Oct-16.
 */
public class InsertSample {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("local");
        MongoCollection<Document> artists = db.getCollection("artists");


        Document doc = new Document()
                .append("name", "Van Gogh")
                .append("country", "Belgium")
                .append("potatoes_eaters", 4);
        artists.insertOne(doc);

        FindIterable<Document> iterable = artists.find();
        final MongoCursor<Document> iterator = iterable.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());

        }
    }
}
