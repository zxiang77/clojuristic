package data.mongo;

import com.mongodb.client.MongoClient;

public interface ClientFacotry {

    public MongoClient create();
}
