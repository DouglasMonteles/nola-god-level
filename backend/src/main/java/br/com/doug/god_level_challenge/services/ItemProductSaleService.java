package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.ItemProductSale;
import br.com.doug.god_level_challenge.repositories.ItemProductSaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ItemProductSaleService {

    private final ItemProductSaleRepository itemProductSaleRepository;

    public Page<ItemProductSale> findAll(Pageable pageable) {
        return itemProductSaleRepository.findAll(pageable);
    }

}
