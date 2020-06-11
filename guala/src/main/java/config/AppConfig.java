package config;

import org.yaml.snakeyaml.Yaml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public class AppConfig {
    private String MONGO_CONNECT_STRING = "connectString";
    Map<String, Object> config;
    Map< String, Object> mongoConfig;

    public AppConfig() {
        Yaml yaml = new Yaml();
        try (InputStream inputStream = new FileInputStream("src/main/java/config/mongoConfig.yaml")) {
            this.config = (Map<String, Object>) yaml.load(inputStream);
            this.mongoConfig = (Map<String, Object>) config.get("mongo");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMongoConnectString() {
        return (String) mongoConfig.get(MONGO_CONNECT_STRING);
    }
}
