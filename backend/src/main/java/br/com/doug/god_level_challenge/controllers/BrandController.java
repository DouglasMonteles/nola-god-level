package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.Brand;
import br.com.doug.god_level_challenge.services.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/brands")
public class BrandController {

    private final BrandService brandService;

    @GetMapping
    public ResponseEntity<Page<Brand>> findAll(Pageable pageable) {
        var brands = brandService.findAll(pageable);
        return ResponseEntity.ok().body(brands);
    }

}
