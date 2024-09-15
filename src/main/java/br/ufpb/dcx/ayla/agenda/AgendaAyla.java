package br.ufpb.dcx.ayla.agenda;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class AgendaAyla implements Agenda {

    private HashMap<String, Contato> contatos;
    private GravadorDeDados gravador;

    public AgendaAyla(){
        this.contatos = new HashMap<>();
        this.gravador = new GravadorDeDados();
    }

    @Override
    public boolean cadastraContato(String nome, int dia, int mes) {
        if (this.contatos.containsKey(nome)) {
            return false; // Contato já existe
        }
        Contato novoContato = new Contato(nome, dia, mes);
        this.contatos.put(nome, novoContato);
        return true;
    }

    @Override
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes) {
        return this.contatos.values().stream()
                .filter(contato -> contato.getDiaAniversario() == dia && contato.getMesAniversario() == mes)
                .collect(Collectors.toList());
    }

    @Override
    public boolean removeContato(String nome) throws ContatoInexistenteException {
        if (!this.contatos.containsKey(nome)) {
            throw new ContatoInexistenteException(); // Contato não encontrado
        }
        this.contatos.remove(nome);
        return true;
    }

    @Override
    public void salvarDados() throws IOException {
        gravador.salvarContatos(this.contatos);
    }

    @Override
    public void recuperarDados() throws IOException {
        this.contatos = gravador.recuperarContatos();
    }
}