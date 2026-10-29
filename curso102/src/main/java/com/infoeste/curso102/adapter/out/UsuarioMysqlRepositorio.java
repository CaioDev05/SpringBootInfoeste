package com.infoeste.curso102.adapter.out;

import com.infoeste.curso102.adapter.out.mapper.UsuarioOutMapper;
import com.infoeste.curso102.domain.Usuario;
import com.infoeste.curso102.port.out.UsuarioRepositorio;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor

public class UsuarioMysqlRepositorio implements UsuarioRepositorio {

    private final UsuarioJpaRepositorio repositorio;
    private final UsuarioOutMapper mapper;

    @Override
    public Usuario save(Usuario toSave) {
        var entity = mapper.toEntity(toSave);

        UsuarioEntity entidadeSalva = repositorio.save(entity);

        return mapper.toUsuario(entidadeSalva);
    }

    public Optional<Usuario> findByEmail(String email)  {
         return repositorio.findByEmail(email)
                 .map(mapper::toUsuario);
    }

    @Override
    public Optional<Usuario> findById(UUID id) {
        return repositorio.findById(id)
                .map(mapper::toUsuario);
    }

}
