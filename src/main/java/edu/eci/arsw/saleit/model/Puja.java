package edu.eci.arsw.saleit.model;

import javax.persistence.*;
import java.sql.Timestamp;
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

    public Puja(int monto, Timestamp fecha) {
        this.monto = monto;
        this.fecha = fecha;
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

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Puja puja = (Puja) o;
        return id == puja.id &&
                monto == puja.monto &&
                Objects.equals(fecha, puja.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, monto, fecha);
    }

    @Override
    public String toString() {
        return "Puja{" +
                "id=" + id +
                ", monto=" + monto +
                ", fecha=" + fecha +
                '}';
    }
}
