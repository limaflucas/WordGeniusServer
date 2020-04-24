package br.com.limaflucas.word_genius_server.adapters.inbound;

import br.com.limaflucas.word_genius_server.adapters.inbound.entities.*;

import java.util.UUID;

public interface DefaultActions {

    RegisterResponse register(ResgisterPayload payload);
    StartResponse start(UUID playerID);
    GeniusResponse challenge(PlayerResponse response);
    ScoreResponse score(UUID playerID);
}
