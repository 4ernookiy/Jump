package jmp.training.nosql;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by d4 on 17.10.2016.
 */
public class MongoDBClient {
    private final static Logger logger = LoggerFactory.getLogger(MongoDBClient.class);
    private static MongoClient client = new MongoClient();
    private static MongoDatabase database = client.getDatabase("mydb");

    public static MongoCollection<Document> getCollection(String nameCollection) {
        return database.getCollection(nameCollection);
    }

    public static void println(MongoCollection<Document> collection) {
        FindIterable<Document> iterable = collection.find();
        final MongoCursor<Document> iterator = iterable.iterator();
        while(iterator.hasNext()){
            logger.info(iterator.next().toString());
        }
    }
}
