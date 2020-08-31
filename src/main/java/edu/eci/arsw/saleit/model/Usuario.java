package edu.eci.arsw.saleit.model;

import java.util.*;


public class Usuario {

    private int id;
    private Rol rol;
    private String name;
    private String document;
    private String documentType;
    private String password;
    private String email;
    private ArrayList<Articulo> favorites;



    public Usuario(int id, Rol rol, String name, String document, String documentType, String password, String email, ArrayList<Articulo> favorites) {
        this.id = id;
        this.rol = rol;
        this.name = name;
        this.document = document;
        this.documentType = documentType;
        this.password = password;
        this.email = email;
        this.favorites = favorites;
    }

    public Usuario() {
    }

    public void bidArticle(Articulo articulo, int valor){

    }

    public void publishArticle(Articulo articulo){

    }

    public void modifyArticle(Articulo articulo){

    }

    public void deleteArticle(Articulo articulo){

    }

    public Articulo getArticleByName(String nombre){
        return null;
    }

    public List<Articulo> getAllArticles(){
        return null;
    }

    public List<Articulo> getArticlesByCategory(Categoria categoria){
        return null;
    }

    public List<Categoria> getAllCategories(){
        return null;
    }

    public List<Categoria> getFavoriteCategories(){
        return null;
    }

    public void addAsFavorite(Articulo articulo){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
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
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
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

    public ArrayList<Articulo> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<Articulo> favorites) {
        this.favorites = favorites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id &&
                rol == usuario.rol &&
                Objects.equals(name, usuario.name) &&
                Objects.equals(document, usuario.document) &&
                Objects.equals(documentType, usuario.documentType) &&
                Objects.equals(password, usuario.password) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(favorites, usuario.favorites);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rol, name, document, documentType, password, email, favorites);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", rol=" + rol +
                ", name='" + name + '\'' +
                ", document='" + document + '\'' +
                ", documentType='" + documentType + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", favorites=" + favorites +
                '}';
    }
}
