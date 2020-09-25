package edu.eci.arsw.saleit.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name="subasta")
public class Auction {

    @Id
    private long id;

    @OneToMany
    private List<User> usuarios;

    @Column(name="initdate")
    private Timestamp initDate;

    @Column(name="findate")
    private Timestamp finDate;

    @OneToMany
    private List<Bid> bids;

    public Auction(long id, List<User> usuarios, Timestamp initDate, Timestamp finDate, List<Bid> bids) {
        this.id = id;
        this.usuarios = usuarios;
        this.initDate = initDate;
        this.finDate = finDate;
        this.bids = bids;
    }

    public Auction() {}
    
    public boolean isActive(Article article){
        return article.isActive();
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUser() {
        return usuarios;
    }

    public void setUser(List<User> usuarios) {
        this.usuarios = usuarios;
    }

    public Timestamp getInitDate() {
        return initDate;
    }

    public void setInitDate(Timestamp initDate) {
        this.initDate = initDate;
    }

    public Timestamp getFinDate() {
        return finDate;
    }

    public void setFinDate(Timestamp finDate) {
        this.finDate = finDate;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "Auction{" +
                "id=" + id +
                ", usuario=" + usuarios +
                ", initDate=" + initDate + 
                ", finDate=" + finDate + 
                ", bids=" + bids + '}';
    }   
    
}
