/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.LembreteDao;
import Model.Lembrete;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author alunom
 */
public class LembreteControl {

    
    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private Lembrete lembreteDigitado;
    private Lembrete lembreteSelecionado;
    private List<Lembrete> lembreteTabela;
    private final LembreteDao lembretedao;

    public LembreteControl() {

      lembretedao = new LembreteDao();
      lembreteTabela = ObservableCollections.observableList(new ArrayList<Lembrete>());
        novo();
        pesquisar();
    }

    public void novo() {

        setLembreteDigitado(new Lembrete());

    }

    public void pesquisar() {

        lembreteTabela.clear();
        lembreteTabela.addAll(lembretedao.pesquisar(lembreteDigitado));
    }
    
    public void salvar(){
    
        lembretedao.salvarAtualizar(lembreteDigitado);
        novo();
        pesquisar();
    
    }
    
    public void excluir(){
    
      lembretedao.excluir(lembreteDigitado);
        novo();
        pesquisar();
    }

    public Lembrete getLembreteDigitado() {
        return lembreteDigitado;
    }

    public void setLembreteDigitado(Lembrete lembreteDigitado) {
        Lembrete oldLembreteDigitado = this.lembreteDigitado;
        this.lembreteDigitado = lembreteDigitado;
        propertyChangeSupport.firePropertyChange("lembreteDigitado", oldLembreteDigitado, lembreteDigitado);
    }

    public Lembrete getLembreteSelecionado() {
        return lembreteSelecionado;
    }

    public void setLembreteSelecionado(Lembrete lembreteSelecionado) {

        this.lembreteSelecionado = lembreteSelecionado;
        if (this.lembreteSelecionado != null) {

            setLembreteDigitado(lembreteSelecionado);
        }
    }

    public List<Lembrete> getLembreteTabela() {
        return lembreteTabela;
    }

    public void setContatoTabela(List<Lembrete>lembreteTabela) {
        this.lembreteTabela = lembreteTabela;
    }
    
    public void addPropertyChangeListener (PropertyChangeListener e){
        
        propertyChangeSupport.addPropertyChangeListener(e);
    
     }
    
    public void removePropertyChangeListener (PropertyChangeListener e){
    
        propertyChangeSupport.removePropertyChangeListener(e);
    
    }

}

