package br.com.doug.god_level_challenge.models.dtos;

import java.math.BigDecimal;
import java.sql.Timestamp;

public record SaleBasicInfoDTO(
    Long id,
    String sale1,
    String sale2,
    String customerName,
    BigDecimal deliveryFee,
    Integer deliverySeconds,
    String discountReason,
    String increaseReason,
    String origin,
    Integer peopleQuantity,
    Integer productionSeconds,
    String saleStatusDesc,
    BigDecimal serviceTaxFee,
    BigDecimal totalAmount,
    BigDecimal totalAmountItems,
    BigDecimal totalDiscount,
    BigDecimal totalIncrease,
    BigDecimal valuePaid,
    Timestamp createdAt,
    String channelName,
    String storeName,
    String subBrandName
) { }
