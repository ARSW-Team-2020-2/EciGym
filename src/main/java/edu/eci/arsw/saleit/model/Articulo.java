package edu.eci.arsw.saleit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "articulo")
public class Articulo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "estadodeuso")
    private String estadoDeUso;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "preciominimo")
    private double precioMinimo;

    @Column(name = "dimensiones")
    private String dimensiones;

    @Column(name = "ubicacion")
    private String ubicacion;


    @Column(name = "categoria")
    private int categoria;

    @OneToMany
    @JoinColumn(name = "idarticulo")
    @JsonIgnore
    private List<Favoritos> articulosFavoritos;


    public Articulo(String nombre, String estadoDeUso, String descripcion, double precioMinimo, String dimensiones, String ubicacion, int categoria) {
        this.nombre = nombre;
        this.estadoDeUso = estadoDeUso;
        this.descripcion = descripcion;
        this.precioMinimo = precioMinimo;
        this.dimensiones = dimensiones;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
        this.articulosFavoritos = new ArrayList<>();
    }

    public Articulo(int id) {
        this.id = id;
    }

    public Articulo() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadoDeUso() {
        return estadoDeUso;
    }

    public void setEstadoDeUso(String estadoDeUso) {
        this.estadoDeUso = estadoDeUso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioMinimo() {
        return precioMinimo;
    }

    public void setPrecioMinimo(double precioMinimo) {
        this.precioMinimo = precioMinimo;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public List<Favoritos> getArticulosFavoritos() {
        return articulosFavoritos;
    }

    public void setArticulosFavoritos(List<Favoritos> articulosFavoritos) {
        this.articulosFavoritos = articulosFavoritos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Articulo articulo = (Articulo) o;
        return id == articulo.id &&
                precioMinimo == articulo.precioMinimo &&
                categoria == articulo.categoria &&
                Objects.equals(nombre, articulo.nombre) &&
                Objects.equals(estadoDeUso, articulo.estadoDeUso) &&
                Objects.equals(descripcion, articulo.descripcion) &&
                Objects.equals(dimensiones, articulo.dimensiones) &&
                Objects.equals(ubicacion, articulo.ubicacion) &&
                Objects.equals(articulosFavoritos, articulo.articulosFavoritos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, estadoDeUso, descripcion, precioMinimo, dimensiones, ubicacion, categoria, articulosFavoritos);
    }


    @Override
    public String toString() {
        return "Articulo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estadoDeUso='" + estadoDeUso + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precioMinimo=" + precioMinimo +
                ", dimensiones='" + dimensiones + '\'' +
                ", ubicacion='" + ubicacion + '\'' +
                ", categoria=" + categoria +
                ", articulosFavoritos=" + articulosFavoritos +
                '}';
    }
}
