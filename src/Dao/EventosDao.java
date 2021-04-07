/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Eventos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;

/**
 *
 * @author alunom
 */
public class EventosDao {

    public void salvarAtualizar(Eventos eventos) {

        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();

        if (eventos.getIdEventos() != null) {
            eventos = em.merge(eventos);
            //atualizar com merge
        }

        em.persist(eventos);
        em.getTransaction().commit();
        em.close();
    }

    public void excluir(Eventos eventos) {

        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        eventos = em.merge(eventos);
        em.remove(eventos);
        em.getTransaction().commit();
        em.close();
    }

    public List<Eventos> pesquisar(Eventos eventos) {

        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Eventos e  where 1 = 1");
        if (eventos.getIdEventos() != null) {
            sql.append("and e.idLembrete = :idLembrete ");
        }

        if (eventos.getNome() != null && eventos.getNome().equals("")) {
            sql.append("and e.nome like :nome");
        }

        if (eventos.getData() != null && eventos.getData().equals("")) {
            sql.append("and e.data like :data");

        }
        if (eventos.getHorario() != null && eventos.getHorario().equals("")) {
            sql.append("and e.horario like :horario");

        }
        if (eventos.getDescricao()!= null && eventos.getDescricao().equals("")) {
            sql.append("and e.descricao like :descricao");

        }

        Query query = em.createQuery(sql.toString());

        if (eventos.getIdEventos() != null) {

            query.setParameter("idContato", eventos.getIdEventos());

        }

        if (eventos.getNome() != null && eventos.getNome().equals("")) {

            query.setParameter("nome", '%' + eventos.getNome() + '%');

        }

        if (eventos.getData() != null && eventos.getData().equals("")) {

            query.setParameter("data", "%" + eventos.getData() + '%');

        }
        if (eventos.getHorario() != null && eventos.getHorario().equals("")) {

            query.setParameter("horario", '%' + eventos.getHorario() + '%');

        }
        if (eventos.getDescricao()!= null && eventos.getDescricao().equals("")) {

            query.setParameter("descricao", '%' + eventos.getDescricao()+ '%');

        }

        return query.getResultList();

    }
}
