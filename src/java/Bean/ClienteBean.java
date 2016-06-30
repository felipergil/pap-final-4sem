/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.ClienteDAO;
import EJB.ClienteService;
import Model.Cliente;
import Utilitarios.SessionUtil;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Felipe Rodrigues
 */

@ManagedBean
@Named(value = "clienteBean")
@SessionScoped
public class ClienteBean implements Serializable {
    
    @EJB
    ClienteService clienteService;
    
    private Long id;
    private String cpf;
    private String nome;
    private String datanascimento;
    private String rua;
    private String bairro;
    private String estado;
    private String cep;
    private String cidade;
    private String celular;
    private String telefone;
    private String email;
    private int numeroendereco;
    private String senha;

    public ClienteBean() {
    }
    
     public String salvar() {
        Cliente cliente = new Cliente();
        cliente.setBairro(getBairro());
        cliente.setCelular(getCelular());
        cliente.setCep(getCep());
        cliente.setCidade(getCidade());
        cliente.setCpf(getCpf());
        cliente.setDatanascimento(getDatanascimento());
        cliente.setEmail(getEmail());
        cliente.setEstado(getEstado());
        cliente.setNome(getNome());
        cliente.setNumeroendereco(getNumeroendereco());
        cliente.setRua(getRua());
        cliente.setSenha(getSenha());
        cliente.setTelefone(getTelefone());
        clienteService.createOrUpdate(cliente);
        return "/index.xhtml?faces-redirect=true";
    }
     
     public void atualizar() {
        Cliente cliente = new Cliente();
        cliente.setBairro(getBairro());
        cliente.setCelular(getCelular());
        cliente.setCep(getCep());
        cliente.setCidade(getCidade());
        cliente.setCpf(getCpf());
        cliente.setDatanascimento(getDatanascimento());
        cliente.setEmail(getEmail());
        cliente.setEstado(getEstado());
        cliente.setNome(getNome());
        cliente.setNumeroendereco(getNumeroendereco());
        cliente.setRua(getRua());
        cliente.setSenha(getSenha());
        cliente.setTelefone(getTelefone());
        cliente.setId(getId());
        clienteService.createOrUpdate(cliente);
    }

    public String login() {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.validarLogin(getEmail(), getSenha());
        if(cliente == null) {
            FacesContext.getCurrentInstance().addMessage(
                               null,
                               new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email ou senha incorreto",
                                           "Email ou senha incorreto"));
            return null;
        } else {
            Object b = new Object();
            SessionUtil.setParam("USUARIOLogado", b);
            setBairro(cliente.getBairro());
            setCelular(cliente.getCelular());
            setCep(cliente.getCep());
            setCidade(cliente.getCidade());
            setCpf(cliente.getCpf());
            setDatanascimento(cliente.getDatanascimento());
            setEmail(cliente.getEmail());
            setNome(cliente.getNome());
            setNumeroendereco(cliente.getNumeroendereco());
            setRua(cliente.getRua());
            setSenha(cliente.getSenha());
            setEstado(cliente.getEstado());
            setTelefone(cliente.getTelefone());
            setId(cliente.getId());
            return "/index.xhtml?faces-redirect=true";
        }
    }
    
    public String loginCompra() {
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.validarLogin(getEmail(), getSenha());
        if(cliente == null) {
            FacesContext.getCurrentInstance().addMessage(
                               null,
                               new FacesMessage(FacesMessage.SEVERITY_ERROR, "Email ou senha incorreto",
                                           "Email ou senha incorreto"));
            return null;
        } else {
            Object b = new Object();
            SessionUtil.setParam("USUARIOLogado", b);
            setBairro(cliente.getBairro());
            setCelular(cliente.getCelular());
            setCep(cliente.getCep());
            setCidade(cliente.getCidade());
            setCpf(cliente.getCpf());
            setDatanascimento(cliente.getDatanascimento());
            setEmail(cliente.getEmail());
            setNome(cliente.getNome());
            setNumeroendereco(cliente.getNumeroendereco());
            setRua(cliente.getRua());
            setSenha(cliente.getSenha());
            setEstado(cliente.getEstado());
            setTelefone(cliente.getTelefone());
            setId(cliente.getId());
            return "/endereco.xhtml?faces-redirect=true";
        }
    }
    
    public String logout() {
        SessionUtil.invalidate();
        return "/index.xhtml?faces-redirect=true";
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDatanascimento() {
        return datanascimento;
    }

    public void setDatanascimento(String datanascimento) {
        this.datanascimento = datanascimento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumeroendereco() {
        return numeroendereco;
    }

    public void setNumeroendereco(int numeroendereco) {
        this.numeroendereco = numeroendereco;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }   
}
