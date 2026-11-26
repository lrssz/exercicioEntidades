package eventos.dominio;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Organizador org = new Organizador("Maria Silva", "Maria@IFBA.edu.br", "Extensão");
        Participante p1 = new Participante("João", "joao@email.com");
        Participante p2 = new Participante("Ana", "ana@email.com", true);
        Evento ev = new Evento("Semana de TI", LocalDate.of(2026, 12, 10), "Auditório", 100, org);

        System.out.println("== Organizador ==");
        System.out.println(org.getNome() + " | " + org.getEmail() + " | " + org.getSetor());

        System.out.println("== Participantes ==");
        System.out.println(p1.getNome() + " | " + p1.getEmail() + " | pagante: " + p1.isPagante());
        System.out.println(p2.getNome() + " | " + p2.getEmail() + " | pagante: " + p2.isPagante());

        System.out.println("== Evento ==");
        System.out.println(ev.getNome() + " | " + ev.getData() + " | " + ev.getLocal()
                + " | capacidade: " + ev.getCapacidade()
                + " | organizador: " + ev.getOrganizador().getNome());

        System.out.println("== Valores inválidos ==");
        try { org.setNome("   "); } catch (IllegalArgumentException e) { System.out.println("Organizador.setNome: " + e.getMessage()); }
        try { org.setEmail("sem-arroba"); } catch (IllegalArgumentException e) { System.out.println("Organizador.setEmail: " + e.getMessage()); }
        try { org.setSetor(null); } catch (IllegalArgumentException e) { System.out.println("Organizador.setSetor: " + e.getMessage()); }

        try { p1.setNome(""); } catch (IllegalArgumentException e) { System.out.println("Participante.setNome: " + e.getMessage()); }
        try { p1.setEmail("joao"); } catch (IllegalArgumentException e) { System.out.println("Participante.setEmail: " + e.getMessage()); }

        try { ev.setNome(""); } catch (IllegalArgumentException e) { System.out.println("Evento.setNome: " + e.getMessage()); }
        try { ev.setData(null); } catch (IllegalArgumentException e) { System.out.println("Evento.setData: " + e.getMessage()); }
        try { ev.setLocal(""); } catch (IllegalArgumentException e) { System.out.println("Evento.setLocal: " + e.getMessage()); }
        try { ev.setCapacidade(0); } catch (IllegalArgumentException e) { System.out.println("Evento.setCapacidade: " + e.getMessage()); }
        try { ev.setOrganizador(null); } catch (IllegalArgumentException e) { System.out.println("Evento.setOrganizador: " + e.getMessage()); }

        try { new Programacao(ev, "  ", LocalTime.of(14, 0), "Maria"); } catch (IllegalArgumentException e) { System.out.println("Programacao titulo: " + e.getMessage()); }
        try { new Programacao(ev, "Palestra", null, "Maria"); } catch (IllegalArgumentException e) { System.out.println("Programacao horario: " + e.getMessage()); }

        Programacao pr = new Programacao(ev, "Palestra", LocalTime.of(14, 0), "");
        System.out.println("Programacao responsavel (vazio vira): " + pr.getResponsavel());
    }
}