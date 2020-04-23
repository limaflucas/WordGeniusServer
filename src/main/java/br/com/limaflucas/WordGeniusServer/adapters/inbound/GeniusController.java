package br.com.limaflucas.WordGeniusServer.adapters.inbound;

import br.com.limaflucas.WordGeniusServer.adapters.inbound.entities.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/genius")
@RequiredArgsConstructor
public class GeniusController implements DefaultActions {

    @Override
    @PostMapping(value = "/register")
    public RegisterResponse register(@RequestBody ResgisterPayload payload) {
        System.out.println(payload);
        return new RegisterResponse(UUID.nameUUIDFromBytes(payload.getName().getBytes()));
    }

    @Override
    @PostMapping(value = "/start/{playerID}")
    public StartResponse start(@PathVariable UUID playerID) {
        System.out.println(playerID);
        return null;
    }

    @Override
    @PostMapping(value = "/challenge")
    public GeniusResponse challenge(@RequestBody PlayerResponse response) {
        System.out.println(response);
        return new GeniusResponse(response.getPlayerID(), response.getSequence());
    }

    @Override
    @GetMapping(value = "/score/{playerID}")
    public ScoreResponse score(@PathVariable UUID playerID) {
        System.out.println(playerID);
        return new ScoreResponse(playerID, new BigInteger(24, new Random()));
    }
}
