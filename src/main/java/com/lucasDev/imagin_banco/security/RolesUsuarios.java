package com.lucasDev.imagin_banco.security;

import com.lucasDev.imagin_banco.entity.Usuario;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Table(name = "rol_usuarios")
public class RolesUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="roles_id")
    private long idRolUsuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rol_id")
    private Rol rol;


    public RolesUsuarios(Usuario usuario, Rol rol) {
        this.usuario = usuario;
        this.rol = rol;
    }

    public long getIdRolUsuario() {
        return idRolUsuario;
    }

    public void setIdRolUsuario(long idRolUsuario) {
        this.idRolUsuario = idRolUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
