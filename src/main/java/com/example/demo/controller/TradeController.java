package com.example.demo.controller;

import com.example.demo.entity.Trade;
import com.example.demo.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/trade")
public class TradeController {
    @Autowired
    private TradeService tradeService;

    @GetMapping()
    public List<Trade> getAllTrades() {
        return tradeService.getAllTrades();
    }

    @GetMapping("/{tradeReference}")
    public Trade getTrade(@PathVariable("tradeReference") String tradeReference) {
        return tradeService.getTrade(tradeReference);
    }

    @PostMapping()
    public void updateTrade(@RequestBody Trade trade) {
        tradeService.updateTrade(trade);
    }

    @DeleteMapping("/{tradeReference}")
    public void deleteTrade(@PathVariable("tradeReference") String tradeReference) {
        tradeService.deleteTrade(tradeReference);
    }
}
