package br.com.limaflucas.word_genius_server.adapters.mappers;

import br.com.limaflucas.word_genius_server.adapters.inbound.entities.ResgisterPayload;
import br.com.limaflucas.word_genius_server.application.dtos.PlayerDTO;
import org.springframework.stereotype.Component;

@Component
public class ResgisterPayloadPlayerDTOMapperImpl implements GeneralMapper<ResgisterPayload, PlayerDTO> {

    @Override
    public PlayerDTO to(ResgisterPayload resgisterPayload) {
        return PlayerDTO.builder()
                .name(resgisterPayload.getName())
                .build();
    }
}
