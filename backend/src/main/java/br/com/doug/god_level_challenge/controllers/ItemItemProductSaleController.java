package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.ItemItemProductSale;
import br.com.doug.god_level_challenge.services.ItemItemProductSaleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/itemItemProductSales")
public class ItemItemProductSaleController {

    private final ItemItemProductSaleService itemItemProductSaleService;

    @GetMapping
    public ResponseEntity<Page<ItemItemProductSale>> findAll(Pageable pageable) {
        var itemsProductSales = itemItemProductSaleService.findAll(pageable);
        return ResponseEntity.ok().body(itemsProductSales);
    }

}
