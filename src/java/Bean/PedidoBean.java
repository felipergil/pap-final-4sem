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
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
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
    
    private String email;

    public OperacoesEJB getOperacoesEJB() {
        return operacoesEJB;
    }

    public void setOperacoesEJB(OperacoesEJB operacoesEJB) {
        this.operacoesEJB = operacoesEJB;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public PedidoBean(){
        
    }
    
    public String getQuery() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("query");
    }
    
    public void checkIfQueryExists() throws IOException {
        if(operacoesEJB.checkIfQueryExists(getQuery()) == 0) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
        }
    }
    
    public List<Pedido> getPedido() {
        return operacoesEJB.returnPedido(getQuery());
    }
    
    public List<Pedido> getPedidos() {
        return operacoesEJB.returnPedidos();
    }
    
    public List<Pedido> getPedidoEmail() {
        return operacoesEJB.returnPedidoPorEmail(puxarEmail());
    }
    
    public String puxarEmail() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        Map<String, Object> sessionMap = externalContext.getSessionMap();
        this.email = (String) sessionMap.get("email");
        return email;
    }
    
}
