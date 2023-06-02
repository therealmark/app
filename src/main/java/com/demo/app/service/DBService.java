package com.demo.app.service;

import com.demo.app.client.MyMongoClient;
import com.demo.app.model.Customer;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.InsertOneOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.UpdateOptions;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DBService {
    private final MyMongoClient mongoClient;
    UpdateOptions options = new UpdateOptions().upsert(true);

    @Autowired
    public DBService(MyMongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public ResponseEntity<String> save(Customer customer) {
        return ResponseEntity.ok().body(mongoClient
                .getCustomerCollection()
                .insertOne(customer)
                .getInsertedId().toString());
    }
}
