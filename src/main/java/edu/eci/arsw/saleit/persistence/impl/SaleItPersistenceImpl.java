package edu.eci.arsw.saleit.persistence.impl;

import edu.eci.arsw.saleit.model.CountNumberGenerate;
import edu.eci.arsw.saleit.model.Usuario;
import edu.eci.arsw.saleit.persistence.SaleItPersistence;
import edu.eci.arsw.saleit.persistence.SaleItPersistenceException;
import edu.eci.arsw.saleit.repo.UsuarioRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleItPersistenceImpl implements SaleItPersistence {

    @Autowired
    private UsuarioRepo userRepo;


    @Override
    public void addUser(Usuario user) throws SaleItPersistenceException {
        if(userRepo.existsById(user.getEmail())){
            throw new SaleItPersistenceException("Este correo ya existe. Ingrese otro");
        }
        CountNumberGenerate.increment();
        user.setNumeroDeCuenta(CountNumberGenerate.getId());
        userRepo.save(user);
    }


}
