package com.infoeste.curso102.adapter.in.http;

import com.infoeste.curso102.adapter.in.payload.UsuarioRequest;
import com.infoeste.curso102.adapter.in.payload.UsuarioResponse;
import com.infoeste.curso102.domain.Usuario;
import com.infoeste.curso102.port.in.BuscaUsuarioPorEmailUseCase;
import com.infoeste.curso102.port.in.BuscaUsuarioPorIdUseCase;
import com.infoeste.curso102.port.in.CadastraUsuarioUseCase;
import com.infoeste.curso102.port.in.ExcluiUsuarioPorIdUseCase;
import com.infoeste.curso102.port.out.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

//    @Autowired
//    private CadastraUsuarioUseCase cadastraUsuario;

    private final CadastraUsuarioUseCase cadastraUsuario;
    private final BuscaUsuarioPorIdUseCase buscarUsuarioPorId;
    private final BuscaUsuarioPorEmailUseCase buscarUsuarioPorEmail;
    private final ExcluiUsuarioPorIdUseCase excluiUsuarioPorId;

//    public UsuarioController(CadastraUsuarioUseCase cadastraUsuario) {
//        this.cadastraUsuario = cadastraUsuario;
//    }

    @PostMapping("/v1/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse cadastrar(@RequestBody UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());

        Usuario resposta = cadastraUsuario.executa(usuario);

        UsuarioResponse payload = new UsuarioResponse();
        payload.setId(resposta.getId());
        payload.setNome(resposta.getNome());
        payload.setEmail(resposta.getEmail());

        return payload;
    }

    @GetMapping("v1/usuario/{id}")
    public UsuarioResponse buscarPorId(@PathVariable UUID id) {
        Usuario usuario = buscarUsuarioPorId.executa(id);

        UsuarioResponse payload = new UsuarioResponse();
        payload.setId(usuario.getId());
        payload.setNome(usuario.getNome());
        payload.setEmail(usuario.getEmail());

        return payload;
    }

    @GetMapping("v1/usuario/email/{email}")
    public UsuarioResponse buscaPorEmail(@PathVariable String email) {
        Usuario usuario = buscarUsuarioPorEmail.executa(email);

        UsuarioResponse payload = new UsuarioResponse();
        payload.setId(usuario.getId());
        payload.setNome(usuario.getNome());
        payload.setEmail(usuario.getEmail());

        return payload;
    }

    @DeleteMapping("v1/usuario/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluiPorId(@PathVariable UUID id) {
        excluiUsuarioPorId.executar(id);
    }
}
