package br.com.limaflucas.word_genius_server.adapters.outbound.database.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Games {

    @Id private UUID id;
    @Column private UUID playerId;
    @Column private LocalDateTime startedAt;
    @Column private String sequence;
    @Column private LocalDateTime lastGeneratedAt;
}
