package br.com.doug.god_level_challenge.models.dtos;

import java.sql.Timestamp;

public record QuantityProductSaleByPeriodDTO(
    Long productId,
    String productName,
    Float productQuantityTotalSales,
    Long saleId,
    Float quantityOnSale,
    Timestamp createdAt
) {}
