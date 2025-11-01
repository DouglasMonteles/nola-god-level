package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.Product;
import br.com.doug.god_level_challenge.models.dtos.QuantityProductSaleByPeriodDTO;
import br.com.doug.god_level_challenge.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Page<QuantityProductSaleByPeriodDTO> findQuantityProductSaleByPeriod(
            String saleStatusDesc,
            String channelName,
            LocalDateTime initialDateTime,
            LocalDateTime finalDateTime,
            Pageable pageable
    ) {
        return productRepository.findQuantityProductSaleByPeriod(
                saleStatusDesc,
                channelName,
                initialDateTime,
                finalDateTime,
                pageable
        );
    }

}
