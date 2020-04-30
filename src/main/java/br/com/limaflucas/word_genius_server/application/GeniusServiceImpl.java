package br.com.limaflucas.word_genius_server.application;

import br.com.limaflucas.word_genius_server.application.dtos.*;
import br.com.limaflucas.word_genius_server.application.mappers.GeneralMapper;
import br.com.limaflucas.word_genius_server.application.ports.LoadGamePort;
import br.com.limaflucas.word_genius_server.application.ports.RegisterPlayerPort;
import br.com.limaflucas.word_genius_server.application.ports.StartGamePort;
import br.com.limaflucas.word_genius_server.application.ports.UpdateGamePort;
import br.com.limaflucas.word_genius_server.domain.Game;
import br.com.limaflucas.word_genius_server.domain.GameStatus;
import br.com.limaflucas.word_genius_server.domain.Genius;
import br.com.limaflucas.word_genius_server.domain.Player;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class GeniusServiceImpl implements UseCaseRegisterPlayer, UseCaseStartGame, UseCaseChallengeGenius, UseCaseGetScore {

//    PORTS
    private final RegisterPlayerPort registerPlayerPort;
    private final StartGamePort startGamePort;
    private final LoadGamePort loadGamePort;
    private final UpdateGamePort updateGamePort;

//    MAPPERS
    private final GeneralMapper<PlayerPortDTO, RegisteredPlayerDTO> playerPortDTORegisteredPlayerDTOGeneralMapper;
    private final GeneralMapper<Game, GeniusResponseDTO> gameGeniusResponseDTOGeneralMapper;

    @Override
    public RegisteredPlayerDTO register(PlayerDTO playerDTO) {

        Player newPlayer = Player.createNewPlayer(playerDTO.getName());
        PlayerPortDTO registeredPlayer = this.registerPlayerPort.register(
                PlayerPortDTO.builder()
                        .createdAt(newPlayer.getCreatedAt())
                        .name(newPlayer.getName())
                        .playerID(newPlayer.getId())
                        .build());

        return this.playerPortDTORegisteredPlayerDTOGeneralMapper.to(registeredPlayer);
    }

    @Override
    public GeniusResponseDTO challenge(PlayerResponseDTO playerResponseDTO) {

        StartedGameDTO startedGameDTO = this.loadGamePort.load(playerResponseDTO.getGameID());

//        TODO :: VALIDAR SE O JOGO JA FOI ENCERRADO
        Game runningGame = Game.builder()
                .genius(Genius.builder()
                        .timestampLastSequence(startedGameDTO.getLastGeneratedSequenceAt())
                        .sequence(startedGameDTO.getSequence())
                        .build())
                .startedAt(startedGameDTO.getStartedAt())
                .player(Player.builder()
                        .id(startedGameDTO.getPlayerID())
                        .build())
                .id(startedGameDTO.getGameID())
                .build();

        GeniusResponseDTO geniusResponseDTO = null;
        if (runningGame.getGenius().validadeSequence(playerResponseDTO.getSequence())) {
            Genius nextChallenge = runningGame.getGenius().incrementSequence();
            this.updateGamePort.update(UpdatedGameDTO.builder()
                    .gameID(runningGame.getId())
                    .lastSequenceGeneratedAt(nextChallenge.getTimestampLastSequence())
                    .sequence(nextChallenge.getSequence())
                    .build());
            geniusResponseDTO = GeniusResponseDTO.builder()
                    .gameStatus(GameStatus.RUNNING.name())
                    .playerID(runningGame.getPlayer().getId())
                    .gameID(runningGame.getId())
                    .sequece(nextChallenge.getSequence())
                    .performedAt(nextChallenge.getTimestampLastSequence())
                    .build();
        }
        else
            geniusResponseDTO = GeniusResponseDTO.builder()
                    .gameID(runningGame.getId())
                    .playerID(runningGame.getPlayer().getId())
                    .gameStatus(GameStatus.LOSER.name())
                    .gameMessage(GameStatus.LOSER.getMessage())
                    .build();

        return geniusResponseDTO;
    }

    @Override
    public PlayerScoreDTO score(GameScoreDTO playerDTO) {
        return null;
    }

    @Override
    public GeniusResponseDTO start(StartGameDTO startGameDTO) {

//        TODO :: VALIDAR SE O PLAYER ESTA REGISTRADO
        Game newGame = Game.builder()
                .id(UUID.randomUUID())
                .player(Player.builder()
                        .id(startGameDTO.getPlayerID())
                        .build())
                .startedAt(LocalDateTime.now())
                .status(GameStatus.RUNNING)
                .genius(Genius.builder().build().incrementSequence())
                .build();

        this.startGamePort.start(StartedGameDTO.builder()
                .playerID(newGame.getPlayer().getId())
                .gameID(newGame.getId())
                .sequence(newGame.getGenius().getSequence())
                .lastGeneratedSequenceAt(newGame.getGenius().getTimestampLastSequence())
                .startedAt(newGame.getStartedAt())
                .build()
        );

        return this.gameGeniusResponseDTOGeneralMapper.to(newGame);
    }
}
