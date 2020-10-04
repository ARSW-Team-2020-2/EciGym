package edu.eci.arsw.saleit.persistence.impl;

import edu.eci.arsw.saleit.model.*;
import edu.eci.arsw.saleit.persistence.SaleItPersistence;
import edu.eci.arsw.saleit.persistence.SaleItPersistenceException;
import edu.eci.arsw.saleit.persistence.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SaleItPersistenceImpl implements SaleItPersistence {

    @Autowired
    private UsuarioRepo userRepo;

    @Autowired
    private SubastaRepo auctionRepo;

    @Autowired
    private ArticuloRepo articleRepo;

    @Autowired
    private CategoriaRepo categoryRepo;

    @Autowired
    private FavoritosRepo favoritosRepo;

    @Autowired
    private ParticipacionesRepo participacionesRepo;

    @Override
    public void addUser(Usuario user) throws SaleItPersistenceException {
        if(user == null){
            throw new SaleItPersistenceException("El usuario no puede ser nulo.");
        }
        userRepo.save(user);
    }

    @Override
    public List<Usuario> getAllUsers() throws SaleItPersistenceException {
        if (userRepo.count() == 0) {
            throw new SaleItPersistenceException("No existen usuarios.");
        }
        return userRepo.findAll();
    }

    @Override
    public void addAuction(Subasta auction, Integer id) throws SaleItPersistenceException {
        if (auction == null) {
            throw new SaleItPersistenceException("La subasta no puede ser nula");
        }
        if (auction.getArticulo() == null) {
            throw new SaleItPersistenceException("El artículo de la subasta no puede ser nulo");
        }
        Usuario usuario = getUserById(id);
        if (auction.getFechaInicio().before(new Timestamp(new Date().getTime()))) {
            throw new SaleItPersistenceException("La fecha de inicio de la subasta no puede ser antes de la fecha de actual");
        }
        if (auction.getFechaInicio().after(auction.getFechaFin())) {
            throw new SaleItPersistenceException("Una subasta no puede iniciar después de su fecha de finalización");
        }
        usuario.getSubastasCreadas().add(auction);
        auction.setVendedor(usuario);
        articleRepo.save(auction.getArticulo());
        userRepo.save(usuario);
    }

    @Override
    public List<Subasta> getAllAuctions() throws SaleItPersistenceException {
        if (auctionRepo.count() == 0) {
            throw new SaleItPersistenceException("No existen subastas.");
        }
        return auctionRepo.findAll();
    }

//    public static final String VAR = "select id,nombre from articulo;";
//    @Query(value = VAR, nativeQuery = true)


    @Override
    public List<Articulo> getAllArticles() throws SaleItPersistenceException {
        if (articleRepo.count() == 0) {
            throw new SaleItPersistenceException("No existen articulos.");
        }
        return articleRepo.findAll();
    }

    @Override
    public void addArticle(Articulo article) throws SaleItPersistenceException {
        articleRepo.save(article);
    }

    @Override
    public List<Categoria> getAllCategories() throws SaleItPersistenceException {
        if (categoryRepo.count() == 0) {
            throw new SaleItPersistenceException("No existen categorias.");
        }
        return categoryRepo.findAll();
    }

    @Override
    public void addCategory(Categoria category) throws SaleItPersistenceException {
        categoryRepo.save(category);
    }

    @Override
    public Optional<Articulo> getArticleById(int id) throws SaleItPersistenceException {
        return articleRepo.findById(id);
    }

    @Override
    public Usuario getUserById(int id) throws SaleItPersistenceException {
        Usuario usuario = null;
        if (userRepo.existsById(id)) {
            usuario = userRepo.findById(id).get();
        }
        if (usuario == null) {
            throw new SaleItPersistenceException("El usuario con ese ID no existe");
        }
        return usuario;
    }

    @Override
    public Optional<Categoria> getCategoryById(int id) throws SaleItPersistenceException {
        return categoryRepo.findById(id);
    }

    @Override
    public List<Subasta> getOwnAuctionsByUser(int id) throws SaleItPersistenceException {
        Usuario user = getUserById(id);
        List<Subasta> myAuctions = user.getSubastasCreadas();
        if (myAuctions.isEmpty()) {
            throw new SaleItPersistenceException("No existen subastas creadas por este usuario.");
        }
        return myAuctions;
    }

    @Override
    public void addArticleAsFavorite(int userId, Articulo articleId) throws SaleItPersistenceException {
        Articulo articulo = null;
        if (articleRepo.existsById(articleId.getId())) {
            articulo = articleRepo.findById(articleId.getId()).get();
        }
        if (articulo == null) {
            throw new SaleItPersistenceException("El articulo con ese ID no existe");
        }
        Usuario user = getUserById(userId);
        user.addArticuloFavorito(articulo);
        Favoritos favoritos = new Favoritos(new FavoritosPK(userId, articleId.getId()));
        userRepo.save(user);
        favoritosRepo.save(favoritos);
    }

    @Override
    public List<Articulo> getFavoriteArticlesOfAnUser(int userId) throws SaleItPersistenceException {
        Usuario user = getUserById(userId);
        List<Articulo> myFavoriteArticles = user.getArticulosFavoritos();
        if (myFavoriteArticles.isEmpty()) {
            throw new SaleItPersistenceException("No hay artículos favoritos para este usuario.");
        }
        return myFavoriteArticles;
    }
}
