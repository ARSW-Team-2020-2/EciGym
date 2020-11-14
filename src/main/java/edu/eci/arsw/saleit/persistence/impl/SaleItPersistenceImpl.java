package edu.eci.arsw.saleit.persistence.impl;

import edu.eci.arsw.saleit.model.*;
import edu.eci.arsw.saleit.persistence.SaleItPersistence;
import edu.eci.arsw.saleit.persistence.SaleItPersistenceException;
import edu.eci.arsw.saleit.persistence.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleItPersistenceImpl implements SaleItPersistence {

    @PersistenceContext
    EntityManager entityManager;

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
    private PujaRepo pujaRepo;

    @Override
    public void addUser(Usuario user) throws SaleItPersistenceException {
        if (user == null) {
            throw new SaleItPersistenceException("El usuario no puede ser nulo.");
        }
        List<Usuario> usuarios = userRepo.findAll();
        if (usuarios.contains(user)) {
            throw new SaleItPersistenceException("Ese usuario ya existe.");
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
    public void addAuction(Subasta auction, int id) throws SaleItPersistenceException {
        if (auction == null) {
            throw new SaleItPersistenceException("La subasta no puede ser nula");
        }
        if (auction.getArticulo() == null) {
            throw new SaleItPersistenceException("El artículo de la subasta no puede ser nulo");
        }
        Usuario usuario = getUserById(id);
        if (auction.getFechaInicio().after(auction.getFechaFin())) {
            throw new SaleItPersistenceException("Una subasta no puede iniciar después de su fecha de finalización");
        }
        usuario.getSubastasCreadas().add(auction);
        auction.setVendedor(usuario.getId());
        articleRepo.save(auction.getArticulo());
        userRepo.save(usuario);
        auctionRepo.save(auction);
    }

    @Override
    public List<Subasta> getAllAuctions() throws SaleItPersistenceException {
        if (auctionRepo.count() == 0) {
            throw new SaleItPersistenceException("No existen subastas.");
        }
        return auctionRepo.findAll();
    }

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
    public Articulo getArticleById(int id) throws SaleItPersistenceException {
        Articulo articulo = null;
        if (articleRepo.existsById(id)) {
            articulo = articleRepo.findById(id).get();
        }
        if (articulo == null) {
            throw new SaleItPersistenceException("El articulo con ese ID no existe");
        }
        return articulo;
    }

    @Transactional
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
    public Categoria getCategoryById(int id) throws SaleItPersistenceException {
        Categoria categoria = null;
        if (categoryRepo.existsById(id)) {
            categoria = categoryRepo.findById(id).get();
        }
        if (categoria == null) {
            throw new SaleItPersistenceException("La categoría con ese ID no existe");
        }
        return categoria;
    }

    @Override
    public List<Subasta> getOwnAuctionsOfAnUser(int id) throws SaleItPersistenceException {
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

    @Override
    public Subasta getAuctionById(int id) throws SaleItPersistenceException {
        Subasta subasta = null;
        if (auctionRepo.existsById(id)) {
            subasta = auctionRepo.findById(id).get();
        }
        if (subasta == null) {
            throw new SaleItPersistenceException("La subasta con ese ID no existe");
        }
        return subasta;
    }

    @Override
    public void makeABid(Puja puja, int usuario, int subasta) throws SaleItPersistenceException {
        Usuario user = getUserById(usuario);
        Subasta subasta1 = getAuctionById(subasta);
        if (puja == null) {
            throw new SaleItPersistenceException("Debe ingresar un monto");
        }
        double montoMinimo = subasta1.getArticulo().getPrecioMinimo();
        if (puja.getMonto() < montoMinimo) {
            throw new SaleItPersistenceException("El monto mínimo a ofertar es de " + montoMinimo);
        }
        puja.setFecha();
        puja.setSubasta(subasta1.getId());
        user.getListaDePujas().add(puja);
        subasta1.getPujas().add(puja);
        pujaRepo.save(puja);
        userRepo.save(user);
        auctionRepo.save(subasta1);
    }

    @Override
    public List<Puja> getBidsByAuction(int subasta) throws SaleItPersistenceException {
        Subasta subasta1 = getAuctionById(subasta);
        List<Puja> pujas = subasta1.getPujas();
        if (pujas.isEmpty()) {
            throw new SaleItPersistenceException("No hay pujas para esta subasta");
        }
        return pujas;
    }

    @Override
    public List<Subasta> getAuctionsOfAnUser(int usuario) throws SaleItPersistenceException {
        Usuario user = getUserById(usuario);
        List<Puja> listaDePujas = pujaRepo.getBidsOfAnAuction(user.getId());
        if (listaDePujas.isEmpty()) {
            throw new SaleItPersistenceException("Este usuario no ha participado en ninguna subasta");
        }
        List<Subasta> listaDeSubastas = new ArrayList<>();
        for (Puja puja : listaDePujas) {
            Subasta subasta = getAuctionById(puja.getSubasta());
            if (!listaDeSubastas.contains(subasta)) {
                listaDeSubastas.add(subasta);
            }
        }
        return listaDeSubastas;
    }

    @Override
    public List<Puja> getBidsOfAnUser(int user) throws SaleItPersistenceException {
        Usuario usuario = getUserById(user);
        List<Puja> pujas = usuario.getListaDePujas();
        if (pujas.isEmpty()) {
            throw new SaleItPersistenceException("Este usuario no hay realizado ninguna puja");
        }
        return pujas;
    }

    @Override
    public Articulo getArticleOfAnAuction(int auction) throws SaleItPersistenceException {
        Articulo articulo;
        Subasta subasta = getAuctionById(auction);
        articulo = subasta.getArticulo();
        return articulo;
    }

    @Override
    public List<Articulo> getArticlesByCategory(int category) throws SaleItPersistenceException {
        List<Articulo> articulos;
        Categoria categoria = getCategoryById(category);
        articulos = categoria.getArticulos();
        return articulos;
    }

    @Override
    public void modifyAuction(Subasta auction, int id) throws SaleItPersistenceException {
        if (auction == null) {
            throw new SaleItPersistenceException("La subasta no puede ser nula");
        }
        Articulo articulo = auction.getArticulo();
        if (articulo == null) {
            throw new SaleItPersistenceException("El artículo de la subasta no puede ser nulo");
        }
        getUserById(id);
        Subasta subasta = getAuctionById(auction.getId());
        if (id != subasta.getVendedor()) {
            throw new SaleItPersistenceException("Solo el vendedor de la subasta puede modificarla");
        }

        getCategoryById(articulo.getCategoria());
        if (!subasta.getFechaInicio().equals(auction.getFechaInicio())) {
            throw new SaleItPersistenceException("La fecha de inicio no se puede modificar! Solamente se puede cambiar la fecha de finalización");
        }
        try {
            subasta.updateArticle(articulo);

        } catch (SaleItException e) {
            throw new SaleItPersistenceException(e.getMessage(), e);
        }
        subasta.setFechaFin(auction.getFechaFin());
        articleRepo.save(subasta.getArticulo());
        auctionRepo.save(subasta);
    }

    @Override
    public void deleteAuction(int auction, int id) throws SaleItPersistenceException {
        Subasta subasta = getAuctionById(auction);
        Usuario usuario = getUserById(id);
        Articulo articulo = getArticleOfAnAuction(auction);
        if (subasta.getVendedor() != usuario.getId()) {
            throw new SaleItPersistenceException("Solo el vendedor de la subasta puede eliminarla");
        }
        auctionRepo.delete(subasta);
        articleRepo.delete(articulo);
    }

    @Override
    public Usuario getUserByEmail(String email) throws SaleItPersistenceException {
        Query query = entityManager.createNativeQuery("select * from usuario where email=?", Usuario.class);
        query.setParameter(1, email);
        if (query.getResultList().size() == 0) {
            throw new SaleItPersistenceException("El usuario con ese email no existe");
        }
        return (Usuario) query.getSingleResult();
    }

    @Override
    public Subasta getAuctionByArticleId(int articleId) throws SaleItPersistenceException {
        List<Subasta> auctions = auctionRepo.findAll();
        Subasta sub = null;
        for (Subasta s : auctions) {
            if ((s.getArticulo()).getId() == articleId) {
                sub = s;
            }
        }
        if (sub == null) {
            throw new SaleItPersistenceException("El articulo con ese id no existe");
        }
        return sub;
    }

    @Override
    public void modifyUser(Usuario user, int id) throws SaleItPersistenceException {
        if (user == null) {
            throw new SaleItPersistenceException("El usuario no puede ser nulo");
        }
        if ((user.getNombre()).equals("")) {
            throw new SaleItPersistenceException("El nombre del usuario no puede estar vacío");
        }
        if ((user.getEmail()).equals("")) {
            throw new SaleItPersistenceException("El correo del usuario no puede estar vacío");
        }
        if ((user.getDocumento()).equals("")) {
            throw new SaleItPersistenceException("El documento del usuario no puede estar vacío");
        }
        if ((user.getTelefono()).equals("")) {
            throw new SaleItPersistenceException("El teléfono del usuario no puede estar vacío");
        }
        Usuario usuario = getUserById(id);        
        usuario.setNombre(user.getNombre());
        usuario.setEmail(user.getEmail());
        usuario.setDocumento(user.getDocumento());
        usuario.setTelefono(user.getTelefono());
        usuario.setTipoDeDocumento(user.getTipoDeDocumento());
        userRepo.save(usuario);
    }
    
    @Override
    public void modifyUserPassword(Usuario user, int id) throws SaleItPersistenceException {
        if (user == null) {
            throw new SaleItPersistenceException("El usuario no puede ser nulo");
        }
        Usuario usuario = getUserById(id);      
        usuario.setPassword(user.getPassword());
        userRepo.save(usuario);
        
    }
}
