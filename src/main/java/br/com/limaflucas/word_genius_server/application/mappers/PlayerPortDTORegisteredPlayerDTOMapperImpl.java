package br.com.limaflucas.word_genius_server.application.mappers;

import br.com.limaflucas.word_genius_server.application.dtos.PlayerPortDTO;
import br.com.limaflucas.word_genius_server.application.dtos.RegisteredPlayerDTO;
import org.springframework.stereotype.Component;

@Component
public class PlayerPortDTORegisteredPlayerDTOMapperImpl implements GeneralMapper<PlayerPortDTO, RegisteredPlayerDTO> {

    @Override
    public RegisteredPlayerDTO to(PlayerPortDTO playerPortDTO) {
        return RegisteredPlayerDTO.builder()
                .createdAt(playerPortDTO.getCreatedAt())
                .id(playerPortDTO.getPlayerID())
                .name(playerPortDTO.getName())
                .build();
    }
}
