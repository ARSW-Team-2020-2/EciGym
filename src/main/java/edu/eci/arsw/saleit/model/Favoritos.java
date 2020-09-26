package edu.eci.arsw.saleit.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "favoritos")
public class Favoritos {

    @EmbeddedId
    private FavoritosPK favoritosPK;

    public Favoritos() {
    }


    public Favoritos(FavoritosPK favoritosPK) {
        this.favoritosPK = favoritosPK;
    }

    public FavoritosPK getFavoritosPK() {
        return favoritosPK;
    }

    public void setFavoritosPK(FavoritosPK favoritosPK) {
        this.favoritosPK = favoritosPK;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Favoritos favoritos = (Favoritos) o;
        return Objects.equals(favoritosPK, favoritos.favoritosPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(favoritosPK);
    }

    @Override
    public String toString() {
        return "Favoritos{" +
                "favoritosPK=" + favoritosPK +
                '}';
    }
}
