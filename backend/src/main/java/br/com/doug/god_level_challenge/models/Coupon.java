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
@Table(name = "coupons")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class Coupon implements Serializable {

    @Serial
    private static final long serialVersionUID = -4148469735386674705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false)
    private String code;

    @Column
    private Character discountType;

    @Column(scale = 10, precision = 2)
    private BigDecimal discountValue;

    @Column
    private Boolean isActive;

    @Column
    private LocalDateTime validFrom;

    @Column
    private LocalDateTime validUntil;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @JsonIgnore
    @OneToMany(mappedBy = "coupon")
    private List<CouponSale> couponSales = new ArrayList<>();

}
