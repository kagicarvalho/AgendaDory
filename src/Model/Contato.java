/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author kagi
 */
@Entity /*transformar a classe em uma entidade*/

@Table(name = "contato")/*adicionar a classe endereco como tabela*/

public class Contato implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @Id /*transformar idEndereco em um atributo identificador*/

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idContato;

    @Column /*adicionar nome como uma coluna*/
    private String nome;
    
    @Column /*adicionar apelido uma coluna*/
    private String apelido;

    @Column /*adicionar rua uma coluna*/
    private String rua;
    
    @Column /*adicionar ruaomo uma coluna*/
    private String numero;
    
    @Column /*adicionar rua como uma coluna*/
    private String bairro;
    
    @Column /*adicionar bairro como uma coluna*/
    private String cidade;
    
    @Column /*adicionar cidade como uma coluna*/
    private String estado;
   
    @Column /*adicionar telefone como uma coluna*/
    private String telefone;
   
    @Column /*adicionar bairro como uma coluna*/
    private String celular;
    
    @Column /*adicionar bairro como uma coluna*/
    private String email;

    public Contato() {
        /*alt+insert construtor vazio*/
    }

    public Integer getIdContato() {
        return idContato;
    }

    public void setIdContato(Integer idContato) {
        Integer oldIdContato = this.idContato;
        this.idContato = idContato;
        changeSupport.firePropertyChange("idContato", oldIdContato, idContato);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        String oldRua = this.rua;
        this.rua = rua;
        changeSupport.firePropertyChange("rua", oldRua, rua);
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        String oldBairro = this.bairro;
        this.bairro = bairro;
        changeSupport.firePropertyChange("bairro", oldBairro, bairro);
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        String oldCidade = this.cidade;
        this.cidade = cidade;
        changeSupport.firePropertyChange("cidade", oldCidade, cidade);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        String oldEstado = this.estado;
        this.estado = estado;
        changeSupport.firePropertyChange("estado", oldEstado, estado);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        String oldTelefone = this.telefone;
        this.telefone = telefone;
        changeSupport.firePropertyChange("telefone", oldTelefone, telefone);
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        String oldCelular = this.celular;
        this.celular = celular;
        changeSupport.firePropertyChange("celular", oldCelular, celular);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String oldEmail = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", oldEmail, email);
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        String oldApelido = this.apelido;
        this.apelido = apelido;
        changeSupport.firePropertyChange("apelido", oldApelido, apelido);
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        String oldNumero = this.numero;
        this.numero = numero;
        changeSupport.firePropertyChange("numero", oldNumero, numero);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idContato);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contato other = (Contato) obj;
        if (!Objects.equals(this.idContato, other.idContato)) {
            return false;
        }
        return true;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
