package eventos.dominio;

import java.time.LocalTime;

public class Programacao {
    private Long id;
    private String titulo;
    private LocalTime horario; 
    private String responsavel;
    private Evento evento;

    protected Programacao() {
    }
    
    Programacao(Evento evento, String titulo, LocalTime horario, String responsavel) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("titulo é obrigatório");
        }
        String t = titulo.strip();
        if (t.length() > 120) {
            throw new IllegalArgumentException("titulo deve ter no máximo 120 caracteres");
        }
        if (horario == null) {
            throw new IllegalArgumentException("horario não pode ser nulo");
        }
        this.evento = evento;
        this.titulo = t;
        this.horario = horario;
        this.responsavel = (responsavel == null || responsavel.isBlank())
                ? "a definir"
                : responsavel.strip();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public Evento getEvento() {
        return evento;
    }
    
}
