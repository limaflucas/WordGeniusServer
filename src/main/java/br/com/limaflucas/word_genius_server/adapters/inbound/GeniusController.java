package br.com.limaflucas.word_genius_server.adapters.inbound;

import br.com.limaflucas.word_genius_server.adapters.inbound.entities.*;
import br.com.limaflucas.word_genius_server.adapters.mappers.GeneralMapper;
import br.com.limaflucas.word_genius_server.application.UseCaseChallengeGenius;
import br.com.limaflucas.word_genius_server.application.UseCaseGetScore;
import br.com.limaflucas.word_genius_server.application.UseCaseRegisterPlayer;
import br.com.limaflucas.word_genius_server.application.UseCaseStartGame;
import br.com.limaflucas.word_genius_server.application.dtos.PlayerDTO;
import br.com.limaflucas.word_genius_server.application.dtos.RegisteredPlayerDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Random;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/genius")
public class GeniusController implements DefaultActions {

//    SERVICES
    private final UseCaseRegisterPlayer useCaseRegisterPlayer;
    private final UseCaseStartGame useCaseStartGame;
    private final UseCaseChallengeGenius useCaseChallengeGenius;
    private final UseCaseGetScore useCaseGetScore;

//    MAPPERS
    private final GeneralMapper<ResgisterPayload, PlayerDTO> resgisterPayloadPlayerDTOGeneralMapper;
    private final GeneralMapper<RegisteredPlayerDTO, RegisterResponse> registeredPlayerDTORegisterResponseGeneralMapper;


    @Override
    @PostMapping(value = "/register")
    public RegisterResponse register(@RequestBody ResgisterPayload payload) {

        log.info("Receda solicitacao de registro: {}", payload);
        RegisteredPlayerDTO registeredPlayerDTO = this.useCaseRegisterPlayer.register(this.resgisterPayloadPlayerDTOGeneralMapper.to(payload));
        log.info("Player registrado: {}", registeredPlayerDTO);

        return this.registeredPlayerDTORegisterResponseGeneralMapper.to(registeredPlayerDTO);
    }

    @Override
    @PostMapping(value = "/start/{playerID}")
    public StartResponse start(@PathVariable UUID playerID) {

        return null;
    }

    @Override
    @PostMapping(value = "/challenge")
    public GeniusResponse challenge(@RequestBody PlayerResponse response) {

        return new GeniusResponse(response.getPlayerID(), response.getSequence());
    }

    @Override
    @GetMapping(value = "/score/{playerID}")
    public ScoreResponse score(@PathVariable UUID playerID) {

        return new ScoreResponse(playerID, new BigInteger(24, new Random()));
    }
}
