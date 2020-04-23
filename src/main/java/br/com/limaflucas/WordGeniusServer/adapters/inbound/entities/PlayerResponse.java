package br.com.limaflucas.WordGeniusServer.adapters.inbound.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class PlayerResponse {

    private UUID playerID;
    private String sequence;
}
