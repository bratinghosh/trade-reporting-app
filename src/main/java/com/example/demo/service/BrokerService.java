package com.example.demo.service;

import com.example.demo.entity.Broker;
import com.example.demo.repository.BrokerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BrokerService {
    @Autowired
    private BrokerRepository brokerRepository;

    public List<Broker> getAllBrokers() {
        List<Broker> brokers = new ArrayList<Broker>();
        brokerRepository.findAll().forEach(broker -> brokers.add(broker));
        return brokers;
    }

    public Broker getBroker(String brokerId) {
        return brokerRepository.findById(brokerId).get();
    }

    public void updateBroker(Broker broker) {
        brokerRepository.save(broker);
    }

    public void deleteBroker(String brokerId) {
        brokerRepository.deleteById(brokerId);
    }
}
