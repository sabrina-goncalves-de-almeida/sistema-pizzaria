package dcx.ufpb.br;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String nome;
    private String cpf;
    private int conta;
    private String favorito;

    public Cliente(String nome) {
        this.nome =nome;
        this.cpf = "";
        this.conta = 0;
        this.favorito = "";
    }

    public Cliente(String nome, String cpf, int conta) {
        this.nome =nome;
        this.cpf = cpf;
        this.conta = conta;
        this.favorito = "";
    }

    public Cliente(String nome, String cpf, int conta, String favorito) {
        this.nome =nome;
        this.cpf = cpf;
        this.conta = conta;
        this.favorito = favorito;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getConta() {
        return this.conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public String getFavorito() {
        return this.favorito;
    }

    public void setFavorito(String favorito) {
        this.favorito = favorito;
    }

    @Override
    public String toString() {
        return "Cliente de nome: " + nome +
                ", de cpf: " + cpf +
                ", seu pedido favorito é: " + favorito + ".";
    }
}
