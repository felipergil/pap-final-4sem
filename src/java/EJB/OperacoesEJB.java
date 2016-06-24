/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Model.Pedido;
import Model.Produto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Felipe Rodrigues
 */
@Stateless
public class OperacoesEJB {
    
    @PersistenceContext(unitName = "LowPriceCellPU")
    private EntityManager em;
    
    public List<Produto> returnProdutos() {
        return em.createQuery("SELECT p from Produto p").getResultList();
        
    }
    
    public List<Pedido> returnPedidos() {
        return em.createQuery("SELECT p from Pedido p group by p.identificador order by p.datahora desc").getResultList();
    }
    
    public List<Produto> returnProdutosApple() {
        return em.createNamedQuery("Produtos.Marca").setParameter("marcaAtribuida", "Apple").getResultList();
    }
    
    public List<Produto> returnProdutosSamsung() {
        return em.createNamedQuery("Produtos.Marca").setParameter("marcaAtribuida", "Samsung").getResultList();
    }
    
    public List<Produto> returnProdutosLG() {
        return em.createNamedQuery("Produtos.Marca").setParameter("marcaAtribuida", "LG").getResultList();
    }
    
    public List<Produto> returnProdutosMotorola() {
        return em.createNamedQuery("Produtos.Marca").setParameter("marcaAtribuida", "Motorola").getResultList();
    }
    
    public List<Produto> returnProdutosMicrosoft() {
        return em.createNamedQuery("Produtos.Marca").setParameter("marcaAtribuida", "Microsoft").getResultList();
    }
    
    public List<Produto> returnProdutosIOS() {
        return em.createNamedQuery("Produtos.Sistema").setParameter("sistemaAtribuido", "IOS").getResultList();
    }
    
    public List<Produto> returnProdutosAndroid() {
        return em.createNamedQuery("Produtos.Sistema").setParameter("sistemaAtribuido", "Android").getResultList();
    }
    
    public List<Produto> returnProdutosWindows() {
        return em.createNamedQuery("Produtos.Sistema").setParameter("sistemaAtribuido", "Windows").getResultList();
    }
    
    public int checarExistenciaQuery(String query) {
        List<Produto> produtos = em.createQuery("SELECT p from Produto p where p.simbolo = :simbolo")
                .setParameter("simbolo", query).getResultList();
        return produtos.size();
    }
    
    public Produto returnProduct(String query) {
        Produto produto = (Produto) em.createQuery("SELECT p from Produto p where p.simbolo = :simbolo").setParameter
        ("simbolo", query).getSingleResult();
        return produto;
    }
    
    public List<Produto> retornaPorNome(String query) {
        List<Produto> produtos = em.createQuery("SELECT p from Produto p where p.titulo = :titulo").setParameter
        ("titulo", query).getResultList();
        return produtos;
    }
    
    public int checkIfQueryExists(String query) {
        List<Pedido> pedidos = em.createQuery("SELECT p FROM Pedido p where p.identificador = "
                + ":identificador").setParameter("identificador", query).getResultList();
        return pedidos.size();
    }
    
    public List<Pedido> returnPedido(String query) {
        List<Pedido> pedidos = (List<Pedido>) em.createQuery("SELECT p from Pedido p where p.identificador = :identificador")
                .setParameter("identificador", query).getResultList();
        return pedidos;
    }
    
    public int checarExistenciaQueryCategoria(String query) {
        List<Produto> produtos = em.createQuery("SELECT p from Produto p where p.categoria = :categoria")
                .setParameter("categoria", query).getResultList();
        return produtos.size();
    }
    
    public List<Produto> returnProdutosCategoria(String query) {
        List<Produto> produtos = (List<Produto>) em.createQuery("SELECT p from Produto P where p.categoria = :categoria")
                .setParameter("categoria", query).getResultList();
        return produtos;
    }
    
    public int checarExistenciaQueryMarca(String query) {
        List<Produto> produtos = em.createQuery("SELECT p from Produto p where p.marca = :marca")
                .setParameter("marca", query).getResultList();
        return produtos.size();
    }
    
    public List<Produto> returnProdutosMarca(String query) {
        List<Produto> produtos = (List<Produto>) em.createQuery("SELECT p from Produto p where p.marca = :marca")
                .setParameter("marca", query).getResultList();
        return produtos;
    }
    
    public int checarExistenciaQuerySistemaOperacional(String query) {
        List<Produto> produtos = em.createQuery("SELECT p from Produto p where p.sistema = :sistema")
                .setParameter("sistema", query).getResultList();
        return produtos.size();
    }
    
    public List<Produto> returnProdutosSistemaOperacional(String query) {
        List<Produto> produtos = (List<Produto>) em.createQuery("SELECT p from Produto p where p.sistema = :sistema")
                .setParameter("sistema", query).getResultList();
        return produtos;
    }
    
    
}
