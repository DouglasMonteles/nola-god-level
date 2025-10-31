package br.com.doug.god_level_challenge.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "payment_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class PaymentType implements Serializable {

    @Serial
    private static final long serialVersionUID = -6942589595949672023L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String description;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

}
