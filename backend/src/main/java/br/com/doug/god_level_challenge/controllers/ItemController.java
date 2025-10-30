package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.Item;
import br.com.doug.god_level_challenge.services.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/items")
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<Page<Item>> findAll(Pageable pageable) {
        var items = itemService.findAll(pageable);
        return ResponseEntity.ok().body(items);
    }

}
