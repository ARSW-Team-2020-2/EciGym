package edu.eci.arsw.saleit.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categoria")
public class Category {

    @Id    
    private long id;

    @Column(name="nombre")
    private String nombre;

    @OneToMany
    private List<Article> articles;

    public Category(long id, String nombre, List<Article> articles) {
        this.id = id;
        this.nombre = nombre;
        this.articles = articles;
    }

    public Category() {}

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return nombre;
    }

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id + 
                ", name=" + nombre +
                ", articles=" + articles + '}';
    }  
    
}
