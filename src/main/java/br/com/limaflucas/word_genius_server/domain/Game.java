package br.com.limaflucas.word_genius_server.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Game {

    private final UUID id;
    private final LocalDateTime startedAt;
    private final Player player;
    private final GameStatus status;
    private final Genius genius;
}
