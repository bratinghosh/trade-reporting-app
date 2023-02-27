package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTests {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductService productService;
    
    Product PRODUCT_1 = new Product("1", "FX Forward", "AUDNZD FRD");
    Product PRODUCT_2 = new Product("2", "FX Forward", "AUDUSD FRD");
    Product PRODUCT_3 = new Product("3", "Futures", "Corn Futures");
    Product PRODUCT_4 = new Product("4", "FX Forward", "EURUSD FRD");

    @Test
    public void testGetAllProducts() {
        List<Product> products = new ArrayList<Product>(Arrays.asList(PRODUCT_1, PRODUCT_2, PRODUCT_3, PRODUCT_4));
        Mockito.when(productRepository.findAll()).thenReturn(products);

        Assert.assertEquals(productService.getAllProducts(), products);
    }

    @Test
    public void testGetProduct() {
        Mockito.when(productRepository.findById(PRODUCT_2.getProductId())).thenReturn(Optional.of(PRODUCT_2));

        Assert.assertEquals(productService.getProduct(PRODUCT_2.getProductId()), PRODUCT_2);
    }
}
