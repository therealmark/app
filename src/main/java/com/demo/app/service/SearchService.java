package com.demo.app.service;

import com.demo.app.client.MyMongoClient;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.search.SearchOperator;
import com.mongodb.client.model.search.SearchPath;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class SearchService {
    private final MyMongoClient mongoClient;

    @Autowired
    public SearchService(MyMongoClient mongoClient) {
        this.mongoClient = mongoClient;
    }

    public List<Document> searchFor(String term) {

//        SearchOperator searchStage = SearchOperator.compound()
//                .must(Arrays.asList(
//                        SearchOperator.text(SearchPath.fieldPath("some_key.some_nested_array"), "some term"),
//                        SearchOperator.text(SearchPath.fieldPath("another_key"), "another term")
//
//                ));
        SearchOperator singleFieldSearch = SearchOperator.text(SearchPath.fieldPath("host.host_verifications"), term);
        Bson searchStage = Aggregates.search(
                singleFieldSearch
        );
        Bson limitStage = Aggregates.limit(100);


        List<Document> results = new ArrayList<>();
        mongoClient.getListingsAndReviewsCollection().aggregate(Arrays.asList(searchStage, limitStage)).into(results);
        return results;
    }
}
