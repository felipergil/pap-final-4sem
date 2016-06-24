/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import EJB.OperacoesEJB;
import Model.Pedido;
import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Felipe Rodrigues - 248543
 */
@ManagedBean
@RequestScoped
public class PedidoBean {
    
    @EJB
    private OperacoesEJB operacoesEJB;
    
    public PedidoBean(){
        
    }
    
    public String getQuery() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("query");
    }
    
    public String getModal() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("modal");
    }
    
    public void checkIfQueryExists() throws IOException {
        if(operacoesEJB.checkIfQueryExists(getQuery()) == 0) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
        }
    }
    
    public List<Pedido> getPedido() {
        return operacoesEJB.returnPedido(getQuery());
    }
    
}
