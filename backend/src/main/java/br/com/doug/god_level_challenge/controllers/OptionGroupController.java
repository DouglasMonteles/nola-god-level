package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.OptionGroup;
import br.com.doug.god_level_challenge.services.OptionGroupService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/optionGroups")
public class OptionGroupController {

    private final OptionGroupService optionGroupService;

    @GetMapping
    public ResponseEntity<Page<OptionGroup>> findAll(Pageable pageable) {
        var optionGroups = optionGroupService.findAll(pageable);
        return ResponseEntity.ok().body(optionGroups);
    }

}
