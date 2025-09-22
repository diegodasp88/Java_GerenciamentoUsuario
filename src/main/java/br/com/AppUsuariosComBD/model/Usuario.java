package br.com.AppUsuariosComBD.model;

public abstract class Usuario {

    // Atributos
    protected String nome;
    protected String email;
    protected String senha;

    // Método construtor
    public Usuario(String nome, String email, String senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    // Getters
    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }

    // Setters
    public void setSenha(String senha) { this.senha = senha; }

    // Método abstrato de mostrar informações
    public abstract void showInfo();

}