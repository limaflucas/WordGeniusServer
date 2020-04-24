package br.com.limaflucas.word_genius_server.adapters.inbound.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class GeniusResponse {

    private UUID playerID;
    private String sequence;
}
