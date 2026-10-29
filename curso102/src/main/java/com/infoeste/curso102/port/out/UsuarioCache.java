package com.infoeste.curso102.port.out;

import com.infoeste.curso102.domain.Usuario;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioCache {

    Usuario save(Usuario toSave);
    Optional<Usuario> findById(UUID id);
    void deleteById(UUID id);

}
