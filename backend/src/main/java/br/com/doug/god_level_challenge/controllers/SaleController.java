package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.Sale;
import br.com.doug.god_level_challenge.models.dtos.SaleBasicInfoDTO;
import br.com.doug.god_level_challenge.services.SaleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<Page<Sale>> findAll(Pageable pageable) {
        var sales = saleService.findAll(pageable);
        return ResponseEntity.ok().body(sales);
    }

    @GetMapping("/{saleId}")
    public ResponseEntity<SaleBasicInfoDTO> findSaleById(@PathVariable Long saleId) {
        var sale = saleService.findBySaleId(saleId);
        return ResponseEntity.ok().body(sale);
    }

}
