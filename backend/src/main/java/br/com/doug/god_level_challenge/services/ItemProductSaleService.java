package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.ItemItemProductSale;
import br.com.doug.god_level_challenge.repositories.ItemItemProductSaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ItemItemProductSaleService {

    private final ItemItemProductSaleRepository itemItemProductSaleRepository;

    public Page<ItemItemProductSale> findAll(Pageable pageable) {
        return itemItemProductSaleRepository.findAll(pageable);
    }

}
