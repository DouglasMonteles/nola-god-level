package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.ProductSale;
import br.com.doug.god_level_challenge.repositories.ProductSaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductSaleService {

    private final ProductSaleRepository productSaleRepository;

    public Page<ProductSale> findAll(Pageable pageable) {
        return productSaleRepository.findAll(pageable);
    }

}
