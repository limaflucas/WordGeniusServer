package br.com.limaflucas.word_genius_server.application.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class UpdatedGameDTO {

    private final UUID gameID;
    private final String sequence;
    private final LocalDateTime lastSequenceGeneratedAt;
}
