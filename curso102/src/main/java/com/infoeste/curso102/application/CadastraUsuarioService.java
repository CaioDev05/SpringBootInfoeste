package com.infoeste.curso102.application;

import com.infoeste.curso102.domain.Usuario;
import com.infoeste.curso102.port.in.CadastraUsuarioUseCase;
import org.springframework.stereotype.Service;

@Service
public class CadastraUsuarioService implements CadastraUsuarioUseCase {

    @Override
    public Usuario executa(Usuario usuario) {
        return null;
    }
}
