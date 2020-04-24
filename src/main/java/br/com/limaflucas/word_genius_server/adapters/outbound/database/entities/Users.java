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
public class Users {

    @Id private UUID id;
    @Column(name = "nickname") private String name;
    private LocalDateTime createdat;
}
