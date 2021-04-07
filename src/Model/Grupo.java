/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kagi
 */
@Entity /*transformar a classe em uma entidade*/
@Table(name = "grupos")/*adicionar a classe endereco como tabela*/
public class Grupo implements Serializable {
    @Id /*transformar idEndereco em um atributo identificador*/
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGrupo;
    @Column /*adicionar nome como uma coluna*/
    private String nome;
    @Column /*adicionar apelido uma coluna*/
    private String comentario;



    
 
    public Grupo() {
        /*alt+insert construtor vazio*/
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

  


    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.idGrupo);
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
        final Grupo other = (Grupo) obj;
        if (!Objects.equals(this.idGrupo, other.idGrupo)) {
            return false;
        }
        return true;
    }

    
}
