package doctorappointment;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class DoctorappointmentApplication {

    @Autowired
    private MongoClient mongoClient;

    public static void main(String[] args) {
        SpringApplication.run(DoctorappointmentApplication.class, args);
    }

    @Bean
    public CommandLineRunner testMongoConnection() {
        return args -> {
            try {
                MongoDatabase database = mongoClient.getDatabase("admin");
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (Exception e) {
                System.err.println("Failed to connect to MongoDB: " + e.getMessage());
            }
        };
    }
}