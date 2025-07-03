package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ElasticSearchService {
    @Autowired
    private ElasticProductRepository elasticProductRepository;

    public void generateAndSaveProducts(int count) {
        List<Product> products = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            Product product = new Product();
            product.setId(UUID.randomUUID().toString());
            product.setCost(100 + (1000 - 100) * random.nextDouble());
            product.setAvailableCount((long) random.nextInt(100));
            product.setCreatedDate(new Date());
            product.setActive(random.nextBoolean());

            Store store = new Store();
            store.setId(UUID.randomUUID().toString());
            store.setName("Store_" + random.nextInt(100));
            product.setStore(store);

            products.add(product);
        }

        elasticProductRepository.saveAll(products);
    }

    public List<Product> findAllProducts() {
        ArrayList<Product> list = new ArrayList<>();
        Iterable<Product> iterable = elasticProductRepository.findAll();
        Iterator<Product> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
        return list;
    }

}
