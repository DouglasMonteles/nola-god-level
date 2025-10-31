package br.com.doug.god_level_challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brands")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class Brand implements Serializable {

    @Serial
    private static final long serialVersionUID = -4148469735386674705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column
    private LocalDateTime createdAt;

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    private List<Coupon> coupons = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    private List<Item> items = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    private List<Product> products = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    private List<Category> categories = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    private List<SubBrand> subBrands = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    private List<OptionGroup> optionGroups = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    private List<Store> stores = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    private List<Channel> channels = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "brand")
    private List<PaymentType> paymentTypes = new ArrayList<>();

}
