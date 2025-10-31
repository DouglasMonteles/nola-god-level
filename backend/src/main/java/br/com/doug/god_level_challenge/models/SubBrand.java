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
@Table(name = "sub_brands")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = { "id" })
@ToString
public class SubBrand implements Serializable {

    @Serial
    private static final long serialVersionUID = -4148469735386674705L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String name;

    @Column
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @JsonIgnore
    @OneToMany(mappedBy = "subBrand")
    private List<Category> categories = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "subBrand")
    private List<Customer> customers = new ArrayList<>();

}
