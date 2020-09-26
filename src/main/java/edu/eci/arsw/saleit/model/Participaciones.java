package edu.eci.arsw.saleit.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "participaciones")
public class Participaciones {

    @EmbeddedId
    private ParticipacionesPK participacionesPK;

    public Participaciones() {
    }

    public Participaciones(ParticipacionesPK participacionesPK) {
        this.participacionesPK = participacionesPK;
    }


    public ParticipacionesPK getParticipacionesPK() {
        return participacionesPK;
    }

    public void setParticipacionesPK(ParticipacionesPK participacionesPK) {
        this.participacionesPK = participacionesPK;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participaciones that = (Participaciones) o;
        return Objects.equals(participacionesPK, that.participacionesPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(participacionesPK);
    }

    @Override
    public String toString() {
        return "Participaciones{" +
                "participacionesPK=" + participacionesPK +
                '}';
    }
}


