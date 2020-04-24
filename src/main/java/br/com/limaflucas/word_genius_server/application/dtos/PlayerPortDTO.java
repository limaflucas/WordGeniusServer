package br.com.limaflucas.word_genius_server.application.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class PlayerPortDTO {

    private final UUID playerID;
    private final String name;
    private final LocalDateTime createdAt;
}
