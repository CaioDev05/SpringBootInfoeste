package com.infoeste.curso102.application.usecase;

import com.infoeste.curso102.application.service.UsuarioLookup;
import com.infoeste.curso102.domain.Usuario;
import com.infoeste.curso102.port.in.CadastraUsuarioUseCase;
import com.infoeste.curso102.port.out.UsuarioCache;
import com.infoeste.curso102.port.out.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CadastraUsuarioService implements CadastraUsuarioUseCase {

    private final UsuarioRepositorio repositorio;
    private final UsuarioLookup lookup;

    @Override
    public Usuario executa(Usuario usuario) {

        var encontrado = repositorio
                .findByEmail(usuario.getEmail());

        if (encontrado.isPresent()) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Email já cadastrado."
            );
        }

        Usuario novo = new Usuario();

        novo.setNome(usuario.getNome());
        novo.setEmail(usuario.getEmail());
        novo.setId(UUID.randomUUID());
        novo.setAtivo(true);

        Usuario usuarioSalvo = lookup.save(novo);

        return usuarioSalvo;
    }

}
