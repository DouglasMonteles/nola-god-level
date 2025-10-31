package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.DeliveryAddress;
import br.com.doug.god_level_challenge.repositories.DeliveryAddressRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class DeliveryAddressService {

    private final DeliveryAddressRepository deliveryAddressRepository;

    public Page<DeliveryAddress> findAll(Pageable pageable) {
        return deliveryAddressRepository.findAll(pageable);
    }

}
