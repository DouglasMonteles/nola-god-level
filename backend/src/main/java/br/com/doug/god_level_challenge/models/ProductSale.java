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
@Table(name = "product_sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class ProductSale implements Serializable {

    @Serial
    private static final long serialVersionUID = -4148469735386674705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Float quantity;

    @Column(nullable = false)
    private Float basePrice;

    @Column(nullable = false)
    private Float totalPrice;

    @Column(length = 300)
    private String observations;

    @Column(nullable = false)
    private Long saleId;

    @Column(nullable = false)
    private Long productId;

    @JsonIgnore
    @OneToMany(mappedBy = "productSale")
    private List<ItemProductSale> itemProductSales = new ArrayList<>();

}
