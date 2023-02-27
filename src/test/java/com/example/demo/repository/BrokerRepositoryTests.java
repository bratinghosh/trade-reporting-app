package com.example.demo.repository;

import com.example.demo.entity.Broker;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BrokerRepositoryTests {
    @Autowired
    private BrokerRepository brokerRepository;

    Broker BROKER = new Broker("Test-Broker", "Broker A");

    @Test
    public void testSaveBroker() {
        brokerRepository.save(BROKER);

        Assert.assertEquals(brokerRepository.findById(BROKER.getBrokerId()).get(), BROKER);
    }

    @Test
    public void testDeleteBrokerById() {
        brokerRepository.save(BROKER);
        brokerRepository.deleteById(BROKER.getBrokerId());

        Assert.assertEquals(brokerRepository.findById(BROKER.getBrokerId()), Optional.empty());
    }
}
