package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.Sale;
import br.com.doug.god_level_challenge.repositories.SaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public Page<Sale> findAll(Pageable pageable) {
        return saleRepository.findAll(pageable);
    }

}
