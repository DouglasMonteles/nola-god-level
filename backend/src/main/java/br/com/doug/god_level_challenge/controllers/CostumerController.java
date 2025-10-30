package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.Costumer;
import br.com.doug.god_level_challenge.services.CostumerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/costumers")
public class CostumerController {

    private final CostumerService costumerService;

    @GetMapping
    public ResponseEntity<Page<Costumer>> findAll(Pageable pageable) {
        var costumers = costumerService.findAll(pageable);
        return ResponseEntity.ok().body(costumers);
    }

}
