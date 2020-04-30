package br.com.limaflucas.word_genius_server.adapters.outbound.database;

import br.com.limaflucas.word_genius_server.adapters.outbound.database.repositories.GameRepository;
import br.com.limaflucas.word_genius_server.application.dtos.StartedGameDTO;
import br.com.limaflucas.word_genius_server.application.ports.LoadGamePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class LoadGamePortImpl implements LoadGamePort {

    private final GameRepository gameRepository;

    @Override
    public StartedGameDTO load(UUID gameID) {
        return this.gameRepository.findById(gameID).map(games -> StartedGameDTO.builder()
                .gameID(games.getId())
                .lastGeneratedSequenceAt(games.getLastGeneratedAt())
                .playerID(games.getPlayerId())
                .sequence(games.getSequence())
                .startedAt(games.getStartedAt())
                .build())
                .orElse(StartedGameDTO.builder().build());
    }
}
