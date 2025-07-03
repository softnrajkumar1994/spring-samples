package com.example;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ElasticProductRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findByLocationWithin(org.springframework.data.elasticsearch.core.geo.GeoPoint location, String distance);
}
