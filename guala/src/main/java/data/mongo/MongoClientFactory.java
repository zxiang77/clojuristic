package data.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MongoClientFactory implements ClientFacotry{
    public String username;
    public String password;
    public String database;
    public String srvHost;
    public String baseConnectString;
    public String completeConnectString;
    public CodecRegistry codecRegistry ;
    public MongoClientSettings clientSettings;

    public static final class Builder {
        private String username;
        private String password;
        private String srvHost;
        private String database;
        private String baseConnectString;
        private String completeConnectString;
        private CodecRegistry codecRegistry;
        private MongoClientSettings clientSettings;

        public Builder() {
            baseConnectString = "mongodb+srv://%s:%s@%s/%s?retryWrites=true&w=majority";
            codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        }

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder srvHost(String srvHost) {
            this.srvHost = srvHost;
            return this;
        }

        public Builder database(String database) {
            this.database = database;
            return this;
        }

        public Builder baseConnectString(String baseConnectString) {
            this.baseConnectString = baseConnectString;
            return this;
        }

        public Builder completeConnectString(String completeConnectString) {
            this.completeConnectString = completeConnectString;
            return this;
        }

        public Builder codecRegistry(CodecRegistry codecRegistry) {
            this.codecRegistry = codecRegistry;
            return this;
        }

        public Builder clientSettings(MongoClientSettings clientSettings) {
            this.clientSettings = clientSettings;
            return this;
        }

        public MongoClientFactory build() {
            return new MongoClientFactory(username, password, srvHost, database, baseConnectString,
                    completeConnectString, codecRegistry, clientSettings);
        }

    }

    public MongoClientFactory(String username, String password,  String srvHost, String database,
                              String baseConnectString, String completeConnectString, CodecRegistry codecRegistry,
                              MongoClientSettings clientSettings) {
        this.username = username;
        this.password = password;
        this.srvHost = srvHost;
        this.database = database;
        this.baseConnectString = baseConnectString;
        this.completeConnectString = completeConnectString;
        this.codecRegistry = codecRegistry;
        this.clientSettings = clientSettings;
    }

    public MongoClient create() {
        if(completeConnectString == null) {
            completeConnectString = String.format(baseConnectString, username, password, srvHost, database);
        }

        if(clientSettings == null) {
            clientSettings = MongoClientSettings.builder()
                    .codecRegistry(codecRegistry)
                    .applyConnectionString(new ConnectionString(completeConnectString))
                    .build();
        }
        return MongoClients.create(clientSettings);
    }
}
