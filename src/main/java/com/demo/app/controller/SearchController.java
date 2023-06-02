package com.demo.app.controller;

import com.demo.app.service.SearchService;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SearchController {

    private final SearchService service;

    @Autowired
    public SearchController(SearchService service) {
        this.service = service;
    }
    @GetMapping("/search")
    public ResponseEntity<List<Document>> search(@RequestParam String term) {
        return ResponseEntity.ok().body(service.searchFor(term));
    }

}
