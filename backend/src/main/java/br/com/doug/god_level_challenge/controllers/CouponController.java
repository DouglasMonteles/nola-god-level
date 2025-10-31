package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.Coupon;
import br.com.doug.god_level_challenge.services.CouponService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/coupons")
public class CouponController {

    private final CouponService couponService;

    @GetMapping
    public ResponseEntity<Page<Coupon>> findAll(Pageable pageable) {
        var coupons = couponService.findAll(pageable);
        return ResponseEntity.ok().body(coupons);
    }

}
