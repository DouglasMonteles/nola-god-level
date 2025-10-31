package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.CouponSale;
import br.com.doug.god_level_challenge.repositories.CouponSaleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CouponSaleService {

    private final CouponSaleRepository couponSaleRepository;

    public Page<CouponSale> findAll(Pageable pageable) {
        return couponSaleRepository.findAll(pageable);
    }

}
