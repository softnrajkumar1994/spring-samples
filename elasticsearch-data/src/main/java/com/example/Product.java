package com.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Dynamic;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Getter
@Setter
@Document(indexName = "product", createIndex = true, alwaysWriteMapping = true, versionType = Document.VersionType.EXTERNAL, writeTypeHint = WriteTypeHint.DEFAULT, dynamic = Dynamic.INHERIT, storeIdInSource = false, storeVersionInSource = false)

public class Product {
    @Id
    private String id;
    private Double cost;
    private Date createdDate;
    private Long availableCount;
    private Boolean active;

    private Store store;

}
