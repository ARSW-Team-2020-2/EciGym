package edu.eci.arsw.saleit.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FavoritosPK implements Serializable {

    @Column(name ="idusuario")
    private int usuarioID;

    @Column(name ="idarticulo")
    private int articuloID;


    public FavoritosPK() {
    }

    public FavoritosPK(int usuarioID, int articuloID) {
        this.usuarioID = usuarioID;
        this.articuloID = articuloID;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int emailUsuario) {
        this.usuarioID = emailUsuario;
    }

    public int getArticuloID() {
        return articuloID;
    }

    public void setArticuloID(int articuloID) {
        this.articuloID = articuloID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FavoritosPK that = (FavoritosPK) o;
        return articuloID == that.articuloID &&
                Objects.equals(usuarioID, that.usuarioID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuarioID, articuloID);
    }

    @Override
    public String toString() {
        return "FavoritosPK{" +
                "emailUsuario='" + usuarioID + '\'' +
                ", articuloID=" + articuloID +
                '}';
    }
}
