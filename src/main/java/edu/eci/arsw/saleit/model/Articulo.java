package edu.eci.arsw.saleit.model;

public class Articulo {
    
    private int id;
    private int idAuction;
    private String name;
    private String use;
    private String description;
    private int minPrice;
    private String dimensions;
    private String location;
    private String image;
    private int idCategory;
    private boolean isActive;

    public Articulo(int id, int idAuction, String name, String use, String description, int minPrice, String dimensions, String location, String image, int idCategory) {
        this.id = id;
        this.idAuction = idAuction;
        this.name = name;
        this.use = use;
        this.description = description;
        this.minPrice = minPrice;
        this.dimensions = dimensions;
        this.location = location;
        this.image = image;
        this.idCategory = idCategory;
        this.isActive = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAuction() {
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
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinPrice() {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdCategory() {
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
        return "Articulo{" + 
                "id=" + id + 
                ", idAuction=" + idAuction + 
                ", name=" + name + 
                ", use=" + use + 
                ", description=" + description + 
                ", minPrice=" + minPrice + 
                ", dimensions=" + dimensions + 
                ", location=" + location + 
                ", image=" + image + 
                ", idCategory=" + idCategory + '}';
    }  
}
