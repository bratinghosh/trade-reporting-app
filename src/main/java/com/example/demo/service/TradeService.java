package com.example.demo.service;

import com.example.demo.entity.Trade;
import com.example.demo.repository.TradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TradeService {
    @Autowired
    private TradeRepository tradeRepository;

    public List<Trade> getAllTrades() {
        List<Trade> trades = new ArrayList<Trade>();
        tradeRepository.findAll().forEach(trade -> trades.add(trade));
        return trades;
    }

    public Trade getTrade(String tradeReference) {
        return tradeRepository.findById(tradeReference).get();
    }

    public void updateTrade(Trade trade) {
        tradeRepository.save(trade);
    }

    public void  deleteTrade(String tradeReference) {
        tradeRepository.deleteById(tradeReference);
    }
}
