package br.com.doug.god_level_challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class Sale implements Serializable {

    @Serial
    private static final long serialVersionUID = -4148469735386674705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String sale1;

    @Column(length = 100)
    private String sale2;

    @Column(length = 100)
    private String customerName;

    @Column(scale = 10, precision = 2)
    private BigDecimal deliveryFree;

    @Column
    private Integer deliverySeconds;

    @Column(length = 300)
    private String discountReason;

    @Column(length = 300)
    private String increaseReason;

    @Column(length = 100)
    private String origin;

    @Column
    private Integer peopleQuantity;

    @Column
    private Integer productionSeconds;

    @Column(length = 100, nullable = false)
    private String saleStatusDesc;

    @Column(scale = 10, precision = 2)
    private BigDecimal serviceTaxFee;

    @Column(scale = 10, precision = 2, nullable = false)
    private BigDecimal totalAmount;

    @Column(scale = 10, precision = 2, nullable = false)
    private BigDecimal totalAmountItems;

    @Column(scale = 10, precision = 2)
    private BigDecimal totalDiscount;

    @Column(scale = 10, precision = 2)
    private BigDecimal totalIncrease;

    @Column(scale = 10, precision = 2)
    private BigDecimal valuePaid;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @Column
    private Long customerId;

    @Column
    private Long storeId;

    @Column
    private Long subBrandId;

    @JsonIgnore
    @OneToMany(mappedBy = "sale")
    private List<CouponSale> coupons = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "sale")
    private List<DeliveryAddress> deliveryAddresses = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "sale")
    private List<Payment> payments = new ArrayList<>();

}
