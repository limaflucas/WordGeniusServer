package br.com.limaflucas.word_genius_server.adapters.inbound;

import br.com.limaflucas.word_genius_server.adapters.inbound.entities.*;
import br.com.limaflucas.word_genius_server.adapters.mappers.GeneralMapper;
import br.com.limaflucas.word_genius_server.application.UseCaseChallengeGenius;
import br.com.limaflucas.word_genius_server.application.UseCaseGetScore;
import br.com.limaflucas.word_genius_server.application.UseCaseRegisterPlayer;
import br.com.limaflucas.word_genius_server.application.UseCaseStartGame;
import br.com.limaflucas.word_genius_server.application.dtos.*;
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
    private final GeneralMapper<PlayerResponse, PlayerResponseDTO> playerResponsePlayerResponseDTOGeneralMapper;


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

//        TODO: Buscar nome do cliente para exibir
        log.info("Iniciando genius contra {}", playerID);
        GeniusResponseDTO geniusResponseDTO = this.useCaseStartGame.start(StartGameDTO.builder()
                .playerID(playerID)
                .build());

        return StartResponse.builder()
                .gameID(geniusResponseDTO.getGameID())
                .gameStatus(geniusResponseDTO.getGameStatus())
                .playerID(geniusResponseDTO.getPlayerID())
                .sequence(geniusResponseDTO.getSequece())
                .statedAt(geniusResponseDTO.getPerformedAt())
                .build();
    }

    @Override
    @PostMapping(value = "/challenge")
    public GeniusResponse challenge(@RequestBody PlayerResponse response) {

        GeniusResponseDTO geniusResponseDTO = this.useCaseChallengeGenius.challenge(this.playerResponsePlayerResponseDTOGeneralMapper.to(response));
        return new GeniusResponse(geniusResponseDTO.getPlayerID(), geniusResponseDTO.getGameID(), geniusResponseDTO.getSequece(), geniusResponseDTO.getGameStatus(), geniusResponseDTO.getGameMessage());
    }

    @Override
    @GetMapping(value = "/score/{playerID}")
    public ScoreResponse score(@PathVariable UUID playerID) {

        return new ScoreResponse(playerID, new BigInteger(24, new Random()));
    }
}
