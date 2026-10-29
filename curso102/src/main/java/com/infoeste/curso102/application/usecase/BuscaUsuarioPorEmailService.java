package com.infoeste.curso102.application.usecase;

import com.infoeste.curso102.domain.Usuario;
import com.infoeste.curso102.port.in.BuscaUsuarioPorEmailUseCase;
import com.infoeste.curso102.port.out.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class BuscaUsuarioPorEmailService implements BuscaUsuarioPorEmailUseCase {

    private final UsuarioRepositorio repositorio;

    @Override
    public Usuario executa(String email) {
        Usuario encontrado = repositorio.findByEmail(email)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND
                ));

        if (!encontrado.getAtivo())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND
            );

        return encontrado;
    }
}
