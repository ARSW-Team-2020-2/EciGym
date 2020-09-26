package edu.eci.arsw.saleit.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    public static long ID;

    @Id
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "numerodecuenta")
    private long numeroDeCuenta;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "documento")
    private String documento;

    @Column(name = "tipodedocumento")
    @Enumerated(EnumType.STRING)
    private TipoDeDocumento tipoDeDocumento;

    @Column(name = "telefono")
    private String telefono;



    @OneToMany
    @JoinColumn(name = "usuario")
    private List<Puja> listaDePujas;

    @OneToMany
    @JoinColumn(name = "emailusuario")
    private List<Favoritos> articulosFavoritos;

    @OneToMany
    @JoinColumn(name = "vendedor")
    private List<Subasta> subastasCreadas;

    @OneToMany
    @JoinColumn(name = "emailusuario")
    private List<Participaciones> participaciones;


    public Usuario(String email, String password, String nombre, String documento, TipoDeDocumento tipoDeDocumento, String telefono) {
        ID++;
        this.numeroDeCuenta = 8787;
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.documento = documento;
        this.tipoDeDocumento = tipoDeDocumento;
        this.telefono = telefono;
        this.listaDePujas = new ArrayList<>();
        this.articulosFavoritos = new ArrayList<>();
        this.subastasCreadas = new ArrayList<>();
        this.participaciones = new ArrayList<>();
    }

    public Usuario() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(long numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public TipoDeDocumento getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(TipoDeDocumento tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Puja> getListaDePujas() {
        return listaDePujas;
    }

    public void setListaDePujas(List<Puja> listaDePujas) {
        this.listaDePujas = listaDePujas;
    }

    public List<Favoritos> getArticulosFavoritos() {
        return articulosFavoritos;
    }

    public void setArticulosFavoritos(List<Favoritos> articulosFavoritos) {
        this.articulosFavoritos = articulosFavoritos;
    }

    public List<Subasta> getSubastasCreadas() {
        return subastasCreadas;
    }

    public void setSubastasCreadas(List<Subasta> subastasCreadas) {
        this.subastasCreadas = subastasCreadas;
    }

    public List<Participaciones> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(List<Participaciones> participaciones) {
        this.participaciones = participaciones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return numeroDeCuenta == usuario.numeroDeCuenta &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(password, usuario.password) &&
                Objects.equals(nombre, usuario.nombre) &&
                Objects.equals(documento, usuario.documento) &&
                tipoDeDocumento == usuario.tipoDeDocumento &&
                Objects.equals(telefono, usuario.telefono) &&
                Objects.equals(listaDePujas, usuario.listaDePujas) &&
                Objects.equals(articulosFavoritos, usuario.articulosFavoritos) &&
                Objects.equals(subastasCreadas, usuario.subastasCreadas) &&
                Objects.equals(participaciones, usuario.participaciones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password, numeroDeCuenta, nombre, documento, tipoDeDocumento, telefono, listaDePujas, articulosFavoritos, subastasCreadas, participaciones);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", numeroDeCuenta=" + numeroDeCuenta +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", tipoDeDocumento=" + tipoDeDocumento +
                ", telefono='" + telefono + '\'' +
                ", listaDePujas=" + listaDePujas +
                ", articulosFavoritos=" + articulosFavoritos +
                ", subastasCreadas=" + subastasCreadas +
                ", participaciones=" + participaciones +
                '}';
    }



}
