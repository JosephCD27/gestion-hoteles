package com.ps.Gestion_hoteles.controller;

import com.ps.Gestion_hoteles.model.Rol;
import com.ps.Gestion_hoteles.model.Usuario;
import com.ps.Gestion_hoteles.security.payload.AutenticationLogin;
import com.ps.Gestion_hoteles.security.payload.AutenticationResponse;
import com.ps.Gestion_hoteles.security.service.MiUserDetailsService;
import com.ps.Gestion_hoteles.security.utils.JwtUtil;
import com.ps.Gestion_hoteles.service.RolService;
import com.ps.Gestion_hoteles.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class HomeController {
    private final RolService rolService;
    private final UsuarioService usuarioService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;
    private final MiUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @GetMapping("/public")
    public String publicPage() {
        return "Página pública accesible sin autenticación.";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody AutenticationLogin nuevoUsuario) {
        if (nuevoUsuario.getUsername() == null || nuevoUsuario.getUsername().isBlank()) {
            return ResponseEntity.badRequest().body("El nombre de usuario es obligatorio.");
        }

        if (nuevoUsuario.getPassword() == null || nuevoUsuario.getPassword().isBlank()) {
            return ResponseEntity.badRequest().body("La contraseña es obligatoria.");
        }

        if (usuarioService.buscarPorUsername(nuevoUsuario.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("El nombre de usuario ya existe.");
        }

        Usuario usuario = new Usuario();
        usuario.setUsuario_username(nuevoUsuario.getUsername());
        usuario.setUsuario_password(passwordEncoder.encode(nuevoUsuario.getPassword()));
        usuario.setUsuario_estado(true);

        Rol rol = rolService.findById(1)
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        usuario.setRoles(Collections.singletonList(rol));

        usuarioService.save(usuario);

        return ResponseEntity.ok("Usuario registrado correctamente.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AutenticationLogin loginRequest) throws Exception {
        try {
            authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException ex) {
            throw new Exception("Credenciales inválidas: " + ex.getMessage());
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
        final String token = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AutenticationResponse(token));
    }

    @GetMapping("/home")
    public String privatePage() {
        return "Bienvenido al área privada. Acceso autorizado por JWT.";
    }
}
