/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
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
 * @author alunom
 */
@Entity /*transformar a classe em uma entidade*/

@Table(name = "eventos")/*adicionar a classe endereco como tabela*/

public class Eventos implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    @Id /*transformar idEndereco em um atributo identificador*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEventos;

    @Column /*adicionar nome como uma coluna*/
    private String nome;
    
    @Column /*adicionar nome como uma coluna*/
    private String descricao;
    
    @Column /*adicionar nome como uma coluna*/
    private Date data;
    
    @Column /*adicionar nome como uma coluna*/
    private String horario;

    public Integer getIdEventos() {
        return idEventos;
    }

    public void setIdEventos(Integer idEventos) {
        Integer oldIdEventos = this.idEventos;
        this.idEventos = idEventos;
        changeSupport.firePropertyChange("idEventos", oldIdEventos, idEventos);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        String oldDescricao = this.descricao;
        this.descricao = descricao;
        changeSupport.firePropertyChange("descricao", oldDescricao, descricao);
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        Date oldData = this.data;
        this.data = data;
        changeSupport.firePropertyChange("data", oldData, data);
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        String oldHorario = this.horario;
        this.horario = horario;
        changeSupport.firePropertyChange("horario", oldHorario, horario);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.idEventos);
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
        final Eventos other = (Eventos) obj;
        if (!Objects.equals(this.idEventos, other.idEventos)) {
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
