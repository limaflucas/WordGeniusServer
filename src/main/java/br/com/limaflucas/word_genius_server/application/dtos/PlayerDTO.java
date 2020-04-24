package br.com.limaflucas.word_genius_server.application.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlayerDTO {

    private final String name;
}
