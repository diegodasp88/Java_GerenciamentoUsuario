package br.com.AppUsuariosComBD.dao;

import br.com.AppUsuariosComBD.model.Cliente;
import br.com.AppUsuariosComBD.model.Usuario;
import br.com.AppUsuariosComBD.view.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UsuarioDAO {

    Scanner sc = new Scanner(System.in);

    public void inserirUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nome, email, senha, tipo) VALUES (?, ?, ?, ?)";

        try (Connection conexao = ConexaoBD.conectarBD();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());

            // Definir valor para a coluna tipo
            String tipo = (usuario instanceof Cliente) ? "CLIENTE" : "ADMIN";
            ps.setString(4, tipo);

            // Executar o comando
            ps.executeUpdate();
            System.out.println("Usuário inserido com sucesso!");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarUsuarios() {
        String sql = "SELECT * FROM usuarios";

        try (Connection conexao = ConexaoBD.conectarBD();
             PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.printf("ID: %d | Nome: %s \n", rs.getInt("id"), rs.getString("nome"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listarUsuarioPorID(int id) {
        String sql = "SELECT * FROM usuarios WHERE id = ?";

        try (Connection conexao = ConexaoBD.conectarBD();
             PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    System.out.println("Usuário encontrado:");
                    System.out.printf("ID: %d | Nome: %s | E-mail: %s \n", rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
                } else {
                    System.out.println("Usuário não encontrado!");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarUsuario() {
        System.out.print("ID do usuário: ");
        int id = sc.nextInt(); sc.nextLine(); // usuario inserir o id
        System.out.println("------------------------------");

        listarUsuarioPorID(id); // listar usuário pelo ID
        System.out.println("------------------------------");

        String coluna = Menu.atualizarUsuario(); // menu de atualização do usuário

        String novoValor = sc.nextLine(); // usuário inserir o novo valor para o campo
        System.out.println("------------------------------");

        String sql = "UPDATE usuarios SET " + coluna + " = ? WHERE id = ?";

        try (Connection conexao = ConexaoBD.conectarBD();
             PreparedStatement ps = conexao.prepareStatement(sql)) {

            ps.setString(1, novoValor);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Atualização bem-sucedida!");
            System.out.println("------------------------------");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletarUsuario() {
        System.out.print("ID do usuário: ");
        int id = sc.nextInt(); sc.nextLine(); // usuario inserir o id
        System.out.println("------------------------------");

        listarUsuarioPorID(id); // listar usuário pelo ID
        System.out.println("------------------------------");

        System.out.println("Deseja realmente excluir esse usuário? (s/n)");
        String confirmar = sc.nextLine();

        if(confirmar.equalsIgnoreCase("s")) {
            String sql = "DELETE FROM usuarios WHERE id = ?";

            try (Connection conexao = ConexaoBD.conectarBD();
                 PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setInt(1, id);

                try (ResultSet rs = ps.executeQuery()) {

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

}
