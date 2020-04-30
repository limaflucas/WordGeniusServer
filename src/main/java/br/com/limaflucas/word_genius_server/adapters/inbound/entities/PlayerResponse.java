package br.com.limaflucas.word_genius_server.adapters.inbound.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class PlayerResponse {

    private UUID playerID;
    private UUID gameID;
    private String sequence;

//    TODO :: INCLUIR TIMESTAMP DA JOGADA PARA CALCULAR O TEMPO ENTRE AS RESPOSTAS
}
