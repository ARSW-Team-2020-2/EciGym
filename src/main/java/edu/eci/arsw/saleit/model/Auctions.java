package edu.eci.arsw.saleit.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="subastas")
public class Auctions {

    @Id
    private String usuarioid;
    @Id
    private long subastaid;

    public Auctions(String usuarioid, long subastaid) {
        this.usuarioid = usuarioid;
        this.subastaid = subastaid;
    }

    public Auctions() {}

    public String getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(String usuarioid) {
        this.usuarioid = usuarioid;
    }

    public long getSubastaid() {
        return subastaid;
    }

    public void setSubastaid(long subastaid) {
        this.subastaid = subastaid;
    }
}
