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
   
}