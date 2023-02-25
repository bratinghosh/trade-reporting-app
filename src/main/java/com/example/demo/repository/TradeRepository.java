package com.example.demo.repository;

import com.example.demo.dto.TradeCascadedResponse;
import com.example.demo.entity.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<Trade, String> {
    final String query = "SELECT new com.example.demo.dto.TradeCascadedResponse(t.tradeRef, t.tradeDate, t.quantity, t.buySell, t.price, p.productName, p.productType, b.brokerName) " +
            "FROM Trade t " +
            "JOIN t.product p " +
            "JOIN t.broker b ";

    @Query(query)
    List<TradeCascadedResponse> getAllTradesCascaded();

    @Query(query + "WHERE p.productType = :productType AND b.brokerName = :brokerName")
    List<TradeCascadedResponse> getAllTradesCascadedByProductTypeByBrokerName(
            @Param("productType") String productType,
            @Param("brokerName") String brokerName
    );

    @Query(query + "WHERE p.productType = :productType")
    List<TradeCascadedResponse> getAllTradesCascadedByProductType(
            @Param("productType") String productType
    );

    @Query(query + "WHERE b.brokerName = :brokerName")
    List<TradeCascadedResponse> getAllTradesCascadedByBrokerName(
            @Param("brokerName") String brokerName
    );
}
