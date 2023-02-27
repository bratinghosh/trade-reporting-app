package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTests {
    @Autowired
    private ProductRepository productRepository;

    Product PRODUCT = new Product("Test-Product", "FX Forward", "AUDNZD FRD");

    @Test
    public void testSaveBroker() {
        productRepository.save(PRODUCT);

        Assert.assertEquals(productRepository.findById(PRODUCT.getProductId()).get(), PRODUCT);
    }

    @Test
    public void testDeleteBrokerById() {
        productRepository.save(PRODUCT);
        productRepository.deleteById(PRODUCT.getProductId());

        Assert.assertEquals(productRepository.findById(PRODUCT.getProductId()), Optional.empty());
    }
}
