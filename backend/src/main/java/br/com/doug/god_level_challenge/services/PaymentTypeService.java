package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.PaymentType;
import br.com.doug.god_level_challenge.repositories.PaymentTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PaymentTypeService {

    private final PaymentTypeRepository paymentTypeRepository;

    public PaymentTypeService(PaymentTypeRepository paymentTypeRepository) {
        this.paymentTypeRepository = paymentTypeRepository;
    }

    public Page<PaymentType> findAll(Pageable pageable) {
        return paymentTypeRepository.findAll(pageable);
    }

}
