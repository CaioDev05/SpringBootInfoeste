package com.infoeste.curso102.adapter.out;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.lang.NonNull;

import java.util.UUID;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    private UUID id;

    @Column(nullable = false, length = 300)
    private String nome;

    @Column(unique = true, nullable = false, length = 300)
    private String email;

    @Column(nullable = false)
    private Boolean ativo;
}
