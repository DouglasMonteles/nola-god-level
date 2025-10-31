package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.ItemProductSale;
import br.com.doug.god_level_challenge.services.ItemProductSaleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/itemProductSales")
public class ItemProductSaleController {

    private final ItemProductSaleService itemProductSaleService;

    @GetMapping
    public ResponseEntity<Page<ItemProductSale>> findAll(Pageable pageable) {
        var itemsProductSales = itemProductSaleService.findAll(pageable);
        return ResponseEntity.ok().body(itemsProductSales);
    }

}
