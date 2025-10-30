package br.com.doug.god_level_challenge.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "payments")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class Payment implements Serializable {

    @Serial
    private static final long serialVersionUID = -4148469735386674705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10)
    private String currency;

    @Column(length = 100)
    private String description;

    @Column
    private Boolean isOnline;

    @Column
    private Long paymentTypeId;

    @Column
    private Long saleId;

    @Column(precision = 10, scale = 2)
    private BigDecimal value;

}
