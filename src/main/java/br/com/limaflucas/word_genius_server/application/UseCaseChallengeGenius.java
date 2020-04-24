package br.com.limaflucas.word_genius_server.application;

import br.com.limaflucas.word_genius_server.application.dtos.GeniusResponseDTO;
import br.com.limaflucas.word_genius_server.application.dtos.PlayerResponseDTO;

public interface UseCaseChallengeGenius {

    GeniusResponseDTO challenge(PlayerResponseDTO playerResponseDTO);
}
