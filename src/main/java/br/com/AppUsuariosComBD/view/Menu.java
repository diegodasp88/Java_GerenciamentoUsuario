package br.com.AppUsuariosComBD.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    public static String atualizarUsuario() {
        Scanner sc = new Scanner(System.in);
        String coluna; // declarando variável coluna

        while (true) {
            System.out.println("---- Campo a ser alterado ----");
            System.out.println("[1] Nome");
            System.out.println("[2] E-mail");
            System.out.println("[3] Senha");
            System.out.print("Escolha uma opção: ");
            int opcao;

            try {
                opcao = sc.nextInt(); // usuário escolhe uma opção no menu
                sc.nextLine(); // limpar o buffer
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Você deve inserir um número: ");
                sc.nextLine(); // limpar o buffer
                continue;
            }

            switch (opcao) {
                case 1:
                    coluna = "nome";
                    System.out.println("------------------------------");
                    System.out.print("Insira o novo nome: ");
                    break;
                case 2:
                    coluna = "email";
                    System.out.println("------------------------------");
                    System.out.print("Insira o novo e-mail: ");
                    break;
                case 3:
                    coluna = "senha";
                    System.out.println("------------------------------");
                    System.out.print("Insira a nova senha: ");
                    break;
                default:
                    System.out.println("Valor inválido!");
                    continue;
            }

            break; // sair do loop
        }

        return coluna;
    }

}
