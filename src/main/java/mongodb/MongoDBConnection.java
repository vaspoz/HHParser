package mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnection {
    private MongoClient client;
    private MongoDatabase db;
    private MongoCollection<Document> collection;

    private MongoDBConnection(String database) {
        client = new MongoClient();
        db = client.getDatabase(database);
    }

    public static MongoDBConnection getDBConnection(String databaseName) {
        return new MongoDBConnection(databaseName);
    }

    public void useCollection(String collectionName) {
        collection = db.getCollection(collectionName);
    }

    public void saveDocument(Document document) {
        collection.insertOne(document);
    }

    public void drop() {
        collection.drop();
    }

    public static void main(String[] args) {
        MongoDBConnection con = MongoDBConnection.getDBConnection("hh");
        con.useCollection("dictionaries");
    }
}
