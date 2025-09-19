package Projeto;
import java.util.*;

public class Agenda {
    private List<Evento> eventos = new ArrayList<>();

    public Agenda() {
    }

    public void cadastrarEvento(Evento evento) {
        eventos.add(evento);
        System.out.println("Evento cadastrado: " + evento.getNomeEvento());
    }

    public Evento buscarEvento(String nomeEvento) {
        for (Evento evento : eventos) {
            if (evento.getNomeEvento().equalsIgnoreCase(nomeEvento)) return evento;
        }
    
        System.out.println("Evento não encontrado: " + nomeEvento);
        return null;
    }

    public void listarEventos() {
        System.out.println("Eventos na agenda:");
        for (Evento evento : eventos) {
            System.out.format("Evento:%s\n- Data:%s\n- Local:%s\n", evento.getNomeEvento(), evento.getData(), evento.getLocal());
        }
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }
}
