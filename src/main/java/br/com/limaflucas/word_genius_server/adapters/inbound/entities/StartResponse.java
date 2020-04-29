package br.com.limaflucas.word_genius_server.adapters.inbound.entities;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class StartResponse {

    private final UUID playerID;
    private final UUID gameID;
    private final String sequence;
    private final LocalDateTime statedAt;
    private final String gameStatus;
}
