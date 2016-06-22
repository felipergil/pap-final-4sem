/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author NOTFELIPE
 */
public class ProdutoDAO {

    public EntityManager getEM() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("LowPriceCellPU");
        return factory.createEntityManager();
    }

    public List<Produto> retornaProdutos(String titulo) {
        EntityManager em = getEM();
        List<Produto> produtos;
        try {
            Query q = em.createNamedQuery("Produtos.Titulo");
            q.setParameter("tituloProduto", "%" + titulo + "%");
            produtos = q.getResultList();
        } catch (Exception e) {
            produtos = new ArrayList();
        } finally {
            em.close();
        }
        return produtos;

    }
    
    public List<Produto> retornaProdutosValor(Double valorInicial, Double valorFinal) {
        EntityManager em = getEM();
        List<Produto> produtos;
        try {
            Query q = em.createNamedQuery("Produtos.Preco");
            q.setParameter("precoInicial", valorInicial).setParameter("precoFinal", valorFinal);
            produtos = q.getResultList();
        } catch (Exception e) {
            produtos = new ArrayList();
        } finally {
            em.close();
        }
        return produtos;

    }
    
    public List<Produto> retornaProdutosCor(String cor) {
        EntityManager em = getEM();
        List<Produto> produtos;
        try {
            Query q = em.createNamedQuery("Produtos.Cor");
            q.setParameter("corProduto", cor);
            produtos = q.getResultList();
        } catch (Exception e) {
            produtos = new ArrayList();
        } finally {
            em.close();
        }
        return produtos;

    }
    
    public List<Produto> retornaProdutosMemoria(String memoria) {
        EntityManager em = getEM();
        List<Produto> produtos;
        try {
            Query q = em.createNamedQuery("Produtos.Memoria");
            q.setParameter("memoriaProduto", memoria);
            produtos = q.getResultList();
        } catch (Exception e) {
            produtos = new ArrayList();
        } finally {
            em.close();
        }
        return produtos;

    }
    
    public List<Produto> retornaProdutosDisplay(String display) {
        EntityManager em = getEM();
        List<Produto> produtos;
        try {
            Query q = em.createNamedQuery("Produtos.Display");
            q.setParameter("displayProduto", display);
            produtos = q.getResultList();
        } catch (Exception e) {
            produtos = new ArrayList();
        } finally {
            em.close();
        }
        return produtos;

    }
    
    public List<Produto> retornaProdutosRam(String display) {
        EntityManager em = getEM();
        List<Produto> produtos;
        try {
            Query q = em.createNamedQuery("Produtos.MemoriaRam");
            q.setParameter("memoriaRamProduto", display);
            produtos = q.getResultList();
        } catch (Exception e) {
            produtos = new ArrayList();
        } finally {
            em.close();
        }
        return produtos;

    }
    
    public List<Produto> retornaProdutosMemoriaExpansiva(String memoriaExpansiva) {
        EntityManager em = getEM();
        List<Produto> produtos;
        try {
            Query q = em.createNamedQuery("Produtos.MemoriaExpansiva");
            q.setParameter("memoriaExpansivaProduto", memoriaExpansiva);
            produtos = q.getResultList();
        } catch (Exception e) {
            produtos = new ArrayList();
        } finally {
            em.close();
        }
        return produtos;

    }
    
    
    
    
}