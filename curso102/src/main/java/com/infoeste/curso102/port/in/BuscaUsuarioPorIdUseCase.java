package com.infoeste.curso102.port.in;

import com.infoeste.curso102.domain.Usuario;

import java.util.UUID;

public interface BuscaUsuarioPorIdUseCase {
    Usuario executa(UUID id);
}
