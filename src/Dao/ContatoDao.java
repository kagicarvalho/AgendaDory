/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Model.Contato;


/**
 *
 * @author Administrador
 */
public class ContatoDao {
        public void salvarAtualizar(Contato contato) {

        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();

        if (contato.getIdContato() != null) {
            contato = em.merge(contato);
            //atualizar com merge
        }

        em.persist(contato);
        em.getTransaction().commit();
        em.close();
    }

    public void excluir(Contato contato) {

        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        contato = em.merge(contato);
        em.remove(contato);
        em.getTransaction().commit();
        em.close();
    }

    public List<Contato> pesquisar(Contato contato) {

        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Contato c  where 1 = 1");
        if (contato.getIdContato() != null) {
            sql.append("and c.idContato = :idContato ");
        }
        
        if (contato.getNome() != null && contato.getNome().equals("")) {
            sql.append("and c.nome like :nome");

        }
        
        
        if (contato.getRua() != null && contato.getRua().equals("")) {
            sql.append("and c.rua like :rua");

        }
        if (contato.getBairro() != null && contato.getBairro().equals("")) {
            sql.append("and c.bairro like :bairro");

        }
        if (contato.getCidade() != null && contato.getCidade().equals("")) {
            sql.append("and c.cidade like :cidade");

        }
        if (contato.getEstado() != null && contato.getEstado().equals("")) {
            sql.append("and c.estado like :estado");

        }
        if (contato.getTelefone() != null && contato.getTelefone().equals("")) {
            sql.append("and c.telefone like :telefone");

        }
        if (contato.getCelular() != null && contato.getCelular().equals("")) {
            sql.append("and c.celular like :celular");

        }
        if (contato.getEmail() != null && contato.getEmail().equals("")) {
            sql.append("and c.email like :email");

        }
if (contato.getNumero() != null && contato.getNumero().equals("")) {
            sql.append("and c.numero like :numero");

        }
if (contato.getApelido() != null && contato.getApelido().equals("")) {
            sql.append("and c.apelido like :apelido");

        }
        
        
        
        Query query = em.createQuery(sql.toString());

        if (contato.getIdContato() != null) {

            query.setParameter("idContato", contato.getIdContato());

        }

        if (contato.getNome() != null && contato.getNome().equals("")) {

            query.setParameter("nome", '%' +contato.getNome()+ '%');

        }
        
        if (contato.getRua() != null && contato.getRua().equals("")) {

            query.setParameter("rua", '%' +contato.getRua()+ '%');

        }
        if (contato.getBairro() != null && contato.getBairro().equals("")) {

            query.setParameter("bairro", '%' +contato.getBairro()+ '%');

        }
        if (contato.getCidade() != null && contato.getCidade().equals("")) {

            query.setParameter("cidade", '%' +contato.getCidade()+ '%');

        }
        if (contato.getEstado() != null && contato.getEstado().equals("")) {

            query.setParameter("estado", '%' +contato.getEstado()+ '%');

        }
        if (contato.getTelefone() != null && contato.getTelefone().equals("")) {

            query.setParameter("telefone", '%' +contato.getTelefone()+ '%');

        }
        if (contato.getCelular() != null && contato.getCelular().equals("")) {

            query.setParameter("celular", '%' +contato.getCelular()+ '%');

        }
        if (contato.getEmail() != null && contato.getEmail().equals("")) {

            query.setParameter("email", '%' +contato.getEmail()+ '%');

        }
        if (contato.getNumero() != null && contato.getNumero().equals("")) {

            query.setParameter("numero", '%' +contato.getNumero()+ '%');

        }
        if (contato.getApelido() != null && contato.getApelido().equals("")) {

            query.setParameter("apelido", '%' +contato.getApelido()+ '%');

        }
        
        
        
        return query.getResultList();

    }
}