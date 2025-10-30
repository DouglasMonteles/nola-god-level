package br.com.doug.god_level_challenge.services;

import br.com.doug.god_level_challenge.models.Channel;
import br.com.doug.god_level_challenge.repositories.ChannelRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ChannelService {

    private final ChannelRepository channelRepository;

    public Page<Channel> findAll(Pageable pageable) {
        return channelRepository.findAll(pageable);
    }

}
