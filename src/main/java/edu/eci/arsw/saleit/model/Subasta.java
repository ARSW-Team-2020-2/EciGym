package edu.eci.arsw.saleit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "subasta")
public class Subasta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "fechainicio")
    private Timestamp fechaInicio;

    @Column(name = "fechafin")
    private Timestamp fechaFin;


    @Column(name = "vendedor")
    @JsonBackReference
    private int vendedor;

    @OneToMany
    @JoinColumn(name = "subasta")
    private List<Puja> pujas;

    @OneToOne
    @JoinColumn(name = "articulo")
    private Articulo articulo;

    public Subasta(Timestamp fechaInicio, Timestamp fechaFin, int vendedor, Articulo articulo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.articulo = articulo;
        this.vendedor = vendedor;
        this.pujas = new ArrayList<>();
    }

    public Subasta() {
    }


    public void updateArticle(Articulo art) throws SaleItException {
        if ((articulo.getId() != art.getId()) || (articulo.getArticulosFavoritos() != art.getArticulosFavoritos() && art.getArticulosFavoritos() != null)) {
            throw new SaleItException("No se puede modificar el ID ni la lista de favoritos");

        }
        articulo.setNombre(art.getNombre());
        articulo.setEstadoDeUso(art.getEstadoDeUso());
        articulo.setPrecioMinimo(art.getPrecioMinimo());
        articulo.setDimensiones(art.getDimensiones());
        articulo.setUbicacion(art.getUbicacion());
        articulo.setDescripcion(art.getDescripcion());
        articulo.setImagen(art.getImagen());
        articulo.setCategoria(art.getCategoria());
    }

    public int getVendedor() {
        return vendedor;
    }

    public void setVendedor(int vendedor) {
        this.vendedor = vendedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Timestamp fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<Puja> getPujas() {
        return pujas;
    }

    public void setPujas(List<Puja> pujas) {
        this.pujas = pujas;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subasta subasta = (Subasta) o;
        return id == subasta.id &&
                Objects.equals(fechaInicio, subasta.fechaInicio) &&
                Objects.equals(fechaFin, subasta.fechaFin) &&
                Objects.equals(vendedor, subasta.vendedor) &&
                Objects.equals(pujas, subasta.pujas) &&
                Objects.equals(articulo, subasta.articulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaInicio, fechaFin, vendedor, pujas, articulo);
    }

    @Override
    public String toString() {
        return "Subasta{" +
                "id=" + id +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", fechaFin=" + vendedor +
                ", pujas=" + pujas +
                ", articulo=" + articulo +
                '}';
    }


}
