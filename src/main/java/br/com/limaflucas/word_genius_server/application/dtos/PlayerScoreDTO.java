package br.com.limaflucas.word_genius_server.application.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class PlayerScoreDTO {

    private final UUID playerID;
    private final UUID gameID;
    private final Long score;
    private final LocalDateTime retrievedAt;
}
