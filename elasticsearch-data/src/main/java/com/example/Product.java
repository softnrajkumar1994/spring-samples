package com.example;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Dynamic;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

@Document(indexName = "product", createIndex = false, alwaysWriteMapping = true, versionType = Document.VersionType.EXTERNAL, writeTypeHint = WriteTypeHint.DEFAULT, dynamic = Dynamic.INHERIT, storeIdInSource = false, storeVersionInSource = false)

public class Product {
    @Id
    private String id;
    private BigDecimal cost;
    private Date createdDate;
    private BigInteger availableCount;
    private Boolean active;

    private Store store;

}
