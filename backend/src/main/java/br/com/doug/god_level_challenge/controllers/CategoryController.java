package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.Category;
import br.com.doug.god_level_challenge.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<Page<Category>> findAll(Pageable pageable) {
        var categories = categoryService.findAll(pageable);
        return ResponseEntity.ok().body(categories);
    }

}
