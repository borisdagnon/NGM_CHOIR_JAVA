package com.graceetfoi.gf.Bean;


import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "ecommerce",type = "categories")
public class Categories {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Categories(){}
    public Categories(String name){
        this.name=name;
    }


}
