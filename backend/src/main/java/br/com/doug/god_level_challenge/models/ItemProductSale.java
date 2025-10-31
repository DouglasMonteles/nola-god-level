package br.com.doug.god_level_challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "product_sale_id", nullable = false)
    private ProductSale productSale;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "option_group_id")
    private OptionGroup optionGroup;

    @JsonIgnore
    @OneToMany(mappedBy = "itemProductSale")
    private List<ItemItemProductSale> itemItemProductSales = new ArrayList<>();

}
