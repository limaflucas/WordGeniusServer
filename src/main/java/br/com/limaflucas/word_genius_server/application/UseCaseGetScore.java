package br.com.limaflucas.word_genius_server.application;

import br.com.limaflucas.word_genius_server.application.dtos.GameScoreDTO;
import br.com.limaflucas.word_genius_server.application.dtos.PlayerScoreDTO;

public interface UseCaseGetScore {

    PlayerScoreDTO score(GameScoreDTO playerDTO);
}
