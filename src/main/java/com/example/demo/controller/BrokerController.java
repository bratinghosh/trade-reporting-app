package com.example.demo.controller;

import com.example.demo.entity.Broker;
import com.example.demo.service.BrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/broker")
public class BrokerController {
    @Autowired
    private BrokerService brokerService;

    @GetMapping()
    public List<Broker> getAllBrokers() {
        return brokerService.getAllBrokers();
    }

    @GetMapping("/{brokerId}")
    public Broker getBroker(@PathVariable("brokerId") String brokerId) {
        return brokerService.getBroker(brokerId);
    }

    @PostMapping()
    public void updateBroker(@RequestBody Broker broker) {
        brokerService.updateBroker(broker);
    }

    @DeleteMapping("/{brokerId}")
    public void deleteBroker(@PathVariable("brokerId") String brokerId) {
        brokerService.deleteBroker(brokerId);
    }
}
