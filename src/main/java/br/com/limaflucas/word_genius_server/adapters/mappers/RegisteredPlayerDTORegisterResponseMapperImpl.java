package br.com.limaflucas.word_genius_server.adapters.mappers;

import br.com.limaflucas.word_genius_server.adapters.inbound.entities.RegisterResponse;
import br.com.limaflucas.word_genius_server.application.dtos.RegisteredPlayerDTO;
import org.springframework.stereotype.Component;

@Component
public class RegisteredPlayerDTORegisterResponseMapperImpl implements GeneralMapper<RegisteredPlayerDTO, RegisterResponse> {

    @Override
    public RegisterResponse to(RegisteredPlayerDTO registeredPlayerDTO) {
        return new RegisterResponse(registeredPlayerDTO.getId(), registeredPlayerDTO.getName(), registeredPlayerDTO.getCreatedAt());
    }
}
