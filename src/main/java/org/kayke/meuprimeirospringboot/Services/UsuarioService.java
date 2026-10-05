package org.kayke.meuprimeirospringboot.Services;

import org.kayke.meuprimeirospringboot.Model.Usuario;
import org.kayke.meuprimeirospringboot.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registerUsuario(String username, String password) {

        Usuario usuario = new Usuario(username, password);

        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorNome(String username) {

        return usuarioRepository.findByUsername(username);
    }
}