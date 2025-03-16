package com.criptoAtivos;

import com.criptoAtivos.dao.UsuarioDAO;
import com.criptoAtivos.entities.*;
import com.criptoAtivos.factory.ConnectionFactory;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Menu Usuário ===");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Listar Usuários");
            System.out.println("3. Buscar Usuário por CPF");
            System.out.println("4. Atualizar Usuário");
            System.out.println("5. Deletar Usuário");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarUsuario(usuarioDAO, scanner);
                    break;
                case 2:
                    listarUsuarios(usuarioDAO);
                    break;
                case 3:
                    buscarUsuarioPorCpf(usuarioDAO, scanner);
                    break;
                case 4:
                    atualizarUsuario(usuarioDAO, scanner);
                    break;
                case 5:
                    deletarUsuario(usuarioDAO, scanner);
                    break;
                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarUsuario(UsuarioDAO usuarioDAO, Scanner scanner) {
        System.out.println("\n=== Cadastrar Usuário ===");

        String cpf;
        while (true) {
            System.out.print("CPF: ");
            cpf = scanner.nextLine();

            cpf = cpf.replaceAll("[^0-9]", "");

            if (cpf.length() != 11) {
                System.out.println("Erro: O CPF deve ter exatamente 11 dígitos.");
                continue;
            }

            if (usuarioDAO.getByCpf(cpf) != null) {
                System.out.println("Erro: CPF já cadastrado.");
            } else {
                break;
            }
        }

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        String perfil;
        while (true) {
            System.out.println("\nEscolha o perfil do usuário:");
            System.out.println("1. Investidor conservador");
            System.out.println("2. Investidor de alto risco");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                perfil = "Investidor conservador";
                break;
            } else if (opcao.equals("2")) {
                perfil = "Investidor de alto risco";
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        String idUsuario = UUID.randomUUID().toString();

        Usuario usuario = new Usuario(idUsuario, cpf, nome, email, senha, perfil);
        usuarioDAO.insert(usuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void listarUsuarios(UsuarioDAO usuarioDAO) {
        System.out.println("\n=== Listar Usuários ===");
        List<Usuario> usuarios = usuarioDAO.getAll();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

    private static void buscarUsuarioPorCpf(UsuarioDAO usuarioDAO, Scanner scanner) {
        System.out.println("\n=== Buscar Usuário por CPF ===");

        String cpf;
        while (true) {
            System.out.print("Digite o CPF: ");
            cpf = scanner.nextLine();

            cpf = cpf.replaceAll("[^0-9]", "");

            if (cpf.length() != 11) {
                System.out.println("Erro: O CPF deve ter exatamente 11 dígitos.");
                continue;
            }

            Usuario usuario = usuarioDAO.getByCpf(cpf);
            if (usuario == null) {
                System.out.println("Erro: Usuário não encontrado.");
            } else {
                System.out.println("Usuário encontrado:");
                System.out.println(usuario);
                break;
            }
        }
    }

    private static void atualizarUsuario(UsuarioDAO usuarioDAO, Scanner scanner) {
        System.out.println("\n=== Atualizar Usuário ===");

        String cpf;
        Usuario usuario;
        while (true) {
            System.out.print("Digite o CPF do usuário que deseja atualizar: ");
            cpf = scanner.nextLine();

            cpf = cpf.replaceAll("[^0-9]", "");

            if (cpf.length() != 11) {
                System.out.println("Erro: O CPF deve ter exatamente 11 dígitos.");
                continue;
            }

            usuario = usuarioDAO.getByCpf(cpf);
            if (usuario == null) {
                System.out.println("Erro: Usuário não encontrado.");
            } else {
                break;
            }
        }

        System.out.print("Novo Nome (" + usuario.getNome() + "): ");
        String nome = scanner.nextLine();
        System.out.print("Novo Email (" + usuario.getEmail() + "): ");
        String email = scanner.nextLine();
        System.out.print("Nova Senha (" + usuario.getSenha() + "): ");
        String senha = scanner.nextLine();

        String perfil;
        while (true) {
            System.out.println("\nEscolha o perfil do usuário:");
            System.out.println("1. Investidor conservador");
            System.out.println("2. Investidor de alto risco");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                perfil = "Investidor conservador";
                break;
            } else if (opcao.equals("2")) {
                perfil = "Investidor de alto risco";
                break;
            } else {
                System.out.println("Opção inválida. Tente novamente.");
            }
        }

        usuario.setNome(nome.isEmpty() ? usuario.getNome() : nome);
        usuario.setEmail(email.isEmpty() ? usuario.getEmail() : email);
        usuario.setSenha(senha.isEmpty() ? usuario.getSenha() : senha);
        usuario.setPerfil(perfil);

        usuarioDAO.update(usuario);
        System.out.println("Usuário atualizado com sucesso!");
    }

    private static void deletarUsuario(UsuarioDAO usuarioDAO, Scanner scanner) {
        System.out.println("\n=== Deletar Usuário ===");

        String cpf;
        while (true) {
            System.out.print("Digite o CPF do usuário que deseja deletar: ");
            cpf = scanner.nextLine();

            cpf = cpf.replaceAll("[^0-9]", "");

            if (cpf.length() != 11) {
                System.out.println("Erro: O CPF deve ter exatamente 11 dígitos.");
                continue;
            }

            Usuario usuario = usuarioDAO.getByCpf(cpf);
            if (usuario == null) {
                System.out.println("Erro: Usuário não encontrado.");
            } else {
                usuarioDAO.delete(cpf);
                System.out.println("Usuário deletado com sucesso!");
                break;
            }
        }
    }
}
