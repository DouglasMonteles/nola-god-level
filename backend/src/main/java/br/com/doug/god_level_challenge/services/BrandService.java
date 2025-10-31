package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.Brand;
import br.com.doug.god_level_challenge.repositories.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BrandService {

    private final BrandRepository brandRepository;

    public Page<Brand> findAll(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

}
