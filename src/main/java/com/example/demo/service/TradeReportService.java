package com.example.demo.service;

import com.example.demo.dto.TradeCascadedResponseDto;
import com.example.demo.dto.TradeReportDto;
import com.example.demo.repository.TradeRepository;
import com.example.demo.util.MapperUtil;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalTime;
import java.util.List;

@Service
public class TradeReportService {
    @Autowired
    private TradeRepository tradeRepository;

    public List<TradeCascadedResponseDto> getAllTradesCascaded(){
        return tradeRepository.getAllTradesCascaded();
    }

    public List<TradeCascadedResponseDto> getAllTradesCascadedByProductTypeByBrokerName(
            String productType,
            String brokerName
    ) {
        return tradeRepository.getAllTradesCascadedByProductTypeByBrokerName(
                productType, brokerName
        );
    }

    public List<TradeReportDto> getAllTradesCascadedByProductTypeByBrokerNameSaveCSV(
            String productType,
            String brokerName
    ) {
        List<TradeCascadedResponseDto> trades = tradeRepository.getAllTradesCascadedByProductTypeByBrokerName(
                productType,
                brokerName
        );

        // Map TradeCascadedResponseDto to TradeReportDto
        MapperUtil mapperUtil = null;
        List<TradeReportDto> tradesMapped = mapperUtil.mapList(trades, TradeReportDto.class);

        // Convert JSON response to CSV file and save in trade-reports/ directory
        // CSV file name format: productType_brokerName_<CURRENT DATETIME>.csv
        Writer writer = null;
        final String filePath = "trade-reports/productType_brokerName_" + LocalTime.now() + ".csv";

        try {
            writer = new FileWriter(filePath);
            StatefulBeanToCsv tradesToCsv = new StatefulBeanToCsvBuilder(writer).build();
            tradesToCsv.write(tradesMapped);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvDataTypeMismatchException e) {
            throw new RuntimeException(e);
        } catch (CsvRequiredFieldEmptyException e) {
            throw new RuntimeException(e);
        }

        return tradesMapped;
    }
}
