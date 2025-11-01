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

    @Column(scale = 6, precision = 10)
    private BigDecimal deliveryFee;

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

    @Column(precision = 10, scale = 2)
    private BigDecimal serviceTaxFee;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal totalAmount;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal totalAmountItems;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalDiscount;

    @Column(precision = 10, scale = 2)
    private BigDecimal totalIncrease;

    @Column(precision = 10, scale = 2)
    private BigDecimal valuePaid;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "channel_id")
    private Channel channel;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "sub_brand_id")
    private SubBrand subBrand;

    @JsonIgnore
    @OneToMany(mappedBy = "sale")
    private List<CouponSale> coupons = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "sale")
    private List<DeliveryAddress> deliveryAddresses = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "sale")
    private List<Payment> payments = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "sale")
    private List<ProductSale> productSales = new ArrayList<>();

}
