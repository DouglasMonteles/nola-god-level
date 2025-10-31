package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.Customer;
import br.com.doug.god_level_challenge.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<Page<Customer>> findAll(Pageable pageable) {
        var customers = customerService.findAll(pageable);
        return ResponseEntity.ok().body(customers);
    }

}
