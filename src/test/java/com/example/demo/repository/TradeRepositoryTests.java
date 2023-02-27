package com.example.demo.repository;

import com.example.demo.dto.TradeCascadedResponseDto;
import com.example.demo.entity.Broker;
import com.example.demo.entity.Product;
import com.example.demo.entity.Trade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TradeRepositoryTests {
    @Autowired
    private TradeRepository tradeRepository;

    Date date = new Date();

    Broker BROKER_1 = new Broker("Test-Broker-1", "Test Broker A");
    Broker BROKER_2 = new Broker("Test-Broker-2", "Test Broker B");
    Product PRODUCT_1 = new Product("Test-Product-1", "Test Product Type", "AUDNZD FRD");
    Trade TRADE_1 = new Trade("Test-Trade-1", BROKER_1, PRODUCT_1, date ,1000000L, 'B', 435.067591);
    Trade TRADE_2 = new Trade("Test-Trade-2", BROKER_2, PRODUCT_1, date,2000000L, 'S', 78.892093);

    @Test
    public void testSaveTrade() {
        tradeRepository.save(TRADE_1);

        Assert.assertNotNull(tradeRepository.findById(TRADE_1.getTradeRef()).get());
    }

    @Test
    public void testGetAllTradesCascaded() {
        tradeRepository.save(TRADE_1);
        tradeRepository.save(TRADE_2);

        Assert.assertEquals(tradeRepository.getAllTradesCascaded().get(0).getClass(), TradeCascadedResponseDto.class);
    }

    @Test
    public void testGetAllTradesCascadedByProductTypeByBrokerName() {
        tradeRepository.save(TRADE_1);
        tradeRepository.save(TRADE_2);

        Assert.assertEquals(tradeRepository.getAllTradesCascadedByProductTypeByBrokerName(
                TRADE_1.getProduct().getProductType(), TRADE_1.getBroker().getBrokerName()
        ).size(), 1);
    }
}
