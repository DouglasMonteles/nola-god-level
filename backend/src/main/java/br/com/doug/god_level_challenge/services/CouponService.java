package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.Coupon;
import br.com.doug.god_level_challenge.repositories.CouponRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public Page<Coupon> findAll(Pageable pageable) {
        return couponRepository.findAll(pageable);
    }

}
