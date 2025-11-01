package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.Product;
import br.com.doug.god_level_challenge.models.dtos.QuantityProductSaleByPeriodDTO;
import br.com.doug.god_level_challenge.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> findAll(Pageable pageable) {
        var products = productService.findAll(pageable);
        return ResponseEntity.ok().body(products);
    }

    @GetMapping(value = "/reports/quantityProductSaleByPeriod")
    public ResponseEntity<Page<QuantityProductSaleByPeriodDTO>> quantityProductSaleByPeriod(
            @RequestParam(defaultValue = "COMPLETED") String saleStatusDesc,
            @RequestParam() String channelName,
            @RequestParam() LocalDateTime initialDateTime,
            @RequestParam() LocalDateTime finalDateTime,
            Pageable pageable
    ) {
        var listQuantityProductSaleByPeriod = productService.findQuantityProductSaleByPeriod(
                saleStatusDesc,
                channelName,
                initialDateTime,
                finalDateTime,
                pageable);

        return ResponseEntity.ok().body(listQuantityProductSaleByPeriod);
    }

}
