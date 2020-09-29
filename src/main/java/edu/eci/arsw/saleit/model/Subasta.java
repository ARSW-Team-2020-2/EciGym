package edu.eci.arsw.saleit.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="subasta")
public class Subasta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="fechainicio")
    private Timestamp fechaInicio;

    @Column(name="fechafin")
    private Timestamp fechaFin;

    @Column(name="vendedor")
    private String vendedor;

    @OneToMany
    @JoinColumn(name = "subasta")
    private List<Puja> pujas;

    @OneToMany
    @JoinColumn(name = "idsubasta")
    private List<Participaciones> participaciones;

    @OneToOne
    @JoinColumn(name = "id")
    private Articulo articulo;

    public Subasta(Timestamp fechaInicio, Timestamp fechaFin, String vendedor, Articulo articulo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.articulo = articulo;
        this.vendedor = vendedor;
        this.pujas = new ArrayList<>();
        this.participaciones = new ArrayList<>();
    }

    public Subasta() {
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
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

    public List<Participaciones> getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(List<Participaciones> participaciones) {
        this.participaciones = participaciones;
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
                Objects.equals(participaciones, subasta.participaciones) &&
                Objects.equals(articulo, subasta.articulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fechaInicio, fechaFin, vendedor, pujas, participaciones, articulo);
    }

    @Override
    public String toString() {
        return "Subasta{" +
                "id=" + id +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", fechaFin=" + vendedor +
                ", pujas=" + pujas +
                ", participaciones=" + participaciones +
                ", articulo=" + articulo +
                '}';
    }
}
