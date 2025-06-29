package com.ps.Gestion_hoteles.security.service;

import com.ps.Gestion_hoteles.model.Rol;
import com.ps.Gestion_hoteles.model.Usuario;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class MiUserDetails implements UserDetails {
    private final String username;
    private final String password;
    private final boolean activo;
    private final List<SimpleGrantedAuthority> authorities;

    public MiUserDetails(Usuario usuario) {
        this.username = usuario.getUsuario_username();
        this.password = usuario.getUsuario_password();
        this.activo = usuario.isUsuario_estado();

        this.authorities = new ArrayList<>();
        for (Rol rol : usuario.getRoles()) {
            this.authorities.add(new SimpleGrantedAuthority("ROL_" + rol.getRol_nombre()));
        }
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return activo;
    }


}
