package br.com.limaflucas.word_genius_server.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
public class Player {

    private final UUID id;
    private final String name;
    private final LocalDateTime createdAt;

    public static Player createNewPlayer(String name) {
        return Player.builder()
                .createdAt(LocalDateTime.now())
                .name(name)
                .id(UUID.randomUUID())
                .build();
    }
}
