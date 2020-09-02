package edu.eci.arsw.saleit.model;

import java.util.List;

public class Categoria {
    
    private int id;
    private String name;
    private List<Articulo> acrticles;

    public Categoria(int id, String name, List<Articulo> acrticles) {
        this.id = id;
        this.name = name;
        this.acrticles = acrticles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Articulo> getAcrticles() {
        return acrticles;
    }

    public void setAcrticles(List<Articulo> acrticles) {
        this.acrticles = acrticles;
    }

    @Override
    public String toString() {
        return "Categoria{" + 
                "id=" + id + 
                ", name=" + name + 
                ", acrticles=" + acrticles + '}';
    }  
    
}
