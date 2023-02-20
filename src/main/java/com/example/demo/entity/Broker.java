package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Broker {
    @Id
    private String brokerId;
    private String brokerName;
}
