package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.Payment;
import br.com.doug.god_level_challenge.services.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @GetMapping
    public ResponseEntity<Page<Payment>> findAll(Pageable pageable) {
        var payments = paymentService.findAll(pageable);
        return ResponseEntity.ok().body(payments);
    }

}
