package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
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

            // Set random description
            product.setDescription("Sample description " + i);

            // Set random enum value
            Product.ProductType type = random.nextBoolean() ? Product.ProductType.FOOD : Product.ProductType.NON_FOOD;
            product.setType(type);

            // Set random geo location (e.g., within India)
            double lat = 8.0 + (28.0 - 8.0) * random.nextDouble();  // approx between Kanyakumari and Delhi
            double lon = 68.0 + (97.0 - 68.0) * random.nextDouble(); // approx between Gujarat and Arunachal
            product.setLocation(new GeoPoint(lat, lon));

            // Create list of stores (1 to 3 random stores)
            List<Store> storeList = new ArrayList<>();
            int storeCount = 1 + random.nextInt(3); // 1 to 3 stores

            for (int j = 0; j < storeCount; j++) {
                Store store = new Store();
                store.setId(UUID.randomUUID().toString());
                store.setName("Store_" + random.nextInt(100));
                storeList.add(store);
            }

            product.setStore(storeList);
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

    public void deleteAll() {
        elasticProductRepository.deleteAll();
    }

    public List<Product> findByLocationWithin(GeoPoint point, String km) {
        return elasticProductRepository.findByLocationWithin(point, km);
    }

}
