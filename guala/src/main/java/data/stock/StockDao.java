package data.stock;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Sorts;
import data.BaseDao;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Projections.exclude;
import static com.mongodb.client.model.Projections.include;


public class StockDao extends BaseDao<Stock> {
    public StockDao() {
        super(Stock.class);
    }

    public List<Float> findManyByQueryPrice(Bson filter) {
        List<Float> results = new ArrayList<>();

        try(MongoCursor<Stock> cursor = collection.find(filter, genericClass)
                .projection(include("high", "low"))
                .sort(Sorts.ascending("date")).iterator()) {
            while(cursor.hasNext()) {
                Stock tmp = cursor.next();
                results.add((tmp.high + tmp.low)/2);
            }
        }

        return results;
    }
}
