package br.com.AppUsuariosComBD.model;

public class Admin extends Usuario implements Autenticacao {

    // Método construtor
    public Admin(String nome, String email, String senha) {
        super(nome, email, senha);
    }

    // Método abstrato
    public void showInfo(){
        System.out.printf("[Admin] - Nome: %s | E-mail: %s", getNome(), getEmail());
    }

    // Método interface
    public boolean autenticar(String senhaDigitada) {
        return this.senha.equals(senhaDigitada);
    }
}
