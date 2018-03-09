package com.graceetfoi.gf.Bean;



import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import javax.persistence.Id;
import java.util.List;

@Document(indexName = "ecommerce",type = "product")
public class Product {



    @Id
    private String id;
    private String name;
private double price;
private String description;
private String status;
private Integer quantity;

    @Field(type = FieldType.Nested)
private Categories categories;
private List<String> tags;

 Product(){}
public Product(String id, String name, double price, String description, String status, Integer quantity,Categories categories, List<String> tags){

     this.name=name;
    this.price=price;
    this.description=description;
    this.status=status;
    this.quantity=quantity;
    this.categories=categories;
    this.tags=tags;
}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }




}
