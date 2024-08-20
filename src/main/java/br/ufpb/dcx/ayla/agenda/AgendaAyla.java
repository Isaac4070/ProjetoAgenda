package br.ufpb.dcx.ayla.agenda;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

public class AgendaAyla implements Agenda {

    private HashMap<String, Contato> contatos;
    private GravadorDeDados gravador;

    public AgendaAyla(){
        this.contatos = new HashMap<>();
        this.gravador = new GravadorDeDados();
    }


    @Override
    public boolean cadastraContato(String nome, int dia, int mes) {
        return false;
    }

    @Override
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes) {
        return null;
    }

    @Override
    public boolean removeContato(String nome) throws ContatoInexistenteException {
        return false;
    }

    @Override
    public void salvarDados() throws IOException {

    }

    @Override
    public void recuperarDados() throws IOException {

    }
}
