package br.com.doug.god_level_challenge.repositories;

import br.com.doug.god_level_challenge.models.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Long> {

}
