package br.com.doug.god_level_challenge.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "item_product_sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class ItemProductSale implements Serializable {

    @Serial
    private static final long serialVersionUID = -4148469735386674705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float quantity;

    @Column(nullable = false)
    private Float additionalPrice;

    @Column(nullable = false)
    private Float price;

    @Column
    private Float amount;

    @Column(length = 300)
    private String observations;

    @Column(nullable = false)
    private Long productSaleId;

    @Column(nullable = false)
    private Long itemId;

    @Column
    private Long optionGroupId;

}
