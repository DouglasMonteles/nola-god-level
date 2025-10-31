package br.com.doug.god_level_challenge.repositories;

import br.com.doug.god_level_challenge.models.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

}
