/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.ContatoDao;
import Model.Contato;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Administrador
 */
public class ContatoControl {
    
       private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private Contato contatoDigitado;
    private Contato contatoSelecionado;
    private List<Contato> contatoTabela;
    private final ContatoDao contatodao;

    public ContatoControl() {

        contatodao = new ContatoDao();
        contatoTabela = ObservableCollections.observableList(new ArrayList<Contato>());
        novo();
        pesquisar();
    }

    public void novo() {

        setContatoDigitado(new Contato());

    }

    public void pesquisar() {

        contatoTabela.clear();
        contatoTabela.addAll(contatodao.pesquisar(contatoDigitado));
    }
    
    public void salvar(){
    
        contatodao.salvarAtualizar(contatoDigitado);
        novo();
        pesquisar();
    
    }
    
    public void excluir(){
    
      contatodao.excluir(contatoDigitado);
        novo();
        pesquisar();
    }

    public Contato getContatoDigitado() {
        return contatoDigitado;
    }

    public void setContatoDigitado(Contato contatoDigitado) {
        Contato oldContatoDigitado = this.contatoDigitado;
        this.contatoDigitado = contatoDigitado;
        propertyChangeSupport.firePropertyChange("contatoDigitado", oldContatoDigitado, contatoDigitado);
    }

    public Contato getContatoSelecionado() {
        return contatoSelecionado;
    }

    public void setContatoSelecionado(Contato contatoSelecionado) {

        this.contatoSelecionado = contatoSelecionado;
        if (this.contatoSelecionado != null) {

            setContatoDigitado(contatoSelecionado);
        }
    }

    public List<Contato> getContatoTabela() {
        return contatoTabela;
    }

    public void setContatoTabela(List<Contato> contatoTabela) {
        this.contatoTabela = contatoTabela;
    }
    
    public void addPropertyChangeListener (PropertyChangeListener e){
        
        propertyChangeSupport.addPropertyChangeListener(e);
    
     }
    
    public void removePropertyChangeListener (PropertyChangeListener e){
    
        propertyChangeSupport.removePropertyChangeListener(e);
    
    }

}