package com.ccs.pet.dto;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="hello")
public class Hello {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
