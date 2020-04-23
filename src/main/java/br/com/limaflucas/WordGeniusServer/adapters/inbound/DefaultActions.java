package br.com.limaflucas.WordGeniusServer.adapters.inbound;

import br.com.limaflucas.WordGeniusServer.adapters.inbound.entities.*;

import java.util.UUID;

public interface DefaultActions {

    RegisterResponse register(ResgisterPayload payload);
    StartResponse start(UUID playerID);
    GeniusResponse challenge(PlayerResponse response);
    ScoreResponse score(UUID playerID);
}
