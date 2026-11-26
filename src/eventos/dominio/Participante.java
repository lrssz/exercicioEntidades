package eventos.dominio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class Participante {
    private Long id;
    private String nome;
    private String email;
    private boolean pagante;
    private Set<Evento> eventos = new HashSet<>();

    protected Participante() {
    }

    public Participante(String nome, String email) {
        this(nome, email, false);
    }

    public Participante(String nome, String email, boolean pagante) {
        setNome(nome);
        setEmail(email);
        setPagante(pagante);
    }

    public boolean isPagante(){
        return pagante;
    }

    public Long getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = obrigatorio(nome, "nome", 100);;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String valor = obrigatorio(email, "email", 120);
        if (!valor.matches("[^@\\s]+@[^@\\s]+")) {
            throw new IllegalArgumentException("email deve ter o formato nome@dominio");
        }
        this.email = valor.toLowerCase();
    }

    public void setPagante(boolean pagante) {
        this.pagante = pagante;
    }

    public List<Evento> getEventos() {
        return new ArrayList<>(eventos);
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
