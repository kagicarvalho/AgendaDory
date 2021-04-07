/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import Model.Usuario;


/**
 *
 * @author Administrador
 */
public class UsuarioDao {
    
       public void salvarAtualizar(Usuario usuario) {

        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();

        if (usuario.getIdUsuario() != null) {
            usuario = em.merge(usuario);
            //atualizar com merge
        }

        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public void excluir(Usuario usuario) {

        EntityManager em = Conexao.getEntityManager();
        em.getTransaction().begin();
        usuario = em.merge(usuario);
        em.remove(usuario);
        em.getTransaction().commit();
        em.close();
    }

    public List<Usuario> pesquisar(Usuario usuario) {

        EntityManager em = Conexao.getEntityManager();
        StringBuilder sql = new StringBuilder("from Usuario c  where 1 = 1");
        
		if (usuario.getIdUsuario() != null) {
            sql.append("and c.idUsuario = :idUsuario ");
        }
        
		if (usuario.getNomeUsuario() != null) {
            sql.append("and c.nomeUsuario = :nomeUsuario ");
        }
		
        if (usuario.getSenha() != null) {
            sql.append("and c.senha = :senha ");
        }
        
		if (usuario.getUltimoAcesso() != null) {
            sql.append("and c.ultimoAcesso = :ultimoAcesso ");
        }
		
		if (usuario.getNome() != null) {
            sql.append("and c.nome = :nome ");
        }
		
		if (usuario.getApelido() != null) {
            sql.append("and c.apelido = :apelido ");
        }
		
		if (usuario.getEmail() != null) {
            sql.append("and c.email = :email ");
        }
		
		if (usuario.getPergunta() != null) {
            sql.append("and c.pergunta = :pergunta ");
        }
		if (usuario.getResposta() != null) {
            sql.append("and c.resposta = :resposta ");
        }
	
        	if (usuario.getNascimento() != null) {
            sql.append("and c.nascimento = :nascimento ");
        }
        
        Query query = em.createQuery(sql.toString());

        if (usuario.getIdUsuario() != null) {

            query.setParameter("idUsuario", usuario.getIdUsuario());

        }
		
		if (usuario.getNomeUsuario() != null) {
            query.setParameter("nomeUsuario", usuario.getNomeUsuario());
        }
		
		if (usuario.getSenha() != null) {
            query.setParameter("senha", usuario.getSenha());
        }
		
		if (usuario.getUltimoAcesso() != null) {
            query.setParameter("ultimoAcesso", usuario.getUltimoAcesso());
        }
		
		if (usuario.getNome() != null) {
            query.setParameter("nome", usuario.getNome());
        }
		
		if (usuario.getApelido() != null) {
            query.setParameter("apelido", usuario.getApelido());
        }
		
		if (usuario.getEmail() != null) {
            query.setParameter("email", usuario.getEmail());
        }
		
		if (usuario.getPergunta() != null) {
            query.setParameter("pergunta", usuario.getPergunta());
        }
		
        if (usuario.getResposta() != null) {
            query.setParameter("resposta", usuario.getResposta());
        }


        if (usuario.getNascimento() != null) {
            query.setParameter("nascimento", usuario.getNascimento());
        }
        
        return query.getResultList();

    }
}