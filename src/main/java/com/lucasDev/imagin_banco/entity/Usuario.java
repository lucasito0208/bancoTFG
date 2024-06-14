package com.lucasDev.imagin_banco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lucasDev.imagin_banco.security.Authority;
import com.lucasDev.imagin_banco.security.RolesUsuarios;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name="usuario")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id", nullable = false, updatable = false)
    private Long id;
    @Column(name="nombre_usuario", nullable = false, unique = true)
    private String nombreUsuario;
    @Column(name = "password", nullable = false)
    private String password;
    private String nombre;
    private String apellidos;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    private String contacto;
    private boolean disponible = true;
    @OneToOne
    private Tarjeta tarjeta;
    @OneToOne
    private Ahorros ahorros;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Cita> citas;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Destinatario> destinatarioList;
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<RolesUsuarios> rolesUsuarios = new HashSet<>();
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        rolesUsuarios.forEach(ur -> authorities.add(new Authority(ur.getRol().getNombre())));
        return authorities;
    }
    @Override
    public String getUsername() {
        return nombreUsuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        return disponible;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Ahorros getAhorros() {
        return ahorros;
    }

    public void setAhorros(Ahorros ahorros) {
        this.ahorros = ahorros;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void setCitas(List<Cita> citas) {
        this.citas = citas;
    }

    public List<Destinatario> getDestinatarioList() {
        return destinatarioList;
    }

    public void setDestinatarioList(List<Destinatario> destinatarioList) {
        this.destinatarioList = destinatarioList;
    }

    public Set<RolesUsuarios> getRolesUsuarios() {
        return rolesUsuarios;
    }

    public void setRolesUsuarios(Set<RolesUsuarios> rolesUsuarios) {
        this.rolesUsuarios = rolesUsuarios;
    }
}
