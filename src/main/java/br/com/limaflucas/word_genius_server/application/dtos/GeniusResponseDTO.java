package br.com.limaflucas.word_genius_server.application.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class GeniusResponseDTO {

    private final UUID playerID;
    private final LocalDateTime performedAt;
    private final String sequece;
    private final Boolean gameStatus;
    private final UUID gameID;
}
