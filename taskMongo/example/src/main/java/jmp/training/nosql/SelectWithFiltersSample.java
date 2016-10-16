package jmp.training.nosql;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;

/**
 * Created by Alexey_Zinovyev on 12-Oct-16.
 */
public class SelectWithFiltersSample {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("local");
        MongoCollection<Document> artists = db.getCollection("artists");


        // 1 option
        FindIterable<Document> iterable = artists.find(new Document("country", "Russia")
//                .append("name", "Repin")
        );

        // 2 option

        FindIterable<Document> iterable2 = artists.find(eq("country", "Russia")
                //.append("name", "Repin")
        );



        iterable2.forEach((Block<? super Document>) System.out::println);
    }
}
