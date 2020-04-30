package br.com.limaflucas.word_genius_server.adapters.outbound.database.repositories;

import br.com.limaflucas.word_genius_server.adapters.outbound.database.entities.Games;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.UUID;

public interface GameRepository extends CrudRepository<Games, UUID> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Games g SET g.sequence = :sequence, g.lastGeneratedAt = :lastGeneratedAt WHERE g.id = :gameID")
    int upateRunningGame(@Param("gameID") UUID gameID, @Param("sequence") String sequece, @Param("lastGeneratedAt") LocalDateTime lastSequenceGeneratedAt);
}
