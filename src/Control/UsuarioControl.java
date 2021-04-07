/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.UsuarioDao;
import Model.Usuario;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Administrador
 */
public class UsuarioControl {
    
       private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private Usuario usuarioDigitado;
    private Usuario usuarioSelecionado;
    private List<Usuario> usuarioTabela;
    private final UsuarioDao usuariodao;

    public UsuarioControl() {

        usuariodao = new UsuarioDao();
        usuarioTabela = ObservableCollections.observableList(new ArrayList<Usuario>());
        novo();
        pesquisar();
    }

    public void novo() {

        setUsuarioDigitado(new Usuario());

    }

    public void pesquisar() {

        usuarioTabela.clear();
        usuarioTabela.addAll(usuariodao.pesquisar(usuarioDigitado));
    }
    
    public void salvar(){
    
        usuariodao.salvarAtualizar(usuarioDigitado);
        novo();
        pesquisar();
    
    }
    
    public void excluir(){
    
      usuariodao.excluir(usuarioDigitado);
        novo();
        pesquisar();
    }

    public Usuario getUsuarioDigitado() {
        return usuarioDigitado;
    }

    public void setUsuarioDigitado(Usuario usuarioDigitado) {
        Usuario oldUsuarioDigitado = this.usuarioDigitado;
        this.usuarioDigitado = usuarioDigitado;
        propertyChangeSupport.firePropertyChange("usuarioDigitado", oldUsuarioDigitado, usuarioDigitado);
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {

        this.usuarioSelecionado = usuarioSelecionado;
        if (this.usuarioSelecionado != null) {

            setUsuarioDigitado(usuarioSelecionado);
        }
    }

    public List<Usuario> getUsuarioTabela() {
        return usuarioTabela;
    }

    public void setUsuarioTabela(List<Usuario> usuarioTabela) {
        this.usuarioTabela = usuarioTabela;
    }
    
    public void addPropertyChangeListener (PropertyChangeListener e){
        
        propertyChangeSupport.addPropertyChangeListener(e);
    
     }
    
    public void removePropertyChangeListener (PropertyChangeListener e){
    
        propertyChangeSupport.removePropertyChangeListener(e);
    
    }

}