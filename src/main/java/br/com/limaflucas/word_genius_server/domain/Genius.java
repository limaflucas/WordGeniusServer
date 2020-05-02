package br.com.limaflucas.word_genius_server.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

@Data
@Builder
public class Genius {

    private final LocalDateTime timestampLastSequence;
    private final String sequence;

    public Genius incrementSequence() {

        return Genius.builder()
                .sequence(new StringBuilder(Objects.toString(this.sequence, "")).append(String.valueOf(this.generateNextElement())).toString())
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
