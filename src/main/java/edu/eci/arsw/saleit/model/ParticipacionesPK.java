package edu.eci.arsw.saleit.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParticipacionesPK implements Serializable {

    @Column(name ="idusuario")
    private int usuarioID;

    @Column(name ="idsubasta")
    private int subastaID;


    public ParticipacionesPK() {
    }

    public ParticipacionesPK(int emailUsuario, int subastaID) {
        this.usuarioID = emailUsuario;
        this.subastaID = subastaID;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int emailUsuario) {
        this.usuarioID = emailUsuario;
    }

    public int getSubastaID() {
        return subastaID;
    }

    public void setSubastaID(int subastaID) {
        this.subastaID = subastaID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipacionesPK that = (ParticipacionesPK) o;
        return subastaID == that.subastaID &&
                Objects.equals(usuarioID, that.usuarioID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioID, subastaID);
    }

    @Override
    public String toString() {
        return "ParticipacionesPK{" +
                "emailUsuario='" + usuarioID + '\'' +
                ", subastaID=" + subastaID +
                '}';
    }
}
