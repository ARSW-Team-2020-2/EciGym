package edu.eci.arsw.saleit.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ParticipacionesPK implements Serializable {

    @Column(name ="emailusuario")
    private String emailUsuario;

    @Column(name ="idsubasta")
    private long subastaID;


    public ParticipacionesPK() {
    }

    public ParticipacionesPK(String emailUsuario, long subastaID) {
        this.emailUsuario = emailUsuario;
        this.subastaID = subastaID;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public long getSubastaID() {
        return subastaID;
    }

    public void setSubastaID(long subastaID) {
        this.subastaID = subastaID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipacionesPK that = (ParticipacionesPK) o;
        return subastaID == that.subastaID &&
                Objects.equals(emailUsuario, that.emailUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailUsuario, subastaID);
    }

    @Override
    public String toString() {
        return "ParticipacionesPK{" +
                "emailUsuario='" + emailUsuario + '\'' +
                ", subastaID=" + subastaID +
                '}';
    }
}
