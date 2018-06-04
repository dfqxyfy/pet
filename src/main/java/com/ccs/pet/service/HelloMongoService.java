package com.ccs.pet.service;

import com.ccs.pet.dto.Hello;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class HelloMongoService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @PostConstruct
    public void start(){
        hello();
    }

    public String hello(){
        Hello hello = new Hello();
        hello.setAge(33);
        hello.setName("mytest");
        mongoTemplate.insert(hello);
        Query query = new BasicQuery(new Document("name","mytest"));
        List<Hello> hellos = mongoTemplate.find(query, Hello.class);
        System.out.println(hellos.get(0).getAge());
        return hellos.get(0).getAge().toString();
    }
}
