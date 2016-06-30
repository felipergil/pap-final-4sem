/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import EJB.ClienteService;
import Model.Cliente;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe Rodrigues
 */
@Stateless
public class ClienteDAO implements ClienteService {

    @PersistenceContext(unitName = "LowPriceCellPU")
    private EntityManager entityManager;

    @Override
    public Cliente createOrUpdate(Cliente cliente) {
        return entityManager.merge(cliente);
    }

    @Override
    public void remove(Cliente cliente) {
        entityManager.remove(entityManager.merge(cliente));
    }

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LowPriceCellPU");
        return factory.createEntityManager();
    }

    public Cliente validarLogin(String email, String senha) {
        EntityManager em = getEM();
        try {
            Cliente cliente = (Cliente) em.createQuery("SELECT c FROM Cliente c where c.email = :email "
                    + "and c.senha = :senha").setParameter("email", email)
                    .setParameter("senha", senha).getSingleResult();
            return cliente;

        } catch (NoResultException e) {
            return null;
        }
    }

}
