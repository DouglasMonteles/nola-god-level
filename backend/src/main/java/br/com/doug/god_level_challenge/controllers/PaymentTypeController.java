package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.PaymentType;
import br.com.doug.god_level_challenge.services.PaymentTypeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/paymentTypes")
public class PaymentTypeController {

    private final PaymentTypeService paymentTypeService;

    public PaymentTypeController(PaymentTypeService paymentTypeService) {
        this.paymentTypeService = paymentTypeService;
    }

    @GetMapping
    public ResponseEntity<Page<PaymentType>> findAll(Pageable pageable) {
        var paymentTypes = paymentTypeService.findAll(pageable);
        return ResponseEntity.ok().body(paymentTypes);
    }

}
