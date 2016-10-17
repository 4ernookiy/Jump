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
        MongoClient client = new MongoClient();
        MongoDatabase database = client.getDatabase("mydb");
        MongoCollection<Document> collection = database.getCollection("users");
//        System.out.println(collection.find());

        final MongoCursor<Document> iterator = collection.find().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

//        MongoClient mongoClient = new MongoClient();
//        MongoDatabase db = mongoClient.getDatabase("test");
////        db.createCollection("artists");
//        MongoCollection<Document> artists = db.getCollection("users");
//        System.out.println(artists.getReadConcern());

    }
}
