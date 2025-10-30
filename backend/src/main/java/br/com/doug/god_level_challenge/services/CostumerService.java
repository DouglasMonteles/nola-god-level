package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.Costumer;
import br.com.doug.god_level_challenge.repositories.CostumerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CostumerService {

    private final CostumerRepository costumerRepository;

    public Page<Costumer> findAll(Pageable pageable) {
        return costumerRepository.findAll(pageable);
    }

}
