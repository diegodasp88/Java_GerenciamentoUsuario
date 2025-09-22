package br.com.AppUsuariosComBD.app;

import br.com.AppUsuariosComBD.dao.UsuarioDAO;
import br.com.AppUsuariosComBD.model.Admin;
import br.com.AppUsuariosComBD.model.Cliente;
import br.com.AppUsuariosComBD.model.Usuario;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Criando uma lista de usuários
        ArrayList<Usuario> usuarios = new ArrayList<>();

        // Criando usuarios
        Cliente cliente1 = new Cliente("Diego", "diego@email.com", "12345");
        Admin admin1 = new Admin("Samuel", "samuel@empresa.com", "admin123");

        // Instanciar UsuarioDAO
        UsuarioDAO dao = new UsuarioDAO();

        // Adicionando os usuários criados
        usuarios.add(cliente1);
        usuarios.add(admin1);

        dao.atualizarUsuario();

    }
}