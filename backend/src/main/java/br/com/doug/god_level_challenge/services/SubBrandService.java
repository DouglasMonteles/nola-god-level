package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.SubBrand;
import br.com.doug.god_level_challenge.repositories.SubBrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class SubBrandService {

    private final SubBrandRepository subBrandRepository;

    public Page<SubBrand> findAll(Pageable pageable) {
        return subBrandRepository.findAll(pageable);
    }

}
