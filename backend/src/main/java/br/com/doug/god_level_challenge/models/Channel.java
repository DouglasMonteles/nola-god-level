package br.com.doug.god_level_challenge.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "channels")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class Channel implements Serializable {

    @Serial
    private static final long serialVersionUID = -4148469735386674705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime createdAt;

    @Column(length = 255)
    private String description;

    @Column(length = 100, nullable = false)
    private String name;

    @Column
    private Character type;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

}
