/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Model.Grupo;


/**
 *
 * @author Administrador
 */
public class GrupoDao {
        public void salvarAtualizar(Grupo grupo) {

        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();

        if (grupo.getIdGrupo() != null) {
            grupo = em.merge(grupo);
            //atualizar com merge
        }

        em.persist(grupo);
        em.getTransaction().commit();
        em.close();
    }

    public void excluir(Grupo grupo) {

        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        grupo = em.merge(grupo);
        em.remove(grupo);
        em.getTransaction().commit();
        em.close();
    }

    public List<Grupo> pesquisar(Grupo grupo) {

        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Grupo c  where 1 = 1");
        if (grupo.getIdGrupo() != null) {
            sql.append("and c.idGrupo = :idGrupo ");
        }
        
        if (grupo.getNome() != null && grupo.getNome().equals("")) {
            sql.append("and c.nome like :nome");

        }
        
        
        if (grupo.getComentario() != null && grupo.getComentario().equals("")) {
            sql.append("and c.comentario like :comentario");

        }
        
        
        
        Query query = em.createQuery(sql.toString());

        if (grupo.getIdGrupo() != null) {

            query.setParameter("idContato", grupo.getIdGrupo());

        }

        if (grupo.getNome() != null && grupo.getNome().equals("")) {

            query.setParameter("nome", '%' +grupo.getNome()+ '%');

        }
        
        if (grupo.getComentario() != null && grupo.getComentario().equals("")) {

            query.setParameter("comentario", '%' +grupo.getComentario()+ '%');

        }

        
        return query.getResultList();

    }
}