package com.example;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticProductRepository extends ElasticsearchRepository<Product, String> {
}
