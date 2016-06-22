/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import EJB.OperacoesEJB;
import Model.Pedido;
import Model.Produto;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;


/**
 *
 * @author Felipe Rodrigues
 */
@Named(value = "indiceBean")
@ManagedBean
@RequestScoped
public class IndiceBean implements Serializable {

    @EJB
    private OperacoesEJB operacoesEJB;
    
    
    /**
     * Creates a new instance of ProdutoBean
     */
    public IndiceBean() {
    }
    
    public List<Pedido> getPedidos() {
        return operacoesEJB.returnPedidos();
    }
    
    public List<Produto> getProdutos() {
        return operacoesEJB.returnProdutos();
    }
    
    public List<Produto> getProdutosApple() {
        return operacoesEJB.returnProdutosApple();
    }
    
    public List<Produto> getProdutosLG() {
        return operacoesEJB.returnProdutosLG();
    }
    
    public List<Produto> getProdutosSamsung() {
        return operacoesEJB.returnProdutosSamsung();
    }
    
    public List<Produto> getProdutosMotorola() {
        return operacoesEJB.returnProdutosMotorola();
    }
    
    public List<Produto> getProdutosMicrosoft() {
        return operacoesEJB.returnProdutosMicrosoft();
    }
    
    public List<Produto> getProdutosEntrada() {
        return operacoesEJB.returnProdutosEntrada();
    }
    
    public List<Produto> getProdutosIntermediario() {
        return operacoesEJB.returnProdutosIntermediario();
    }
    
    public List<Produto> getProdutosHighEnd() {
        return operacoesEJB.returnProdutosHighEnd();
    }
    
    public List<Produto> getProdutosIOS() {
        return operacoesEJB.returnProdutosIOS();
    }
    
    public List<Produto> getProdutosAndroid() {
        return operacoesEJB.returnProdutosAndroid();
    }
    
    public List<Produto> getProdutosWindows() {
        return operacoesEJB.returnProdutosWindows();
    }
   
}