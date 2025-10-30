package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.OptionGroup;
import br.com.doug.god_level_challenge.repositories.OptionGroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OptionGroupService {

    private final OptionGroupRepository optionGroupRepository;

    public Page<OptionGroup> findAll(Pageable pageable) {
        return optionGroupRepository.findAll(pageable);
    }

}
