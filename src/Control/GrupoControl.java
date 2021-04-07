/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.GrupoDao;
import Model.Grupo;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Administrador
 */
public class GrupoControl {
    
       private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private Grupo grupoDigitado;
    private Grupo grupoSelecionado;
    private List<Grupo> grupoTabela;
    private final GrupoDao grupodao;

    public GrupoControl() {

        grupodao = new GrupoDao();
        grupoTabela = ObservableCollections.observableList(new ArrayList<Grupo>());
        novo();
        pesquisar();
    }

    public void novo() {

        setGrupoDigitado(new Grupo());

    }

    public void pesquisar() {

        grupoTabela.clear();
        grupoTabela.addAll(grupodao.pesquisar(grupoDigitado));
    }
    
    public void salvar(){
    
        grupodao.salvarAtualizar(grupoDigitado);
        novo();
        pesquisar();
    
    }
    
    public void excluir(){
    
      grupodao.excluir(grupoDigitado);
        novo();
        pesquisar();
    }

    public Grupo getGrupoDigitado() {
        return grupoDigitado;
    }

    public void setGrupoDigitado(Grupo grupoDigitado) {
        Grupo oldGrupoDigitado = this.grupoDigitado;
        this.grupoDigitado = grupoDigitado;
        propertyChangeSupport.firePropertyChange("grupoDigitado", oldGrupoDigitado, grupoDigitado);
    }

    public Grupo getGrupoSelecionado() {
        return grupoSelecionado;
    }

    public void setGrupoSelecionado(Grupo grupoSelecionado) {

        this.grupoSelecionado = grupoSelecionado;
        if (this.grupoSelecionado != null) {

            setGrupoDigitado(grupoSelecionado);
        }
    }

    public List<Grupo> getGrupoTabela() {
        return grupoTabela;
    }

    public void setGrupoTabela(List<Grupo> grupoTabela) {
        this.grupoTabela = grupoTabela;
    }
    
    public void addPropertyChangeListener (PropertyChangeListener e){
        
        propertyChangeSupport.addPropertyChangeListener(e);
    
     }
    
    public void removePropertyChangeListener (PropertyChangeListener e){
    
        propertyChangeSupport.removePropertyChangeListener(e);
    
    }

}