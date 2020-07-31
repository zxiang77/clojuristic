package data;


import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import config.AppConfig;
import data.mongo.MongoClientFactory;
import data.stock.Stock;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BaseDao<T> implements Dao<T> {

    public MongoClient mongoClient;
    public MongoDatabase database;
    public MongoCollection collection;
    public String DATABASE = "clojuristic";
    public String COLLECTION = "stocks";
    public final Class<T> genericClass;

    public BaseDao(Class<T> genericClass) {
        this.genericClass = genericClass;
        String connectString = new AppConfig().getMongoConnectString();
        mongoClient = new MongoClientFactory.Builder()
                .completeConnectString(connectString)
                .build().create();
        database = mongoClient.getDatabase(DATABASE);
        collection = database.getCollection(COLLECTION, Stock.class);
    }

    @Override
    public Optional<T> getById(ObjectId id) {
        T result = (T) collection.find(eq("_id", id), genericClass).first();
        return Optional.ofNullable(result);
    }

    @Override
    public List<T> getAll() {
        List<T> results = new ArrayList<T>();
        MongoCursor<T> cursor = collection.find().cursor();
        try {
            while(cursor.hasNext()) results.add(cursor.next());
        }
        finally {
            cursor.close();
        }
        return results;
    }

    @Override
    public void save(T o) {
        collection.insertOne(o);
    }

    @Override
    public void saveAll(List<T> objs) {
        collection.insertMany(objs);
    }

    @Override
    public void deleteById(ObjectId id) {
        collection.deleteOne(eq("_id", id));
    }

    public Optional<T> findOneByQuery(Bson filter) {
        T result = (T) collection.find(filter, genericClass).first();
        return Optional.ofNullable(result);
    }

    public List<T> findManyByQuery(Bson filter) {
        List<T> results = new ArrayList<>();

        try(MongoCursor<T> cursor = collection.find(filter, genericClass).iterator()) {
            while(cursor.hasNext()) results.add(cursor.next());
        }
        return results;
    }


}
