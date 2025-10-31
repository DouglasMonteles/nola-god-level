package br.com.doug.god_level_challenge.repositories;

import br.com.doug.god_level_challenge.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

}
