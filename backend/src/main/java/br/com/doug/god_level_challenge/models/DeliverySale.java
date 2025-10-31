package br.com.doug.god_level_challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "delivery_sales")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class DeliverySale implements Serializable {

    @Serial
    private static final long serialVersionUID = -4148469735386674705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String courierName;

    @Column(length = 100)
    private String courierPhone;

    @Column(length = 100)
    private String courierType;

    @Column(length = 100)
    private String deliveredBy;

    @Column(length = 100)
    private String deliveryType;

    @Column(length = 100)
    private String status;

    @Column
    private Float deliveryFee;

    @Column
    private Float courierFee;

    @Column(length = 100)
    private String timing;

    @Column(length = 100)
    private String mode;

    @Column(nullable = false)
    private Long saleId;

    @Column(length = 100)
    private String courierId;

    @JsonIgnore
    @OneToMany(mappedBy = "deliverySale")
    private List<DeliveryAddress> deliveryAddresses = new ArrayList<>();

}
