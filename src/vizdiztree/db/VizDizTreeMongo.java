package vizdiztree.db;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class VizDizTreeMongo {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public VizDizTreeMongo() {
        // Use ./ngrok tcp 27017
        this.mongoClient = new MongoClient("0.tcp.ngrok.io",16038);
        this.database = this.mongoClient.getDatabase("vizdiz");
        this.collection = this.database.getCollection("admins");
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }
}
