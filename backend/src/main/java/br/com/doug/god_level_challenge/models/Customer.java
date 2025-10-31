package br.com.doug.god_level_challenge.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class Customer implements Serializable {

    @Serial
    private static final long serialVersionUID = -4148469735386674705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Boolean agreeTerms;

    @Column(length = 100)
    private String cpf;

    @Column(name = "costumer_name", length = 100)
    private String customerName;

    @Column(length = 100)
    private String email;

    @Column(length = 10)
    private String gender;

    @Column(length = 50)
    private String phoneNumber;

    @Column
    private Boolean receivePromotionsEmail;

    @Column
    private Boolean receivePromotionsSms;

    @Column(length = 20)
    private String registrationOrigin;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "sub_brand_id")
    private SubBrand subBrand;

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private List<Sale> sales = new ArrayList<>();

}
