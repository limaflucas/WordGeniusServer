package br.com.limaflucas.word_genius_server.adapters.outbound;

import br.com.limaflucas.word_genius_server.adapters.outbound.database.repositories.UserRepository;
import br.com.limaflucas.word_genius_server.adapters.outbound.database.entities.Users;
import br.com.limaflucas.word_genius_server.application.dtos.PlayerPortDTO;
import br.com.limaflucas.word_genius_server.application.ports.RegisterPlayerPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RegisterPlayerPortImpl implements RegisterPlayerPort {

    private final UserRepository userRepository;

    @Override
    public PlayerPortDTO register(PlayerPortDTO playerPortDTO) {

        log.info("Salvando no banco usuario: {}", playerPortDTO);

        this.userRepository.save(new Users(playerPortDTO.getPlayerID(), playerPortDTO.getName(), playerPortDTO.getCreatedAt()));

        return playerPortDTO;
    }
}
