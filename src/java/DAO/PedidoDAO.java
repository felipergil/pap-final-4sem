/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import EJB.PedidoService;
import Model.Pedido;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe Rodrigues
 */

@Stateless
public class PedidoDAO implements PedidoService {
    
    @PersistenceContext(unitName="LowPriceCellPU")
    private EntityManager entityManager;

    @Override
    public Pedido addPedido(Pedido pedido) {
        return entityManager.merge(pedido);
    }
   
}