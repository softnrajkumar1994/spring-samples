package com.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "store")
public class Store {
    private String id;
    private String name;
}
