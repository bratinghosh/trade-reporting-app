package com.example.demo.controller;

import com.example.demo.dto.TradeCascadedResponseDto;
import com.example.demo.dto.TradeReportDto;
import com.example.demo.service.TradeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/trade-report")
public class TradeReportController {
    @Autowired
    private TradeReportService tradeReportService;
    @GetMapping()
    public List<TradeCascadedResponseDto> getAllTradesCascaded() {
        return tradeReportService.getAllTradesCascaded();
    }

    @GetMapping("/query")
    public List<TradeReportDto> getAllTradesMappedByProductTypeByBrokerName(
            @RequestParam String productType,
            @RequestParam String brokerName
    ) {
        return tradeReportService.getAllTradesMappedByProductTypeByBrokerName(productType, brokerName);
    }

    @GetMapping("/query/export-csv")
    public List<TradeReportDto> getAllTradesMappedByProductTypeByBrokerNameSaveCSV(
            @RequestParam String productType,
            @RequestParam String brokerName
    ) {
        return tradeReportService.getAllTradesMappedByProductTypeByBrokerNameSaveCSV(productType, brokerName);
    }
}
