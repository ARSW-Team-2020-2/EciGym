package edu.eci.arsw.saleit.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name="puja")
public class Puja {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="monto")
    private int monto;

    @Column(name="fecha")
    private Timestamp fecha;

    @Column(name="subasta")
    private int subasta;

    public Puja(int monto) {
        this.monto = monto;
    }

    public Puja() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha() {
        this.fecha = new Timestamp(new Date().getTime());
    }

    public int getSubasta() {
        return subasta;
    }

    public void setSubasta(int subasta) {
        this.subasta = subasta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puja puja = (Puja) o;
        return id == puja.id &&
                monto == puja.monto &&
                subasta == puja.subasta &&
                Objects.equals(fecha, puja.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, monto, fecha, subasta);
    }

    @Override
    public String toString() {
        return "Puja{" +
                "id=" + id +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", subasta=" + subasta +
                '}';
    }
}
