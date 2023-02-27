package com.example.demo.service;

import com.example.demo.entity.Broker;
import com.example.demo.entity.Product;
import com.example.demo.entity.Trade;
import com.example.demo.repository.TradeRepository;
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
import java.util.Date;

@RunWith(MockitoJUnitRunner.class)
public class TradeServiceTests {
    @Mock
    private TradeRepository tradeRepository;
    @InjectMocks
    private TradeService tradeService;

    Date date = new Date();

    Broker BROKER_1 = new Broker("1", "Broker A");
    Broker BROKER_2 = new Broker("2", "Broker B");
    Product PRODUCT_1 = new Product("1", "FX Forward", "AUDNZD FRD");
    Trade TRADE_1 = new Trade("Trade-1", BROKER_1, PRODUCT_1, date ,1000000L, 'B', 435.067591);
    Trade TRADE_2 = new Trade("Trade-2", BROKER_2, PRODUCT_1, date,2000000L, 'S', 78.892093);

    @Test
    public void testGetAllTrades() {
        List<Trade> trades = new ArrayList<Trade>(Arrays.asList(TRADE_1, TRADE_2));
        Mockito.when(tradeRepository.findAll()).thenReturn(trades);

        Assert.assertEquals(tradeService.getAllTrades(), trades);
    }

    @Test
    public void testGetTrade() {
        Mockito.when(tradeRepository.findById(TRADE_1.getTradeRef())).thenReturn(Optional.of(TRADE_1));

        Assert.assertEquals(tradeService.getTrade(TRADE_1.getTradeRef()), TRADE_1);
    }
}
