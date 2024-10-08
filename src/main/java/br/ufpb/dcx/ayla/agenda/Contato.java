package br.ufpb.dcx.ayla.agenda;

import java.io.Serializable;
import java.util.Objects;

public class Contato implements Serializable {
    private String nome; //ayla
    private int diaAniversario;
    private int mesAniversario;


    public Contato(String nome, int dia, int mes) {
        this.nome = nome;
        this.diaAniversario = dia;
        this.mesAniversario = mes;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDiaAniversario() {
        return diaAniversario;
    }

    public void setDiaAniversario(int diaAniversario) {
        this.diaAniversario = diaAniversario;
    }

    public int getMesAniversario() {
        return mesAniversario;
    }

    public void setMesAniversario(int mesAniversario) {
        this.mesAniversario = mesAniversario;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contato contato)) return false;
        return diaAniversario == contato.diaAniversario && mesAniversario == contato.mesAniversario && Objects.equals(nome, contato.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, diaAniversario, mesAniversario);
    }

    @Override
    public String toString() {
        return "Contato de nome "
                + nome +
                ", que aniversaria em " + diaAniversario +
                "/" + mesAniversario;

    }
}

