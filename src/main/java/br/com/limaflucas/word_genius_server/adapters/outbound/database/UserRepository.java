package br.com.limaflucas.word_genius_server.adapters.outbound.database;

import br.com.limaflucas.word_genius_server.adapters.outbound.database.entities.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<Users, UUID> {
}
