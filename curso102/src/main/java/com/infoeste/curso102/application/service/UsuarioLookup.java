package com.infoeste.curso102.application.service;

import com.infoeste.curso102.domain.Usuario;
import com.infoeste.curso102.port.out.UsuarioCache;
import com.infoeste.curso102.port.out.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioLookup {

    private final UsuarioCache cache;
    private final UsuarioRepositorio repositorio;

    public Usuario save(Usuario toSave) {
        Usuario usuarioSalvo = repositorio.save(toSave);
        cache.deleteById(usuarioSalvo.getId());

        return usuarioSalvo;
    }

    public Optional<Usuario> findById(UUID id) {
        Optional<Usuario> usuarioCache = cache.findById(id);

        if (usuarioCache.isPresent())
            return usuarioCache;

        Optional<Usuario> usuarioBanco = repositorio.findById(id);

        if (usuarioBanco.isEmpty())
            return Optional.empty();

        cache.save(usuarioBanco.get());

        return usuarioBanco;
    }

}
