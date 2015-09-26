package mongodb;

import com.mongodb.client.MongoCollection;
import org.bson.Document;

/**
 * Created by Василий on 26.09.2015.
 */
public interface RecordProcessor {
    void process(MongoCollection<Document> collection, Document document);
}
