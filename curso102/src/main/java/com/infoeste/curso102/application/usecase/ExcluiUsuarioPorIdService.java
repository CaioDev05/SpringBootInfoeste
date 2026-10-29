package com.infoeste.curso102.application.usecase;

import com.infoeste.curso102.application.service.UsuarioLookup;
import com.infoeste.curso102.domain.Usuario;
import com.infoeste.curso102.port.in.ExcluiUsuarioPorIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExcluiUsuarioPorIdService implements ExcluiUsuarioPorIdUseCase {

    private final UsuarioLookup lookup;

    @Override
    public void executar(UUID id) {
        Optional<Usuario> encontrado = lookup.findById(id);

        if (encontrado.isEmpty())
            return;

        Usuario usuario = encontrado.get();
        usuario.setAtivo(false);
        lookup.save(usuario);
    }
}
