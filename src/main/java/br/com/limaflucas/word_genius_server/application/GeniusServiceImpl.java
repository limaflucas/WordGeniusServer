package br.com.limaflucas.word_genius_server.application;

import br.com.limaflucas.word_genius_server.application.dtos.*;
import br.com.limaflucas.word_genius_server.application.mappers.GeneralMapper;
import br.com.limaflucas.word_genius_server.application.ports.RegisterPlayerPort;
import br.com.limaflucas.word_genius_server.domain.Player;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class GeniusServiceImpl implements UseCaseRegisterPlayer, UseCaseStartGame, UseCaseChallengeGenius, UseCaseGetScore {

    private final RegisterPlayerPort registerPlayerPort;
    private final GeneralMapper<PlayerPortDTO, RegisteredPlayerDTO> playerPortDTORegisteredPlayerDTOGeneralMapper;

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
        return null;
    }

    @Override
    public PlayerScoreDTO score(GameScoreDTO playerDTO) {
        return null;
    }

    @Override
    public GeniusResponseDTO start(PlayerScoreDTO playerDTO) {
        return null;
    }
}
