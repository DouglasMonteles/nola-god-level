package br.com.doug.god_level_challenge.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = -4148469735386674705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 100)
    private String posUuid;

    @Column
    private Character type;

    @Column
    private LocalDateTime deletedAt;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column
    private Long subBrandId;

}
