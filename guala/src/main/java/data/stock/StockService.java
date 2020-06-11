package data.stock;

import java.time.LocalDate;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class StockService {

    public StockDao stockDao = new StockDao();

    public void save(Stock s) {
        stockDao.save(s);
    }

    public float getAvgPriceByDate(String name, LocalDate date) {
        Stock s = stockDao.findOneByQuery(and(eq("name", name), eq("date", date))).orElseThrow(
                () -> new NullPointerException());

        return (s.high + s.low)/2;
    }

    public List<Float> getAvgPriceByTimePeriod(String name, LocalDate startDate, LocalDate endDate) {
        List<Float> prices = stockDao.findManyByQueryPrice(and(eq("name", name),
                gte("date", startDate), lte("date", endDate)));
        return prices;
    }
}
