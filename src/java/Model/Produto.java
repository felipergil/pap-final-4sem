/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author NOTFELIPE
 */
@Entity
@Table(name = "produto")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produtos.Marca", query = "SELECT p FROM Produto P where p.marca LIKE :marcaAtribuida"),
    @NamedQuery(name = "Produtos.Sistema", query = "SELECT p FROM Produto P where p.sistema LIKE :sistemaAtribuido"),
    @NamedQuery(name = "Produtos.Titulo", query = "SELECT p FROM Produto P where p.titulo LIKE :tituloProduto"),
    @NamedQuery(name = "Produtos.Preco", query = "SELECT p FROM Produto P where p.valor >= :precoInicial AND " + "p.valor <= :precoFinal"),
    @NamedQuery(name = "Produtos.Cor", query = "SELECT p FROM Produto P where p.cor LIKE :corProduto"),
    @NamedQuery(name = "Produtos.Memoria", query = "SELECT p FROM Produto P where p.memoria LIKE :memoriaProduto"),
    @NamedQuery(name = "Produtos.Display", query = "SELECT p FROM Produto P where p.display = :displayProduto"),
    @NamedQuery(name = "Produtos.MemoriaRam", query = "SELECT p FROM Produto P where p.ram LIKE :memoriaRamProduto"),
    @NamedQuery(name = "Produtos.MemoriaExpansiva", query = "SELECT p FROM Produto P where p.memoriaexpansiva LIKE :memoriaExpansivaProduto")
})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Size(max = 1000)
    @Column(name = "imageminicial")
    private String imagemInicial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 500)
    @Column(name = "minidescricao")
    private String miniDescricao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private double valor;
    @Size(max = 15)
    @Column(name = "marca")
    private String marca;
    @Size(max = 15)
    @Column(name = "cor")
    private String cor;
    @Size(max = 15)
    @Column(name = "chip")
    private String chip;
    @Size(max = 15)
    @Column(name = "memoria")
    private String memoria;
    @Size(max = 100)
    @Column(name = "processador")
    private String processador;
    @Size(max = 15)
    @Column(name = "sistema")
    private String sistema;
    @Size(max = 15)
    @Column(name = "display")
    private String display;
    @Size(max = 15)
    @Column(name = "cameratraseira")
    private String cameraTraseira;
    @Size(max = 15)
    @Column(name = "cameraFrontal")
    private String cameraFrontal;
    @Size(max = 15)
    @Column(name = "filmadora")
    private String filmadora;
    @Size(max = 30)
    @Column(name = "memoriaexpansiva")
    private String memoriaexpansiva;
    @Size(max = 100)
    @Column(name = "tipobateria")
    private String tipoBateria;
    @Size(max = 1000)
    @Column(name = "banda")
    private String banda;
    @Size(max = 15)
    @Column(name = "conectividade")
    private String conectividade;
    @Size(max = 15)
    @Column(name = "nfc")
    private String nfc;
    @Size(max = 15)
    @Column(name = "tv")
    private String tv;
    @Size(max = 200)
    @Column(name = "conteudoembalagem")
    private String conteudoEmbalagem;
    @Size(max = 30)
    @Column(name = "dimensoes")
    private String dimensoes;
    @Size(max = 15)
    @Column(name = "peso")
    private String peso;
    @Size(max = 15)
    @Column(name = "garantia")
    private String garantia;
    @Size(max = 25)
    @Column(name = "referenciamodelo")
    private String referenciaModelo;
    @Size(max = 30)
    @Column(name = "fornecedor")
    private String fornecedor;
    @Size(max = 50)
    @Column(name = "sac")
    private String sac;
    @Size(max = 1000)
    @Column(name = "imagemdetalheum")
    private String imagemDetalheUm;
    @Size(max = 1000)
    @Column(name = "imagemdetalhedois")
    private String imagemDetalheDois;
    @Size(max = 1000)
    @Column(name = "imagemdetalhetres")
    private String imagemDetalheTres;
    @Size(max = 2000)
    @Column(name = "descricao")
    private String descricao;
    @Size(max = 20)
    @Column(name = "simbolo")
    private String simbolo;
    @Size(max = 15)
    @Column(name = "ram")
    private String ram;
    @Size(max = 20)
    @Column(name = "quantidadechip")
    private String quantidadeChip;
    @Size(max = 20)
    @Column(name = "sistemaversao")
    private String sistemaVersao;
    @Size(max = 50)
    @Column(name = "resolucao")
    private String resolucao;
    @Size(max = 20)
    @Column(name = "tipodetela")
    private String tipoDeTela;
    @Size(max = 20)
    @Column(name = "categoria")
    private String categoria;

    public Produto() {
    }

    public Produto(Long id) {
        this.id = id;
    }

    public Produto(Long id, String titulo, double valor) {
        this.id = id;
        this.titulo = titulo;
        this.valor = valor;
    }

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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
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

    public String getMemoriaexpansiva() {
        return memoriaexpansiva;
    }

    public void setMemoriaexpansiva(String memoriaexpansiva) {
        this.memoriaexpansiva = memoriaexpansiva;
    }

    public String getTipoBateria() {
        return tipoBateria;
    }

    public void setTipobateria(String tipoBateria) {
        this.tipoBateria = tipoBateria;
    }

    public String getBanda() {
        return banda;
    }

    public void setBanda(String banda) {
        this.banda = banda;
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

    public String getImagemDetalheDois() {
        return imagemDetalheDois;
    }

    public void setImagemDetalheDois(String imagemDetalheDois) {
        this.imagemDetalheDois = imagemDetalheDois;
    }

    public String getImagemDetalheTres() {
        return imagemDetalheTres;
    }

    public void setImagemDetalheTres(String imagemDetalheTres) {
        this.imagemDetalheTres = imagemDetalheTres;
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

    public String getTipoDeTela() {
        return tipoDeTela;
    }

    public void setTipoDeTela(String tipoDeTela) {
        this.tipoDeTela = tipoDeTela;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Model.Produto[ id=" + id + " ]";
    }
    
}
