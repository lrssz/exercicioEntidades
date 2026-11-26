package eventos.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Evento {
    private Long id;
    private String nome;
    private LocalDate data;
    private String local;
    private int capacidade;
    private Organizador organizador;
    private List<Programacao> programacao = new ArrayList<>();
    private Set<Participante> participantes = new HashSet<>();

    protected Evento() {
    }
    
    public Evento(String nome, LocalDate data, String local, int capacidade, Organizador organizador) {
        setNome(nome);
        setData(data);
        setLocal(local);
        setCapacidade(capacidade);
        setOrganizador(organizador);
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = obrigatorio(nome, "nome", 120);
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        if (data == null) {
            throw new IllegalArgumentException("data não pode ser nula");
        }
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = obrigatorio(local, "local", 80);
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        if (capacidade <= 0) {
            throw new IllegalArgumentException("capacidade deve ser maior que zero");
        }
        this.capacidade = capacidade;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        if (organizador == null) {
            throw new IllegalArgumentException("organizador não pode ser nulo");
        }
        this.organizador = organizador;
    }

    public List<Programacao> getProgramacao() {
        return new ArrayList<>(programacao);
    }

    public List<Participante> getParticipantes() {
        return new ArrayList<>(participantes);
    }

    private static String obrigatorio(String valor, String campo, int max) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException(campo + " é obrigatório");
        }
        String limpo = valor.strip();
        if (limpo.length() > max) {
            throw new IllegalArgumentException(campo + " deve ter no máximo " + max + " caracteres");
        }
        return limpo;
    }

}
