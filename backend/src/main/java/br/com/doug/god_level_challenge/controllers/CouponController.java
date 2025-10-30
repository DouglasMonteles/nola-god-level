package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.CouponSale;
import br.com.doug.god_level_challenge.services.CouponSaleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/couponSales")
public class CouponSaleController {

    private final CouponSaleService couponSaleService;

    @GetMapping
    public ResponseEntity<Page<CouponSale>> findAll(Pageable pageable) {
        var couponSales = couponSaleService.findAll(pageable);
        return ResponseEntity.ok().body(couponSales);
    }

}
