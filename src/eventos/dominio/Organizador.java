package eventos.dominio;

public class Organizador {
    private Long id;
    private String nome;
    private String email;
    private String setor;

    protected Organizador() {
    }

    public Organizador(String nome, String email, String setor) {
        setNome(nome);
        setEmail(email);
        setSetor(setor);
    }


    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;    
    }

    public void setNome(String nome) {
        this.nome = obrigatorio(nome, "nome", 100);
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

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = obrigatorio(setor, "setor", 100);
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
