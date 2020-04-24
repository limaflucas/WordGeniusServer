package br.com.limaflucas.word_genius_server.application.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class PlayerResponseDTO {

    private final UUID playerID;
    private final LocalDateTime performedAt;
    private final String sequence;
    private final UUID gameID;
}
