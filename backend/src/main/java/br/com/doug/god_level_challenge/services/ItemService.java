package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.Item;
import br.com.doug.god_level_challenge.repositories.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public Page<Item> findAll(Pageable pageable) {
        return itemRepository.findAll(pageable);
    }

}
