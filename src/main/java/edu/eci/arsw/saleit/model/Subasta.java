package edu.eci.arsw.saleit.model;

import java.util.Date;
import java.util.List;

public class Subasta {
    
    private int id;
    private Usuario user;
    private Date initDate;
    private Date finDate;
    private List<Puja> bids;    

    public Subasta(int id, Usuario user, Date initDate, Date finDate, List<Puja> bids) {
        this.id = id;
        this.user = user;
        this.initDate = initDate;
        this.finDate = finDate;
        this.bids = bids;
    }
    
    public boolean isActive(Articulo article){
        return article.isActive();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Date getInitDate() {
        return initDate;
    }

    public void setInitDate(Date initDate) {
        this.initDate = initDate;
    }

    public Date getFinDate() {
        return finDate;
    }

    public void setFinDate(Date finDate) {
        this.finDate = finDate;
    }

    public List<Puja> getBids() {
        return bids;
    }

    public void setBids(List<Puja> bids) {
        this.bids = bids;
    }

    @Override
    public String toString() {
        return "Subasta{" + 
                "id=" + id + 
                ", user=" + user + 
                ", initDate=" + initDate + 
                ", finDate=" + finDate + 
                ", bids=" + bids + '}';
    }   
    
}
