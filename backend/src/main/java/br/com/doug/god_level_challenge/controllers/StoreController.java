package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.Store;
import br.com.doug.god_level_challenge.services.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/stores")
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    public ResponseEntity<Page<Store>> findAll(Pageable pageable) {
        var stores = storeService.findAll(pageable);
        return ResponseEntity.ok().body(stores);
    }

}
