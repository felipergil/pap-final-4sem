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
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import javax.ejb.EJB;
import javax.xml.ws.WebServiceRef;
import org.tempuri.CResultado;
import org.tempuri.CServico;
import org.tempuri.CalcPrecoPrazoWS;

/**
 *
 * @author Felipe Rodrigues
 */
@ManagedBean
@Named(value = "carrinhoBean")
@SessionScoped
public class CarrinhoBean implements Serializable {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/ws.correios.com.br/calculador/CalcPrecoPrazo.asmx.wsdl")
    private CalcPrecoPrazoWS service;

    @EJB
    PedidoService pedidoService;

    List<Produto> produtos = new ArrayList<>();
    private String email;
    private String cepDestino;
    private Double valorFrete;
    private String prazoFrete;   
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private final Date datahora = new Date();
    
    public String getPrazoFrete() {
        return prazoFrete;
    }

    public void setPrazoFrete(String prazoFrete) {
        this.prazoFrete = prazoFrete;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public void setCepDestino(String cepDestino) {
        this.cepDestino = cepDestino;
    }

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

    public void remove(Produto p) {
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

    public void calcularPrecoEPrazo() {
        CResultado res = calcPrecoPrazo("", "", "40010", "09641000", getCepDestino(), "0.5", 1, new BigDecimal(16), new BigDecimal(5), new BigDecimal(11), new BigDecimal(10), "N", new BigDecimal(0), "N");
        List<CServico> list = res.getServicos().getCServico();
        for (CServico c : list) {
            this.valorFrete = Double.parseDouble(c.getValor().replace(",", "."));
            this.prazoFrete = c.getPrazoEntrega();
        }
    }

    private CResultado calcPrecoPrazo(java.lang.String nCdEmpresa, java.lang.String sDsSenha, java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino, java.lang.String nVlPeso, int nCdFormato, java.math.BigDecimal nVlComprimento, java.math.BigDecimal nVlAltura, java.math.BigDecimal nVlLargura, java.math.BigDecimal nVlDiametro, java.lang.String sCdMaoPropria, java.math.BigDecimal nVlValorDeclarado, java.lang.String sCdAvisoRecebimento) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.tempuri.CalcPrecoPrazoWSSoap port = service.getCalcPrecoPrazoWSSoap();
        return port.calcPrecoPrazo(nCdEmpresa, sDsSenha, nCdServico, sCepOrigem, sCepDestino, nVlPeso, nCdFormato, nVlComprimento, nVlAltura, nVlLargura, nVlDiametro, sCdMaoPropria, nVlValorDeclarado, sCdAvisoRecebimento);
    }

    public void salvarPedido() {
        Map<Produto, Integer> map = getItensCarrinho();
        String identificador = gerarIdentificador();
        for (Map.Entry<Produto, Integer> entry : map.entrySet()) {
            Pedido pedido = new Pedido();
            pedido.setDatahora(datahora);
            pedido.setFrete(getValorFrete());
            pedido.setProduto(entry.getKey().getTitulo());
            pedido.setQuantidade(entry.getValue());
            pedido.setStatus("Aguardando Pagamento");
            pedido.setValortotal(entry.getKey().getValor() * entry.getValue());
            pedido.setValorcompra(somarValorTotal() + getValorFrete());
            pedido.setIdentificador(identificador);
            pedido.setEmail(getEmail());
            pedidoService.addPedido(pedido);
        }
        produtos.removeAll(produtos);

    }

}
