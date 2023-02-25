package com.example.demo.service;

import com.example.demo.dto.TradeCascadedResponse;
import com.example.demo.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeReportService {
    @Autowired
    private TradeRepository tradeRepository;

    public List<TradeCascadedResponse> getAllTradesCascaded(){
        return tradeRepository.getAllTradesCascaded();
    }

    public List<TradeCascadedResponse> getAllTradesCascadedByProductTypeByBrokerName(
            String productType,
            String brokerName
    ) {
        return tradeRepository.getAllTradesCascadedByProductTypeByBrokerName(
                productType, brokerName
        );
    }
}
