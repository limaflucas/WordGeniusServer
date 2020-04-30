package br.com.limaflucas.word_genius_server.adapters.inbound.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class GeniusResponse {

    private UUID playerID;
    private UUID gameID;
    private String sequence;
    private String gameStatus;
    private String gameMessage;
}
