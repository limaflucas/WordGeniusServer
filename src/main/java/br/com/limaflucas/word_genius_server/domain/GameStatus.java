package br.com.limaflucas.word_genius_server.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GameStatus {
    RUNNING("The game must go on"),
    LOSER("Sorry... I'm the best"),
    WINNER("No way... Best-of-three!");

    private final String message;
}
