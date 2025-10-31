package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.Store;
import br.com.doug.god_level_challenge.repositories.StoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public Page<Store> findAll(Pageable pageable) {
        return storeRepository.findAll(pageable);
    }

}
