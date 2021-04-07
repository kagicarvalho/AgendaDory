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
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author kagi
 */
@Entity /*transformar a classe em uma entidade*/
@Table(name = "usuario")/*adicionar a classe endereco como tabela*/

public class Usuario implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @Id /*transformar idEndereco em um atributo identificador*/
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column
    private String nomeUsuario;
    
    @Column
    private String senha;
    
    @Column
    @Temporal(TemporalType.DATE)
    private Date ultimoAcesso;
	
    @Column /*adicionar apelido uma coluna*/
    private String apelido;

    @Column /*adicionar apelido uma coluna*/
    private String nome;
    
    @Column /*adicionar bairro como uma coluna*/
    private String email;
    
    @Column /*adicionar bairro como uma coluna*/
    private String nascimento;

    
    @Column /*adicionar bairro como uma coluna*/
    private String pergunta;
    @Column /*adicionar bairro como uma coluna*/
    private String resposta;

    public Usuario() {
        /*alt+insert construtor vazio*/
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdContato(Integer idUsuario) {
        Integer oldIdUsuario = this.idUsuario;
        this.idUsuario = idUsuario;
        changeSupport.firePropertyChange("idUsuario", oldIdUsuario, idUsuario);
    }
	
	    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
		String oldNomeUsuario = this.nomeUsuario;
        this.nomeUsuario = nomeUsuario;
		changeSupport.firePropertyChange("nomeUsuario", oldNomeUsuario, nomeUsuario);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
		String oldSenha = this.senha;
        this.senha = senha;
	    changeSupport.firePropertyChange("senha", oldSenha, senha);
    }

    public Date getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(Date ultimoAcesso) {
		Date oldUltimoAcesso = this.ultimoAcesso;
        this.ultimoAcesso = ultimoAcesso;
		changeSupport.firePropertyChange("ultimoAcesso", oldUltimoAcesso, ultimoAcesso);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
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
    
        public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        String oldPergunta = this.pergunta;
        this.pergunta = pergunta;
        changeSupport.firePropertyChange("pergunta", oldPergunta, pergunta);
    }
        public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String pergunta) {
        String oldNascimento = this.nascimento;
        this.nascimento = nascimento;
        changeSupport.firePropertyChange("nascimento", oldNascimento, nascimento);
    }


    
        public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        String oldResposta = this.resposta;
        this.resposta = resposta;
        changeSupport.firePropertyChange("resposta", oldResposta, resposta);
    }


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idUsuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.idUsuario, other.idUsuario)) {
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
