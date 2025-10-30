package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.ProductSale;
import br.com.doug.god_level_challenge.services.ProductSaleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/productSales")
public class ProductSaleController {

    private final ProductSaleService productSaleService;

    @GetMapping
    public ResponseEntity<Page<ProductSale>> findAll(Pageable pageable) {
        var productSales = productSaleService.findAll(pageable);
        return ResponseEntity.ok().body(productSales);
    }

}
