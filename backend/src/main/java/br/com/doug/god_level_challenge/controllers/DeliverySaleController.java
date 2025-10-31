package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.DeliverySale;
import br.com.doug.god_level_challenge.services.DeliverySaleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/deliverySales")
public class DeliverySaleController {

    private final DeliverySaleService deliverySaleService;

    @GetMapping
    public ResponseEntity<Page<DeliverySale>> findAll(Pageable pageable) {
        var deliverySales = deliverySaleService.findAll(pageable);
        return ResponseEntity.ok().body(deliverySales);
    }

}
