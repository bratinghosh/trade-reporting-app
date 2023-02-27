package com.example.demo.service;

import com.example.demo.dto.TradeCascadedResponseDto;
import com.example.demo.dto.TradeReportDto;

import com.example.demo.repository.TradeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class TradeReportServiceTests {
    @Mock
    private TradeRepository tradeRepository;
    @InjectMocks
    private TradeReportService tradeReportService;

    TradeCascadedResponseDto TRADE = new TradeCascadedResponseDto(
            "Trade-1", new Date(), 1000000L, 'B', 435.067591, "1", "AUDNZD FRD", "FX Forward", "1", "Broker A"
    );

    TradeReportDto MAPPED_TRADE = new TradeReportDto(
            "Trade-1", new Date(), 1000000L, 'B', 435.067591, "1", "AUDNZD FRD"
    );

    @Test
    public void testTradeReportDtoMapping() {
        Assert.assertEquals(tradeReportService.mapTradeCascadedResponseDtoToTradeReportDto(Arrays.asList(TRADE)), Arrays.asList(MAPPED_TRADE));
    }
}
