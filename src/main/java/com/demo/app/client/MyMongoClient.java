package com.demo.app.client;

import com.demo.app.config.MongoCodecRegistry;
import com.demo.app.model.Customer;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class MyMongoClient {
    private MongoClient client;
    private MongoDatabase database;
    private MongoCollection<Customer> customerCollection;
    private MongoCollection<Document> listingsAndReviewsCollection;
    @Value("${spring.data.mongodb.uri}")
    private String URI;
    @Value("${database.name}")
    private String DATABASE_NAME;

    private final MongoCodecRegistry mongoCodecRegistry;

    @Autowired
    public MyMongoClient(MongoCodecRegistry mongoCodecRegistry) {
        this.mongoCodecRegistry = mongoCodecRegistry;
    }

    @PostConstruct
    public void init() {
        client = MongoClients.create(URI);
        database = client.getDatabase(DATABASE_NAME).withCodecRegistry(mongoCodecRegistry.getCodecRegistry());
        customerCollection = database.getCollection("customers", Customer.class);
        listingsAndReviewsCollection = database.getCollection("listingsAndReviews");
    }
}
