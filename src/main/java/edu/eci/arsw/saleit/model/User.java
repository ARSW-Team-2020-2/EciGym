package edu.eci.arsw.saleit.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="usuario")
public class User {

    private long id;
    private String name;
    private String document;
    private String documenttype;
    private String phone;
    @Id
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role rol;
    @OneToMany
    private List<Article> favorites;
    @OneToMany
    private List<Auction> auctions;

    public User(long id, String document, String documenttype, String name, String phone, String email, String password, Role rol, List<Article> favorites, List<Auction> auctions) {
        this.id = id;
        this.document = document;
        this.documenttype = documenttype;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.rol = rol;
        this.favorites = favorites;
        this.auctions = auctions;
    }

    public User() {}

    public void bidArticle(Article articulo, long valor){

    }

    public void publishArticle(Article articulo){

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void modifyArticle(Article articulo){

    }

    public void deleteArticle(Article articulo){

    }

    public Article getArticleByName(String nombre){
        return null;
    }

    public List<Article> getAllArticles(){
        return null;
    }

    public List<Article> getArticlesByCategory(Category category){
        return null;
    }

    public List<Category> getAllCategories(){
        return null;
    }

    public List<Category> getFavoriteCategories(){
        return null;
    }

    public void addAsFavorite(Article articulo){ }

    public List<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Role getRol() {
        return rol;
    }

    public void setRol(Role rol) {
        this.rol = rol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDocumentType() {
        return documenttype;
    }

    public void setDocumentType(String documenttype) {
        this.documenttype = documenttype;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Article> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Article> favorites) {
        this.favorites = favorites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id &&
                rol == user.rol &&
                Objects.equals(name, user.name) &&
                Objects.equals(document, user.document) &&
                Objects.equals(documenttype, user.documenttype) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(favorites, user.favorites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rol, name, document, documenttype, password, email, favorites);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", rol=" + rol +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", documentType='" + documenttype + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", favorites=" + favorites + '\'' +
                ", auctions=" + auctions +
                '}';
    }
}
