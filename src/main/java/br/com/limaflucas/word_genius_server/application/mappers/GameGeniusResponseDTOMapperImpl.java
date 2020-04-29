package br.com.limaflucas.word_genius_server.application.mappers;

import br.com.limaflucas.word_genius_server.application.dtos.GeniusResponseDTO;
import br.com.limaflucas.word_genius_server.domain.Game;
import org.springframework.stereotype.Component;

@Component
public class GameGeniusResponseDTOMapperImpl implements GeneralMapper<Game, GeniusResponseDTO>{

    @Override
    public GeniusResponseDTO to(Game game) {
        return GeniusResponseDTO.builder()
                .playerID(game.getPlayer().getId())
                .performedAt(game.getGenius().getTimestampLastSequence())
                .gameStatus(game.getStatus().name())
                .gameID(game.getId())
                .sequece(game.getGenius().getSequence())
                .build();
    }
}
