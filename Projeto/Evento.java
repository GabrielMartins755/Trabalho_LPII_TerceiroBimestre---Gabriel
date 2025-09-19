package Projeto;
import java.time.LocalDateTime;

public class Evento {
    private LocalDateTime data;
    private String local;
    private String nomeEvento;
    private int qtdMaxPessoas;
    
    public Evento() {
    }
    public int getQtdMaxPessoas() {
        return qtdMaxPessoas;
    }
    public void setQtdMaxPessoas(int qtdMaxPessoas) {
        this.qtdMaxPessoas = qtdMaxPessoas;
    }
    public String getNomeEvento() {
        return nomeEvento;
    }
    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }
    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
}