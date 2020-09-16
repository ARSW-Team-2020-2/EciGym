package edu.eci.arsw.saleit.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="puja")
public class Bid {

    @Id
    private long id;
    @OneToOne
    private User usuario;
    private long amount;
    private Date fecha;

    public Bid(long id, User usuario, long amount, Date fecha) {
        this.id = id;
        this.usuario = usuario;
        this.amount = amount;
        this.fecha = fecha;
    }

    public Bid() {}

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return usuario;
    }

    public void setUser(User usuario) {
        this.usuario = usuario;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return fecha;
    }

    public void setDate(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "id=" + id + 
                ", user=" + usuario +
                ", amount=" + amount + 
                ", date=" + fecha + '}';
    }  
            
}
