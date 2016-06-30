package Bean;

import EJB.PedidoService;
import Model.Pedido;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import Model.Produto;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;

/**
 *
 * @author Felipe Rodrigues
 */
@ManagedBean
@Named(value = "carrinhoBean")
@SessionScoped
public class CarrinhoBean implements Serializable {
    
    @EJB
    PedidoService pedidoService;

    List<Produto> produtos = new ArrayList<>();
    public String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Creates a new instance of CarrinhoBean
     */
    public CarrinhoBean() {
    }

    public void add(Produto p) {
        produtos.add(p);
    }

    public  void remove(Produto p) {
        produtos.remove(p);
    }

    public int getCarrinhoTamanho() {
        return produtos.size();
    }

    public Map<Produto, Integer> getItensCarrinho() {
        Map<Produto, Integer> carrinhoConteudo = new HashMap<>();
        produtos.stream().forEach(new Consumer<Produto>() {
            @Override
            public void accept(Produto obj) {
                if (carrinhoConteudo.containsKey(obj)) {
                    carrinhoConteudo.put(obj, 1 + carrinhoConteudo.get(obj));
                } else {
                    carrinhoConteudo.put(obj, 1);

                }
            }
        });
        return carrinhoConteudo;
    }

    public double somarValorTotal() {
        double soma = 0;
        for (Produto obj : produtos) {
            if (produtos.contains(obj)) {
                soma += obj.getValor();
            }
        }
        return soma;
    }

    public String payment() {
        salvarPedido();
        return "payment";
    }

    public String finalizarCompra() {
        return "finalizarcompra?faces-redirect=true";
    }
    
    public String endereco() {
        return "endereco?faces-redirect=true";
    }

    public String pagamentoBoleto() {
        return "boleto?faces-redirect=true";
    }
    
    public void verificarCompra() {
        if(getCarrinhoTamanho() == 0) {
            endereco();
        }
    }

    /*Gero um código identificador para quando houver um pedido com vários produtos 
      conseguir identificar de qual pedido ele pertence
    */
    public String gerarIdentificador() {
        String identificador = Long.toHexString(Double.doubleToLongBits(Math.random()));
        return identificador;
    }
    
    public void salvarPedido() {
        Map<Produto, Integer> map = getItensCarrinho();
        String identificador = gerarIdentificador();
        for (Map.Entry<Produto, Integer> entry : map.entrySet()) {
            Pedido pedido = new Pedido();
            pedido.setDatahora("21/06/16");
            pedido.setFrete(1.1);
            pedido.setProduto(entry.getKey().getTitulo());
            pedido.setQuantidade(entry.getValue());
            pedido.setStatus("Aguardando Pagamento");
            pedido.setValortotal(entry.getKey().getValor() * entry.getValue());
            pedido.setValorcompra(somarValorTotal());
            pedido.setIdentificador(identificador);
            pedido.setEmail(getEmail());
            pedidoService.addPedido(pedido);
        }
        produtos.removeAll(produtos);
        
    }
    
    
   
}
