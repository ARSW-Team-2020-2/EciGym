package edu.eci.arsw.saleit.model;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="usuario")
public class User {

    @Column(name="id")
    private long numeroDeCuenta;

    @Column(name="name")
    private String name;

    @Column(name="document")
    private String document;

    @Column(name="documenttype")
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column(name="phone")
    private String phone;

    @Id
    private String email;

    @Column(name="password")
    private String password;

    @OneToMany
    private List<Article> favorites;

    @OneToMany
    private List<Auction> auctions;

    public User(long numeroDeCuenta, String document, DocumentType documenttype, String name, String phone, String email, String password, List<Article> favorites, List<Auction> auctions) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.document = document;
        this.documentType = documenttype;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
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

    public long getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(int numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
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

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documenttype) {
        this.documentType = documenttype;
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
        return numeroDeCuenta == user.numeroDeCuenta &&
                Objects.equals(name, user.name) &&
                Objects.equals(document, user.document) &&
                Objects.equals(documentType, user.documentType) &&
                Objects.equals(password, user.password) &&
                Objects.equals(email, user.email) &&
                Objects.equals(favorites, user.favorites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroDeCuenta, name, document, documentType, password, email, favorites);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + numeroDeCuenta +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", documentType='" + documentType + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", favorites=" + favorites + '\'' +
                ", auctions=" + auctions +
                '}';
    }
}
