package com.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(indexName = "store")
public class Store {

    @Field(type = FieldType.Text)
    private String id;
    @Field(type = FieldType.Text)
    private String name;
}
