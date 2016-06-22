package EJB;

import Model.Cliente;
import javax.ejb.Local;

/**
 *
 * @author Felipe Rodrigues
 */
@Local
public interface ClienteService {
    
    Cliente createOrUpdate(Cliente cliente);
    void remove (Cliente cliente);
    
    
}
