package br.com.limaflucas.word_genius_server.application.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class GameScoreDTO {

    private final UUID playerID;
    private final UUID gameID;
}
