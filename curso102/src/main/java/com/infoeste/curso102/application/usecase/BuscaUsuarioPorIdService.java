package com.infoeste.curso102.application.usecase;

import com.infoeste.curso102.application.service.UsuarioLookup;
import com.infoeste.curso102.domain.Usuario;
import com.infoeste.curso102.port.in.BuscaUsuarioPorIdUseCase;
import com.infoeste.curso102.port.out.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.UUID;

@Service
public class BuscaUsuarioPorIdService implements BuscaUsuarioPorIdUseCase {

    @Autowired
    private UsuarioLookup lookup;

    @Override
    public Usuario executa(UUID id) {

        Optional<Usuario> encontrado = lookup.findById(id);

        if (encontrado.isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND
            );

        if (!encontrado.get().getAtivo())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND
            );

        return encontrado.get();
    }
}
