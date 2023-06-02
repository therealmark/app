package com.demo.app.controller;

import com.demo.app.model.Customer;
import com.demo.app.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DBController {

    private final DBService dbService;

    @Autowired
    public DBController(DBService dbService) {
        this.dbService = dbService;
    }

    @PostMapping("/customers")
    public ResponseEntity<String> insertCustomer(@RequestBody Customer customer) {
        return dbService.insertCustomer(customer);
    }
}
