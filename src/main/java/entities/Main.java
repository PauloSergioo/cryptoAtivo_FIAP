package entities;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Usuario> usuarios = new ArrayList<>();
        List<Carteira> carteiras = new ArrayList<>();
        List<CryptoAtivo> criptoativos = new ArrayList<>();
        Map<String, CryptoAtivo> criptoMap = new HashMap<>();
        Map<String, Usuario> usuarioMap = new HashMap<>();

        Usuario investidor = new Investidor("1", "João", "joao@example.com", "exemplo123", "investidor", "junior");
        Usuario administrador = new Administrador("2", "Maria", "maria@example.com", "exemplo123", "administrador", "senior");
        usuarios.add(investidor);
        usuarios.add(administrador);

        usuarioMap.put(investidor.getIdUsuario(), investidor);
        usuarioMap.put(administrador.getIdUsuario(), administrador);

        Carteira carteiraInvestidor = new Carteira("1", 500.0, investidor);
        Carteira carteiraAdmin = new Carteira("2", 1000.0, administrador);
        carteiras.add(carteiraInvestidor);
        carteiras.add(carteiraAdmin);

        CryptoAtivo bitcoin = new CryptoAtivo("1", "Bitcoin", 3000.0, 0.01, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        CryptoAtivo ethereum = new CryptoAtivo("2", "Ethereum", 2000.0, 0.5, new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        criptoativos.add(bitcoin);
        criptoativos.add(ethereum);

        criptoMap.put(bitcoin.getIdCripto(), bitcoin);
        criptoMap.put(ethereum.getIdCripto(), ethereum);

        System.out.println("Usuários cadastrados:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println((i + 1) + " - " + usuarios.get(i).getNome());
        }

        Usuario usuario = null;
        while (usuario == null) {
            System.out.print("Escolha seu usuário (digite o número correspondente): ");
            int indiceUsuario = scanner.nextInt() - 1;
            if (indiceUsuario >= 0 && indiceUsuario < usuarios.size()) {
                usuario = usuarios.get(indiceUsuario);
                System.out.println("Usuário selecionado: " + usuario.getNome());
            } else {
                System.out.println("Usuário inválido. Tente novamente.");
            }
        }

        Carteira carteira = null;
        for (Carteira c : carteiras) {
            if (c.getUsuario().equals(usuario)) {
                carteira = c;
                break;
            }
        }

        if (carteira == null) {
            System.out.println("Nenhuma carteira encontrada para o usuário.");
            scanner.close();
            return;
        }

        int opcao;
        do {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Depositar na carteira");
            System.out.println("2 - Retirar da carteira");
            System.out.println("3 - Comprar criptoativo");
            System.out.println("4 - Vender criptoativo");
            System.out.println("5 - Exibir transações");
            System.out.println("6 - Exibir alertas");
            System.out.println("7 - Exportar dados para arquivo");
            System.out.println("8 - Carregar dados do arquivo");
            System.out.println("9 - Sair");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Saldo atual: R$ " + carteira.getSaldo());
                    System.out.print("Digite o valor para depósito: ");
                    double valorDeposito = scanner.nextDouble();
                    if (valorDeposito > 0) {
                        carteira.depositar(valorDeposito);
                        System.out.println("Depósito realizado. Saldo atual: R$ " + carteira.getSaldo());
                    } else {
                        System.out.println("Valor de depósito inválido.");
                    }
                    break;

                case 2:
                    System.out.println("Saldo atual: R$ " + carteira.getSaldo());
                    double valorRetirada = -1;
                    while (valorRetirada <= 0 || valorRetirada > carteira.getSaldo()) {
                        System.out.print("Digite o valor para retirada: ");
                        valorRetirada = scanner.nextDouble();
                        if (valorRetirada <= 0) {
                            System.out.println("Valor de retirada inválido. Tente novamente.");
                        } else if (valorRetirada > carteira.getSaldo()) {
                            System.out.println("Saldo insuficiente. Saldo atual: R$ " + carteira.getSaldo());
                        }
                    }
                    carteira.retirar(valorRetirada);
                    System.out.println("Retirada realizada. Saldo atual: R$ " + carteira.getSaldo());
                    break;

                case 3:
                    System.out.println("Escolha o criptoativo para compra:");
                    for (CryptoAtivo cripto : criptoativos) {
                        System.out.println(cripto.getNome() + " - Preço: R$ " + cripto.getValorAtual());
                    }
                    System.out.print("Digite o ID do criptoativo: ");
                    String idCompra = scanner.next();
                    CryptoAtivo criptoCompra = criptoMap.get(idCompra);
                    if (criptoCompra != null) {
                        System.out.print("Digite a quantidade a comprar: ");
                        double quantidadeCompra = scanner.nextDouble();
                        double valorTotalCompra = quantidadeCompra * criptoCompra.getValorAtual();
                        if (valorTotalCompra > carteira.getSaldo()) {
                            System.out.println("Saldo insuficiente.");
                        } else {
                            carteira.retirar(valorTotalCompra);
                            criptoCompra.adicionarQuantidade(quantidadeCompra);
                            System.out.println("Compra realizada!");
                        }
                    } else {
                        System.out.println("ID inválido.");
                    }
                    break;
                case 4:
                    System.out.println("Escolha o criptoativo para venda:");
                    boolean criptoDisponivelVenda = false;

                    for (int i = 0; i < criptoativos.size(); i++) {
                        CryptoAtivo cripto = criptoativos.get(i);
                        if (cripto.getQuantidade() > 0) {
                            System.out.println((i + 1) + " - " + cripto.getNome() + " (Disponível: " + cripto.getQuantidade() + ")");
                            criptoDisponivelVenda = true;
                        }
                    }

                    if (!criptoDisponivelVenda) {
                        System.out.println("Nenhum criptoativo disponível para venda.");
                    } else {
                        int escolhaCriptoVenda = scanner.nextInt() - 1;

                        if (escolhaCriptoVenda >= 0 && escolhaCriptoVenda < criptoativos.size() && criptoativos.get(escolhaCriptoVenda).getQuantidade() > 0) {
                            CryptoAtivo criptoVenda = criptoativos.get(escolhaCriptoVenda);
                            System.out.print("Digite a quantidade a vender: ");
                            double quantidadeVenda = scanner.nextDouble();

                            if (quantidadeVenda > criptoVenda.getQuantidade()) {
                                System.out.println("Quantidade inválida. Disponível: " + criptoVenda.getQuantidade());
                            } else {
                                double valorTotalVenda = quantidadeVenda * criptoVenda.getValorAtual();
                                carteira.depositar(valorTotalVenda);
                                criptoVenda.retirarQuantidade(quantidadeVenda);
                                Transacao venda = new Venda("V1", "Venda", quantidadeVenda, new Date(), usuario, criptoVenda, 5.0, carteira, valorTotalVenda);
                                carteira.adicionarTransacao(venda);
                                System.out.println("Venda realizada: " + quantidadeVenda + " " + criptoVenda.getNome());
                            }
                        } else {
                            System.out.println("Criptoativo inválido ou não disponível para venda.");
                        }
                    }
                    break;

                case 5:
                    if (carteira.getTransacoes().isEmpty()) {
                        System.out.println("Nenhuma transação registrada.");
                    } else {
                        System.out.println("Transações realizadas:");
                        for (Transacao transacao : carteira.getTransacoes()) {
                            System.out.println(" - " + transacao.getTipo() + " de " + transacao.getQuantidade() + " " + transacao.getCriptoativo().getNome() + " em " + transacao.getData());
                        }
                    }
                    break;

                case 6:
                    System.out.println("Alertas:");
                    Alerta alertaPreco = new AlertaPreco("A1", "Preço", "Bitcoin ultrapassou o limite", usuario, bitcoin, new Date(), bitcoin.getValorAtual());
                    Alerta alertaGeral = new AlertaGeral("A2", "Geral", "Manutenção programada", usuario, null, new Date(), "Sistema");
                    System.out.println(" - " + alertaPreco.getMensagem());
                    System.out.println(" - " + alertaGeral.getMensagem());
                    break;

                case 7:
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter("dados.txt"))) {
                        writer.write("Usuários:\n");
                        for (Usuario u : usuarios) {
                            writer.write(u.toString() + "\n");
                        }
                        writer.write("\nCriptoativos:\n");
                        for (CryptoAtivo c : criptoativos) {
                            writer.write(c.toString() + "\n");
                        }
                        System.out.println("Dados exportados para 'dados.txt'.");
                    } catch (IOException e) {
                        System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
                    }
                    break;

                case 8:
                    try (BufferedReader reader = new BufferedReader(new FileReader("dados.txt"))) {
                        String linha;
                        while ((linha = reader.readLine()) != null) {
                            System.out.println(linha);
                        }
                    } catch (IOException e) {
                        System.out.println("Erro ao carregar o arquivo: " + e.getMessage());
                    }
                    break;

                case 9:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 9);

        scanner.close();
    }
}