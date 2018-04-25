package vizdiztree.db;

import org.bson.Document;

public interface BsonCompatible {
    Document toBson();
}
