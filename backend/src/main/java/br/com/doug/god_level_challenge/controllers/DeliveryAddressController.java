package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.DeliveryAddress;
import br.com.doug.god_level_challenge.services.DeliveryAddressService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/deliveryAddress")
public class DeliveryAddressController {

    private final DeliveryAddressService deliveryAddressService;

    @GetMapping
    public ResponseEntity<Page<DeliveryAddress>> findAll(Pageable pageable) {
        var brands = deliveryAddressService.findAll(pageable);
        return ResponseEntity.ok().body(brands);
    }

}
