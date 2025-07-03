package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ElasticSearchRestController {

    @Autowired
    private ElasticSearchService elasticSearchService;

    @GetMapping
    public List<Product> getAllProducts() {
        return elasticSearchService.findAllProducts();

    }

    @PostMapping
    public void createProducts() {
        elasticSearchService.generateAndSaveProducts(1000);
    }

    @DeleteMapping
    public void deleteAll() {
        elasticSearchService.deleteAll();
    }

    @GetMapping("/nearby")
    public List<Product> getProductsWithinDistance(
            @RequestParam(defaultValue = "12.9716") double lat,
            @RequestParam(defaultValue = "77.5946") double lon,
            @RequestParam(defaultValue = "10km") String distance) {

        GeoPoint center = new GeoPoint(lat, lon);
        return elasticSearchService.findByLocationWithin(center, distance);
    }
}
