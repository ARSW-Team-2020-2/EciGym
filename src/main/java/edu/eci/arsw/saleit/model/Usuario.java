package edu.eci.arsw.saleit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    //@JsonIgnore //Por seguridad no hay que mostrar la contraseña en el JSON
    private String password;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "documento")
    private String documento;

    @Column(name = "tipodedocumento")
    @Enumerated(EnumType.STRING)
    private TipoDeDocumento tipoDeDocumento;

    @Column(name = "telefono")
    private String telefono;



    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario")
    private List<Puja> listaDePujas;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "vendedor")
    @JsonManagedReference
    private List<Subasta> subastasCreadas;


    @OneToMany
    @JoinColumn(name = "idusuario")
    private List<Articulo> articulosFavoritos;




    public Usuario(String email, String password, String nombre, String documento, TipoDeDocumento tipoDeDocumento, String telefono) {
        this.email = email;
        this.password = password;
        this.nombre = nombre;
        this.documento = documento;
        this.tipoDeDocumento = tipoDeDocumento;
        this.telefono = telefono;
        this.listaDePujas = new ArrayList<>();
        this.articulosFavoritos = new ArrayList<>();
        this.subastasCreadas = new ArrayList<>();
    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<Articulo> getArticulosFavoritos() {
        return articulosFavoritos;
    }
    
    public void addArticuloFavorito(Articulo articulo){
        this.articulosFavoritos.add(articulo);
    }

    public void setArticulosFavoritos(List<Articulo> articulosFavoritos) {
        this.articulosFavoritos = articulosFavoritos;
    }

    public List<Subasta> getSubastasCreadas() {
        return subastasCreadas;
    }

    public void setSubastasCreadas(List<Subasta> subastasCreadas) {
        this.subastasCreadas = subastasCreadas;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(nombre, usuario.nombre) &&
                Objects.equals(documento, usuario.documento) &&
                tipoDeDocumento == usuario.tipoDeDocumento &&
                Objects.equals(telefono, usuario.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, nombre, documento, tipoDeDocumento, telefono, listaDePujas, articulosFavoritos, subastasCreadas);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", tipoDeDocumento=" + tipoDeDocumento +
                ", telefono='" + telefono + '\'' +
                ", listaDePujas=" + listaDePujas +
                ", articulosFavoritos=" + articulosFavoritos +
                ", subastasCreadas=" + subastasCreadas +
                '}';
    }
}
