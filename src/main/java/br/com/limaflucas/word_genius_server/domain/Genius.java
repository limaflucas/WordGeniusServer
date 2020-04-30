package br.com.limaflucas.word_genius_server.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Random;

@Data
@Builder
public class Genius {

    private final LocalDateTime timestampLastSequence;
    private final String sequence;

    public Genius incrementSequence() {
        return Genius.builder()
                .sequence(sequence.concat(String.valueOf(this.generateNextElement())))
                .timestampLastSequence(LocalDateTime.now())
                .build();
    }

    private char[] generateNextElement() {
        return Character.toChars(new Random().nextInt((126 - 33) + 1) + 33);
    }

    public Boolean validadeSequence(String sequence) {
        return this.sequence.equalsIgnoreCase(sequence);
    }
}
