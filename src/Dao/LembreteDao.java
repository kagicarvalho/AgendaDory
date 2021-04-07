/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Lembrete;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alunom
 */
public class LembreteDao {

    public void salvarAtualizar(Lembrete lembrete) {

        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();

        if (lembrete.getIdLembrete() != null) {
            lembrete = em.merge(lembrete);
            //atualizar com merge
        }

        em.persist(lembrete);
        em.getTransaction().commit();
        em.close();
    }

    public void excluir(Lembrete lembrete) {

        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        lembrete = em.merge(lembrete);
        em.remove(lembrete);
        em.getTransaction().commit();
        em.close();
    }

    public List<Lembrete> pesquisar(Lembrete lembrete) {

        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Lembrete l  where 1 = 1");
        if (lembrete.getIdLembrete() != null) {
            sql.append("and l.idLembrete = :idContato ");
        }

        if (lembrete.getAnotacoes() != null && lembrete.getAnotacoes().equals("")) {
            sql.append("and l.anotacoes like :anotacoes");

        }
        
        if (lembrete.getData() != null && lembrete.getData().equals("")) {
            sql.append("and l.data like :data");

        }

        Query query = em.createQuery(sql.toString());

        if (lembrete.getIdLembrete() != null) {

            query.setParameter("idLembrete", lembrete.getIdLembrete());

        }

        if (lembrete.getAnotacoes() != null && lembrete.getAnotacoes().equals("")) {

            query.setParameter("anotacoes", '%' + lembrete.getAnotacoes() + '%');

        }
        
        if (lembrete.getData() != null && lembrete.getData().equals("")) {

          query.setParameter("data", "%" + lembrete.getData() + '%');

        }

        return query.getResultList();

    }
}
