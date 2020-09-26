package edu.eci.arsw.saleit.model;

import javax.persistence.*;

@Entity
@Table(name="articulo")
public class Article {

    @Id    
    private long id;

    @Column(name="idauction")
    private long idAuction;

    @Column(name="name")
    private String name;

    @Column(name="uso")
    private String uso;

    @Column(name="description")
    private String description;

    @Column(name="minprice")
    private long minPrice;

    @Column(name="dimensions")
    private String dimensions;

    @Column(name="location")
    private String location;

    @Column(name="imagen")
    private String imagen;

    @Column(name="idcategory")
    private long idCategory;

    private boolean isActive;

    public Article(long id, long idAuction, String name, String uso, String description, long minPrice, String dimensions, String location, String image, long idCategory) {
        this.id = id;
        this.idAuction = idAuction;
        this.name = name;
        this.uso = uso;
        this.description = description;
        this.minPrice = minPrice;
        this.dimensions = dimensions;
        this.location = location;
        this.imagen = image;
        this.idCategory = idCategory;
        this.isActive = false;
    }

    public Article() {}

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getIdAuction() {
        return idAuction;
    }

    public void setIdAuction(int idAuction) {
        this.idAuction = idAuction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUse() {
        return uso;
    }

    public void setUse(String uso) {
        this.uso = uso;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String image) {
        this.imagen = image;
    }

    public long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }
    
    

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id + 
                ", idAuction=" + idAuction + 
                ", name=" + name + 
                ", use=" + uso +
                ", description=" + description + 
                ", minPrice=" + minPrice + 
                ", dimensions=" + dimensions + 
                ", location=" + location + 
                ", image=" + imagen +
                ", idCategory=" + idCategory + '}';
    }  
}
