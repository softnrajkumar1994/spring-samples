package com.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document(
        indexName = "product",
        createIndex = true,
        alwaysWriteMapping = true,
        versionType = Document.VersionType.EXTERNAL,
        writeTypeHint = WriteTypeHint.DEFAULT,
        dynamic = Dynamic.INHERIT,
        storeIdInSource = false,
        storeVersionInSource = false
)
public class Product {

    @Id
    private String id;
    private Double cost;
    @Field(type = FieldType.Date)
    private Date createdDate;
    private Long availableCount;
    private Boolean active;
    @Field(type = FieldType.Nested)
    private List<Store> store;
    @Field(type = FieldType.Text)
    private String description;
    @Field(type = FieldType.Keyword)
    private ProductType type;
    @GeoPointField
    private GeoPoint location;

    enum ProductType {
        FOOD, NON_FOOD
    }

}
