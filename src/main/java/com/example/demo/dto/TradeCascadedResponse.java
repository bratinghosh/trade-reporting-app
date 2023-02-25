package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TradeCascadedResponse {
    private String tradeRef;
    private Date tradeDate;
    private Long quantity;
    private Character buySell;
    private Double price;
    private String productName;
    private  String productType;
    private String brokerName;
}
