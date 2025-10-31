package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.Payment;
import br.com.doug.god_level_challenge.repositories.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Page<Payment> findAll(Pageable pageable) {
        return paymentRepository.findAll(pageable);
    }

}
