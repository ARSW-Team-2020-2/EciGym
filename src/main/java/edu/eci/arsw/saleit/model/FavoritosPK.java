package edu.eci.arsw.saleit.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavoritosPK implements Serializable {

    @Column(name ="emailusuario")
    private String emailUsuario;

    @Column(name ="idarticulo")
    private long articuloID;


    public FavoritosPK() {
    }

    public FavoritosPK(String emailUsuario, long articuloID) {
        this.emailUsuario = emailUsuario;
        this.articuloID = articuloID;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public long getArticuloID() {
        return articuloID;
    }

    public void setArticuloID(long articuloID) {
        this.articuloID = articuloID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoritosPK that = (FavoritosPK) o;
        return articuloID == that.articuloID &&
                Objects.equals(emailUsuario, that.emailUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailUsuario, articuloID);
    }

    @Override
    public String toString() {
        return "FavoritosPK{" +
                "emailUsuario='" + emailUsuario + '\'' +
                ", articuloID=" + articuloID +
                '}';
    }
}
