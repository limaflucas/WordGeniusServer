package br.com.limaflucas.word_genius_server.adapters.mappers;

import br.com.limaflucas.word_genius_server.adapters.inbound.entities.PlayerResponse;
import br.com.limaflucas.word_genius_server.application.dtos.PlayerResponseDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PlayerResponsePlayerResponseDTOMapperImpl implements GeneralMapper<PlayerResponse, PlayerResponseDTO> {

    @Override
    public PlayerResponseDTO to(PlayerResponse playerResponse) {
        return PlayerResponseDTO.builder()
                .gameID(playerResponse.getGameID())
//                FIXME :: DEVE VIR DA REQUISICAO
                .performedAt(LocalDateTime.now())
                .playerID(playerResponse.getPlayerID())
                .sequence(playerResponse.getSequence())
                .build();
    }
}
