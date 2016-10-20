package jmp.training.nosql.tutorial;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import static com.mongodb.client.model.Filters.gt;

/**
 * Created by Alexey_Zinovyev on 12-Oct-16.
 */
public class DeleteSample {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient();
        MongoDatabase db = mongoClient.getDatabase("local");
        MongoCollection<Document> artists = db.getCollection("artists");

        // 1 option
        //artists.deleteOne(gt("potato_eaters", 3));//????? Nothing was deleted
        artists.deleteOne(gt("potatoes_eaters", 4));
        // 2 option
        //artists.deleteMany(new Document());
        // 3 option
        //artists.drop();


        artists.find().forEach((Block<? super Document>) System.out::println);
    }
}
