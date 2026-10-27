package com.infoeste.curso102.adapter.in.htpp;

import com.infoeste.curso102.adapter.in.payload.UsuarioRequest;
import com.infoeste.curso102.adapter.in.payload.UsuarioResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @PostMapping("/v1/usuario")
    public UsuarioResponse cadastrar(@RequestBody UsuarioRequest request) {
        return new UsuarioResponse();
    }
}
