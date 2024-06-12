package com.lucasDev.imagin_banco.security;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name="rol")
public class Rol {

    @Id
    @Column(name = "rol_id")
    private int idRol;

    private String nombre;

    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<RolesUsuarios> rolesUsuarios = new HashSet<>();

}
