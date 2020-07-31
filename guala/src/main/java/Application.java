import config.AppConfig;
import data.stock.Stock;
import data.stock.StockDao;
import data.stock.StockService;
import org.bson.types.ObjectId;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Application {

//    public StockService stockService = new StockService();


    public static void main(String[] args) {
//        Scanner userInput = new Scanner(System.in);
//        System.out.println("Start Date (mm-dd-YYYY): ");
//        Date startDate = new SimpleDateFormat("MM-dd-yyy").parse(userInput.nextLine());
//        System.out.println("End Date (mm-dd-YYYY): ");
//        Date endDate = new SimpleDateFormat("MM-dd-yyy").parse(userInput.nextLine());


        StockService service = new StockService();

        float price = service.getAvgPriceByDate("AAL", LocalDate.of(2013, 2, 8));
        System.out.println(price);
    }
}
