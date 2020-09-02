package edu.eci.arsw.saleit.model;

import java.util.Date;

public class Puja {
    
    private int id;
    private Usuario user;
    private int amount;
    private Date date;

    public Puja(int id, Usuario user, int amount, Date date) {
        this.id = id;
        this.user = user;
        this.amount = amount;
        this.date = date;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Puja{" + 
                "id=" + id + 
                ", user=" + user + 
                ", amount=" + amount + 
                ", date=" + date + '}';
    }  
            
}
