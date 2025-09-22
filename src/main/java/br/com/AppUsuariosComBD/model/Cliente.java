package br.com.AppUsuariosComBD.model;

public class Cliente extends Usuario implements Autenticacao {

    // Método construtor
    public Cliente(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    // Método abstrato
    @Override
    public void showInfo() {
        System.out.printf("[Cliente] - Nome: %s | E-mail: %s", getNome(), getEmail());
    }

    // Método interface
    @Override
    public boolean autenticar(String senhaDigitada){
        return this.senha.equals(senhaDigitada);
    }
}
