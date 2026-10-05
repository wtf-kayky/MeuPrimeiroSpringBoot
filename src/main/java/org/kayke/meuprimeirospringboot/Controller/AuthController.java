package org.kayke.meuprimeirospringboot.Controller;
import io.jsonwebtoken.Jwts;
import org.kayke.meuprimeirospringboot.Model.Usuario;
import org.kayke.meuprimeirospringboot.Security.jwt.JwtUtil;
import org.kayke.meuprimeirospringboot.Services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UsuarioService usuarioService;

    public AuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Map<String, String> request) {
        Usuario usuario = usuarioService.registerUsuario(request.get("username"), request.get("password"));
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        Optional<Usuario> usuario = usuarioService.buscarPorNome(request.get("username"));
        if (usuario.isPresent() && usuario.get().getPassword().equals(request.get("password"))) {
            String token = JwtUtil.generanteToken(usuario.get().getUsername());
            return ResponseEntity.ok("Login realizado com sucesso");
        }
        return ResponseEntity
                .status(401)
                .body("Credenciais inválidas");
    }
}

