package com.kaiburr.assessment.repository;

import com.kaiburr.assessment.models.Task;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository{

    @Autowired
    MongoClient client;

    @Autowired
    MongoConverter converter;

    @Override
    public List<Task> findByName(String query) {
        final List<Task> tasks = new ArrayList<>();
        MongoDatabase database = client.getDatabase("kaiburr");
        MongoCollection<Document> collection = database.getCollection("tasks");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "name")
                        .append("text",
                                new Document("query", query)
                                        .append("path", "name")))));
        result.forEach(doc -> tasks.add(converter.read(Task.class, doc)));
        return tasks;
    }

    @Override
    public List<Task> findByAssignee(String query) {
        final List<Task> tasks = new ArrayList<>();
        MongoDatabase database = client.getDatabase("kaiburr");
        MongoCollection<Document> collection = database.getCollection("tasks");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$match",
                        new Document("assignee", query)),
                new Document("$sort",
                        new Document("startTime", 1L)),
                new Document("$limit", 10L)));
        result.forEach(doc -> tasks.add(converter.read(Task.class, doc)));
        return tasks;
    }
}
