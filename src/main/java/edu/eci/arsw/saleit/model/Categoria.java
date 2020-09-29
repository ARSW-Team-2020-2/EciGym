package edu.eci.arsw.saleit.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="nombre")
    private String nombre;


    @OneToMany
    @JoinColumn(name = "categoria")
    private List<Articulo> articulos;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.articulos = new ArrayList<>();
    }
    public Categoria() {
    }

    public long getId() {
        return id;
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

    public List<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(List<Articulo> articulos) {
        this.articulos = articulos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return id == categoria.id &&
                Objects.equals(nombre, categoria.nombre) &&
                Objects.equals(articulos, categoria.articulos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, articulos);
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", articulos=" + articulos +
                '}';
    }
}
