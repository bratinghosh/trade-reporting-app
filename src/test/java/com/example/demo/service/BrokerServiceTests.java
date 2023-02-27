package com.example.demo.service;

import com.example.demo.entity.Broker;
import com.example.demo.repository.BrokerRepository;
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

@RunWith(MockitoJUnitRunner.class)
public class BrokerServiceTests {
    @Mock
    private BrokerRepository brokerRepository;
    @InjectMocks
    private BrokerService brokerService;

    Broker BROKER_1 = new Broker("1", "Broker A");
    Broker BROKER_2 = new Broker("2", "Broker B");
    Broker BROKER_3 = new Broker("3", "Broker C");

    @Test
    public void testGetAllBrokers() {
        List<Broker> brokers = new ArrayList<Broker>(Arrays.asList(BROKER_1, BROKER_2, BROKER_3));
        Mockito.when(brokerRepository.findAll()).thenReturn(brokers);

        Assert.assertEquals(brokerService.getAllBrokers(), brokers);
    }

    @Test
    public void testGetBroker() {
        Mockito.when(brokerRepository.findById(BROKER_1.getBrokerId())).thenReturn(Optional.of(BROKER_1));

        Assert.assertEquals(brokerService.getBroker(BROKER_1.getBrokerId()), BROKER_1);
    }
}
