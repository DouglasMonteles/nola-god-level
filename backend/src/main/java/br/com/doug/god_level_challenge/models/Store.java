package br.com.doug.god_level_challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stores")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class Store implements Serializable {

    @Serial
    private static final long serialVersionUID = -4148469735386674705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column
    private Integer addressNumber;

    @Column(length = 200)
    private String addressStreet;

    @Column(length = 100)
    private String city;

    @Column(length = 100)
    private String district;

    @Column
    private Boolean isActive;

    @Column
    private Boolean isHolding;

    @Column
    private Boolean isOwn;

    @Column(scale = 6, precision = 9)
    private BigDecimal latitude;

    @Column(scale = 6, precision = 9)
    private BigDecimal longitude;

    @Column(length = 2)
    private String state;

    @Column(length = 10)
    private String zipcode;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDate creationDate;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name = "sub_brand_id")
    private SubBrand subBrand;

    @JsonIgnore
    @OneToMany(mappedBy = "store")
    private List<Customer> customers = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "store")
    private List<Sale> sales = new ArrayList<>();

}
