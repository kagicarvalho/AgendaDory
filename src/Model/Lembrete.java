/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alunom
 */
@Entity /*transformar a classe em uma entidade*/

@Table(name = "lembrete")/*adicionar a classe endereco como tabela*/

public class Lembrete implements Serializable {

    @Id /*transformar idEndereco em um atributo identificador*/

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLembrete;

    @Column /*adicionar nome como uma coluna*/
    private String anotacoes;
    
    @Column /*adicionar nome como uma coluna*/
    private Date data;

    public Lembrete() {
    }

    public Integer getIdLembrete() {
        return idLembrete;
    }

    public void setIdLembrete(Integer idLembrete) {
        this.idLembrete = idLembrete;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idLembrete);
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
        final Lembrete other = (Lembrete) obj;
        if (!Objects.equals(this.idLembrete, other.idLembrete)) {
            return false;
        }
        return true;
    }
}
