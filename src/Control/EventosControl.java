/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Dao.EventosDao;
import Model.Eventos;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author alunom
 */
public class EventosControl {

    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private Eventos eventosDigitado;
    private Eventos eventosSelecionado;
    private List<Eventos> eventosTabela;
    private final EventosDao eventosdao;

    public EventosControl() {

        eventosdao = new EventosDao();
        eventosTabela = ObservableCollections.observableList(new ArrayList<Eventos>());
        novo();
        pesquisar();
    }

    public void novo() {

        setEventosDigitado(new Eventos());

    }

    public void pesquisar() {

        eventosTabela.clear();
        eventosTabela.addAll(eventosdao.pesquisar(eventosDigitado));
    }

    public void salvar() {

        eventosdao.salvarAtualizar(eventosDigitado);
        novo();
        pesquisar();

    }

    public void excluir() {

        eventosdao.excluir(eventosDigitado);
        novo();
        pesquisar();
    }

    public Eventos getEventosDigitado() {
        return eventosDigitado;
    }

    public void setEventosDigitado(Eventos eventosDigitado) {
        Eventos oldEventosDigitado = this.eventosDigitado;
        this.eventosDigitado = eventosDigitado;
        propertyChangeSupport.firePropertyChange("eventosDigitado", oldEventosDigitado, eventosDigitado);
    }

    public Eventos getEventosSelecionado() {
        return eventosSelecionado;
    }

    public void setEventosSelecionado(Eventos eventosSelecionado) {

        this.eventosSelecionado = eventosSelecionado;
        if (this.eventosSelecionado != null) {

            setEventosSelecionado(eventosSelecionado);
        }
    }

    public List<Eventos> getEventosTabela() {
        return eventosTabela;
    }

    public void setContatoTabela(List<Eventos> eventosTabela) {
        this.eventosTabela = eventosTabela;
    }

    public void addPropertyChangeListener(PropertyChangeListener e) {

        propertyChangeSupport.addPropertyChangeListener(e);

    }

    public void removePropertyChangeListener(PropertyChangeListener e) {

        propertyChangeSupport.removePropertyChangeListener(e);

    }

}
