package br.com.doug.god_level_challenge.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class Costumer implements Serializable {

    @Serial
    private static final long serialVersionUID = -4148469735386674705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Boolean agreeTerms;

    @Column(length = 100)
    private String cpf;

    @Column(length = 100)
    private String costumerName;

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

    @Column
    private Long storeId;

    @Column
    private Long subBrandId;

}
