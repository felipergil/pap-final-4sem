/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;
import Model.Pedido;
import javax.ejb.Local;

/**
 *
 * @author Felipe Rodrigues - 248543
 */
@Local
public interface PedidoService {
    
    Pedido addPedido(Pedido pedido);
    
}
