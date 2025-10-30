package br.com.doug.god_level_challenge.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "delivery_addresses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class DeliveryAddress implements Serializable {

    @Serial
    private static final long serialVersionUID = -4148469735386674705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String street;

    @Column(length = 20)
    private String number;

    @Column(length = 200)
    private String complement;

    @Column(length = 200)
    private String formattedAddress;

    @Column(length = 100)
    private String neighborhood;

    @Column(length = 100)
    private String city;

    @Column(length = 50)
    private String state;

    @Column(length = 100)
    private String country;

    @Column(length = 20)
    private String postalCode;

    @Column(length = 300)
    private String reference;

    @Column
    private Float latitude;

    @Column
    private Float longitude;

    @Column(nullable = false)
    private Long saleId;

    @Column(length = 100)
    private String deliverySaleId;

}
