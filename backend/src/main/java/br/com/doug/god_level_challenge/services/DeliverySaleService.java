package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.DeliverySale;
import br.com.doug.god_level_challenge.repositories.DeliverySaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeliverySaleService {

    private final DeliverySaleRepository deliverySaleRepository;

    public Page<DeliverySale> findAll(Pageable pageable) {
        return deliverySaleRepository.findAll(pageable);
    }

}
