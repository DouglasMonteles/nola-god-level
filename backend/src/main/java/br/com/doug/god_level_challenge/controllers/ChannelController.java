package br.com.doug.god_level_challenge.controllers;

import br.com.doug.god_level_challenge.models.Channel;
import br.com.doug.god_level_challenge.services.ChannelService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping(value = "/channels")
public class ChannelController {

    private final ChannelService channelService;

    @GetMapping
    public ResponseEntity<Page<Channel>> findAll(Pageable pageable) {
        var channels = channelService.findAll(pageable);
        return ResponseEntity.ok().body(channels);
    }

}
