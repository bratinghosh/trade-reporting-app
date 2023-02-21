package com.example.demo.repository;

import com.example.demo.entity.Broker;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrokerRepository extends CrudRepository<Broker, String> {
}
