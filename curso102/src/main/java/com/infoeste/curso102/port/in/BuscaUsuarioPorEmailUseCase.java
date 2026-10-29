package com.infoeste.curso102.port.in;

import com.infoeste.curso102.domain.Usuario;

public interface BuscaUsuarioPorEmailUseCase {
    Usuario executa(String email);
}
