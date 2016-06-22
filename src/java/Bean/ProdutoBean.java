/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import EJB.OperacoesEJB;
import Model.Produto;
import java.io.IOException;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import DAO.ProdutoDAO;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Felipe Rodrigues
 */
@ManagedBean
@Named(value = "produtoBean")
@SessionScoped
public class ProdutoBean implements Serializable {

    private String pesquisa;
    private Double valorInicial;
    private Double valorFinal;
    private String tipoPesquisa;
    private Long id;
    private String imagemInicial;
    private String titulo;
    private String miniDescricao;
    private Double valor;
    private String marca;
    private String cor;
    private String chip;
    private String memoria;
    private String processador;
    private String sistema;
    private String display;
    private String cameraTraseira;
    private String cameraFrontal;
    private String filmadora;
    private String memoriaExpansiva;
    private String tipoBateria;
    private String conectividade;
    private String nfc;
    private String tv;
    private String conteudoEmbalagem;
    private String dimensoes;
    private String peso;
    private String garantia;
    private String referenciaModelo;
    private String fornecedor;
    private String sac;
    private String imagemDetalheUm;
    private String imagemDetalhesDois;
    private String imagemDetalhesTres;
    private String descricao;
    private String simbolo;
    private String ram;
    private String quantidadeChip;
    private String sistemaVersao;
    private String resolucao;
    private String tipoTela;
    private String categoria;

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
    }
    private String banda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImagemInicial() {
        return imagemInicial;
    }

    public void setImagemInicial(String imagemInicial) {
        this.imagemInicial = imagemInicial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMiniDescricao() {
        return miniDescricao;
    }

    public void setMiniDescricao(String miniDescricao) {
        this.miniDescricao = miniDescricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getCameraTraseira() {
        return cameraTraseira;
    }

    public void setCameraTraseira(String cameraTraseira) {
        this.cameraTraseira = cameraTraseira;
    }

    public String getCameraFrontal() {
        return cameraFrontal;
    }

    public void setCameraFrontal(String cameraFrontal) {
        this.cameraFrontal = cameraFrontal;
    }

    public String getFilmadora() {
        return filmadora;
    }

    public void setFilmadora(String filmadora) {
        this.filmadora = filmadora;
    }

    public String getMemoriaExpansiva() {
        return memoriaExpansiva;
    }

    public void setMemoriaExpansiva(String memoriaExpansiva) {
        this.memoriaExpansiva = memoriaExpansiva;
    }

    public String getTipoBateria() {
        return tipoBateria;
    }

    public void setTipoBateria(String tipoBateria) {
        this.tipoBateria = tipoBateria;
    }

    public String getConectividade() {
        return conectividade;
    }

    public void setConectividade(String conectividade) {
        this.conectividade = conectividade;
    }

    public String getNfc() {
        return nfc;
    }

    public void setNfc(String nfc) {
        this.nfc = nfc;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public String getConteudoEmbalagem() {
        return conteudoEmbalagem;
    }

    public void setConteudoEmbalagem(String conteudoEmbalagem) {
        this.conteudoEmbalagem = conteudoEmbalagem;
    }

    public String getDimensoes() {
        return dimensoes;
    }

    public void setDimensoes(String dimensoes) {
        this.dimensoes = dimensoes;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getGarantia() {
        return garantia;
    }

    public void setGarantia(String garantia) {
        this.garantia = garantia;
    }

    public String getReferenciaModelo() {
        return referenciaModelo;
    }

    public void setReferenciaModelo(String referenciaModelo) {
        this.referenciaModelo = referenciaModelo;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getSac() {
        return sac;
    }

    public void setSac(String sac) {
        this.sac = sac;
    }

    public String getImagemDetalheUm() {
        return imagemDetalheUm;
    }

    public void setImagemDetalheUm(String imagemDetalheUm) {
        this.imagemDetalheUm = imagemDetalheUm;
    }

    public String getImagemDetalhesDois() {
        return imagemDetalhesDois;
    }

    public void setImagemDetalhesDois(String imagemDetalhesDois) {
        this.imagemDetalhesDois = imagemDetalhesDois;
    }

    public String getImagemDetalhesTres() {
        return imagemDetalhesTres;
    }

    public void setImagemDetalhesTres(String imagemDetalhesTres) {
        this.imagemDetalhesTres = imagemDetalhesTres;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getQuantidadeChip() {
        return quantidadeChip;
    }

    public void setQuantidadeChip(String quantidadeChip) {
        this.quantidadeChip = quantidadeChip;
    }

    public String getSistemaVersao() {
        return sistemaVersao;
    }

    public void setSistemaVersao(String sistemaVersao) {
        this.sistemaVersao = sistemaVersao;
    }

    public String getResolucao() {
        return resolucao;
    }

    public void setResolucao(String resolucao) {
        this.resolucao = resolucao;
    }

    public String getTipoTela() {
        return tipoTela;
    }

    public void setTipoTela(String tipoTela) {
        this.tipoTela = tipoTela;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
   

    public Double getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(Double valorInicial) {
        this.valorInicial = valorInicial;
    }

    public Double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(Double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public String getTipoPesquisa() {
        return tipoPesquisa;
    }

    public void setTipoPesquisa(String tipoPesquisa) {
        this.tipoPesquisa = tipoPesquisa;
    }
    
    

    private static Map<String, Object> pesquisaValue;

    static {
        pesquisaValue = new LinkedHashMap<String, Object>();
        pesquisaValue.put("Cor", "Cor");
        pesquisaValue.put("Nome", "Nome");
        pesquisaValue.put("Tamanho display", "Tamanho display");
        pesquisaValue.put("Memória expansiva", "Memória expansiva");
        pesquisaValue.put("Memória interna", "Memória interna");
        pesquisaValue.put("Memória RAM", "Memória RAM");
        pesquisaValue.put("Valor", "Valor");
    }
    
    private static Map<String, Object> pesquisaValueCor;

    static {
        pesquisaValueCor = new LinkedHashMap<String, Object>();
        pesquisaValueCor.put("Selecione a cor", "Selecione a cor");
        pesquisaValueCor.put("Branco", "Branco");
        pesquisaValueCor.put("Branco e Rosa", "Branco/Rosa");
        pesquisaValueCor.put("Dourado", "Dourado");
        pesquisaValueCor.put("Preto e Branco", "Preto/Branco");
        pesquisaValueCor.put("Preto", "Preto");
        pesquisaValueCor.put("Rosa", "Rosa");
    }
    
    private static Map<String, Object> pesquisaValueMemoriaInterna;

    static {
        pesquisaValueMemoriaInterna = new LinkedHashMap<String, Object>();
        pesquisaValueMemoriaInterna.put("Selecione a quantidade", "Selecione a quantidade");
        pesquisaValueMemoriaInterna.put("1GB", "1GB");
        pesquisaValueMemoriaInterna.put("8GB", "8GB");
        pesquisaValueMemoriaInterna.put("16GB", "16GB");
        pesquisaValueMemoriaInterna.put("32GB", "32GB");
        pesquisaValueMemoriaInterna.put("64GB", "64GB");

    }
    
    private static Map<String, Object> pesquisaValueDisplay;

    static {
        pesquisaValueDisplay = new LinkedHashMap<String, Object>();
        pesquisaValueDisplay.put("Selecione o tamanho", "Selecione o tamanho");
        pesquisaValueDisplay.put("4", "4.0");
        pesquisaValueDisplay.put("4.7", "4.7");
        pesquisaValueDisplay.put("5", "5.0");
        pesquisaValueDisplay.put("5.1", "5.1");
        pesquisaValueDisplay.put("5.5", "5.5");
        pesquisaValueDisplay.put("5.4", "5.4");
        pesquisaValueDisplay.put("6", "6.0");   

    }
    
    private static Map<String, Object> pesquisaValueRam;

    static {
        pesquisaValueRam = new LinkedHashMap<String, Object>();
        pesquisaValueRam.put("Selecione a quantidade", "Selecione a quantidade");
        pesquisaValueRam.put("1GB", "1 GB");
        pesquisaValueRam.put("1.5GB", "1.5 GB");
        pesquisaValueRam.put("2GB", "2 GB");
        pesquisaValueRam.put("3GB", "3 GB");
        pesquisaValueRam.put("4GB", "4 GB");

    }

    public Map<String, Object> getPesquisaValueRam() {
        return pesquisaValueRam;
    }
    
    private static Map<String, Object> pesquisaValueMemoriaExpansiva;

    static {
        pesquisaValueMemoriaExpansiva = new LinkedHashMap<String, Object>();
        pesquisaValueMemoriaExpansiva.put("Selecione a quantidade", "Selecione a quantidade");
        pesquisaValueMemoriaExpansiva.put("Sem expansão", "Não");
        pesquisaValueMemoriaExpansiva.put("MicroSD até 32GB", "MicroSD até 32GB");
        pesquisaValueMemoriaExpansiva.put("MicroSD até 128GB", "MicroSD até 128GB");
        pesquisaValueMemoriaExpansiva.put("MicroSD até 200GB", "MicroSD até 200GB");
    }

    public Map<String, Object> getPesquisaValueMemoriaExpansiva() {
        return pesquisaValueMemoriaExpansiva;
    }
    
    

    public Map<String, Object> getPesquisaValueDisplay() {
        return pesquisaValueDisplay;
    }

    public Map<String, Object> getPesquisaValueMemoriaInterna() {
        return pesquisaValueMemoriaInterna;
    }

    public Map<String, Object> getPesquisaValueCor() {
        return pesquisaValueCor;
    }

    public Map<String, Object> getPesquisaValue() {
        return pesquisaValue;
    }

    
    
    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public OperacoesEJB getOperacoesEJB() {
        return operacoesEJB;
    }

    public void setOperacoesEJB(OperacoesEJB operacoesEJB) {
        this.operacoesEJB = operacoesEJB;
    }

    @EJB
    private OperacoesEJB operacoesEJB;

    @ManagedProperty(value = "#{carrinhoBean}")
    CarrinhoBean carrinho;

    public CarrinhoBean getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(CarrinhoBean carrinho) {
        this.carrinho = carrinho;
    }

    /**
     * Creates a new instance of ProdutoBean
     */
    public ProdutoBean() {
    }

    public String getQuery() {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("query");
    }

    public void checarExistenciaQuery() throws IOException {
        if (operacoesEJB.checarExistenciaQuery(getQuery()) == 0) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("error.xhtml");
        }
    }

    public Produto getProduto() {
        return operacoesEJB.returnProduct(getQuery());
    }

    public void adicionarAoCarrinho() {
        String query = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("query");
        carrinho.add(operacoesEJB.returnProduct(query));
    }

    public List<Produto> retornaProdutosPorNome() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtos = produtoDAO.retornaProdutos(getPesquisa());
        return produtos;
    }

    public List<Produto> retornaProdutosPorValor() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtos = produtoDAO.retornaProdutosValor(getValorInicial(), getValorFinal());
        return produtos;
    }

    public List<Produto> retornaProdutosPorCor() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtos = produtoDAO.retornaProdutosCor(getPesquisa());
        return produtos;
    }

    public List<Produto> retornaProdutosPorMemoria() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtos = produtoDAO.retornaProdutosMemoria(getPesquisa());
        return produtos;
    }

    public List<Produto> retornaProdutosPorDisplay() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtos = produtoDAO.retornaProdutosDisplay(getPesquisa());
        return produtos;
    }

    public List<Produto> retornaProdutosPorMemoriaRam() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtos = produtoDAO.retornaProdutosRam(getPesquisa());
        return produtos;
    }
    
    public List<Produto> retornaProdutosPorMemoriaExpansiva() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtos = produtoDAO.retornaProdutosMemoriaExpansiva(getPesquisa());
        return produtos;
    }
    

}
