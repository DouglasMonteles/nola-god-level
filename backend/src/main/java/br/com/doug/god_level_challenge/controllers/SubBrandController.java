package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.SubBrand;
import br.com.doug.god_level_challenge.services.SubBrandService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/subBrands")
public class SubBrandController {

    private final SubBrandService subBrandService;

    @GetMapping
    public ResponseEntity<Page<SubBrand>> findAll(Pageable pageable) {
        var subBrands = subBrandService.findAll(pageable);
        return ResponseEntity.ok().body(subBrands);
    }

}
