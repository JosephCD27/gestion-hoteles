package com.ps.Gestion_hoteles.security.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutenticationRegistro implements Serializable {
    private static final long serialVersionUID = 1L;

    private String usuario_username;
    private String usuario_password;
}
