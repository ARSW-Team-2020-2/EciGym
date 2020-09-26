package edu.eci.arsw.saleit.model;

import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;

@Entity
@Table(name="puja")
public class Bid {

    @Id    
    private long id;

    @OneToOne
    //@Column(name="usuario")
    private User usuario;

    @Column(name="fecha")
    private Timestamp fecha;

    @Column(name="amount")
    private long amount;

    public Bid(long id, User usuario, long amount, Timestamp fecha) {
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

    public Timestamp getDate() {
        return fecha;
    }

    public void setDate(Timestamp fecha) {
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
