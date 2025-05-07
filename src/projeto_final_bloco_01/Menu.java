package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Scanner;

import projeto_final_bloco_01.controller.ProdutoController;
import projeto_final_bloco_01.model.Brinquedo;
import projeto_final_bloco_01.model.Produto;
import projeto_final_bloco_01.model.Racao;
import projeto_final_bloco_01.util.Cores;

public class Menu {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int opcao, estoque, id, tipo;
        float preco;
        String tipoAnimal, material, nome;

        ProdutoController produtos = new ProdutoController();

        Racao r1 = new Racao(produtos.gerarId(), "Golden 10kg", 130f, 5, "Cachorro");
        produtos.adicionarProduto(r1);
        r1.visualizar();

        Brinquedo b1 = new Brinquedo(produtos.gerarId(), "Bolinha de duas cores", 14.99f, 9, "Plástico");
        produtos.adicionarProduto(b1);
        b1.visualizar();

        while (true) {
            System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
                    + "*****************************************************");
            System.out.println("              PETSHOP FAZENDA DAS PATINHAS           ");
            System.out.println("*****************************************************");
            System.out.println("            1 - Adicionar Produto                    ");
            System.out.println("            2 - Listar todos os Produtos             ");
            System.out.println("            3 - Consultar Produto por ID             ");
            System.out.println("            4 - Atualizar Produto                    ");
            System.out.println("            5 - Remover Produto                      ");
            System.out.println("            6 - Comprar Produto                      ");
            System.out.println("            7 - Sair                                 ");
            System.out.println("*****************************************************");
            System.out.println("              Entre com a opção desejada:            ");
            System.out.println(Cores.TEXT_RESET);

            while (!leia.hasNextInt()) {
                System.out.println(Cores.TEXT_RED_BOLD + "\nPor favor, insira um número válido!" + Cores.TEXT_RESET);
                leia.next();
            }
            opcao = leia.nextInt();

            if (opcao == 7) {
                System.out.println(Cores.TEXT_WHITE_BOLD + "\nObrigado por visitar o Petshop Fazenda das Patinhas!");
                sobre();
                leia.close();
                System.exit(0);
            }

            switch (opcao) {
                case 1:
                    System.out.println(Cores.TEXT_WHITE + "Adicionar Produto\n");

                    do {
                        System.out.print("Informe o tipo de produto (1 - Ração | 2 - Brinquedo): ");
                        tipo = leia.nextInt();
                        if (tipo != 1 && tipo != 2) {
                            System.out.println(Cores.TEXT_RED_BOLD + "Por favor, insira 1 para Ração ou 2 para Brinquedo!" + Cores.TEXT_RESET);
                        }
                    } while (tipo != 1 && tipo != 2);

                    leia.nextLine();

                    System.out.print("Nome do produto: ");
                    nome = leia.nextLine();

                    do {
                        System.out.print("Preço: ");
                        preco = leia.nextFloat();
                        if (preco <= 0) {
                            System.out.println(Cores.TEXT_RED_BOLD + "Preço inválido! O preço deve ser maior que 0." + Cores.TEXT_RESET);
                        }
                    } while (preco <= 0);

                    do {
                        System.out.print("Estoque: ");
                        estoque = leia.nextInt();
                        if (estoque <= 0) {
                            System.out.println(Cores.TEXT_RED_BOLD + "Estoque inválido! O estoque deve ser maior que 0." + Cores.TEXT_RESET);
                        }
                    } while (estoque <= 0);
                    leia.nextLine();

                    if (tipo == 1) {
                        System.out.print("Tipo de animal (ex: cachorro, gato): ");
                        tipoAnimal = leia.nextLine();

                        Racao novaRacao = new Racao(produtos.gerarId(), nome, preco, estoque, tipoAnimal);
                        produtos.adicionarProduto(novaRacao);
                    } else if (tipo == 2) {
                        System.out.print("Material do brinquedo: ");
                        material = leia.nextLine();

                        Brinquedo novoBrinquedo = new Brinquedo(produtos.gerarId(), nome, preco, estoque, material);
                        produtos.adicionarProduto(novoBrinquedo);
                    }

                    keyPress();
                    break;

                case 2:
                    System.out.println(Cores.TEXT_WHITE + "Listar todos os Produtos\n");
                    produtos.listarProdutos();
                    keyPress();
                    break;

                case 3:
                    System.out.println(Cores.TEXT_WHITE + "Consultar Produto por ID\n");

                    System.out.print("Informe o ID do produto: ");
                    id = leia.nextInt();

                    Produto produto = produtos.consultarProdutoPorId(id);

                    if (produto == null) {
                        System.out.println(Cores.TEXT_RED_BOLD + "Produto não encontrado!" + Cores.TEXT_RESET);
                    } else {
                        produto.visualizar();
                    }

                    keyPress();
                    break;

                case 4:
                    System.out.println(Cores.TEXT_WHITE + "Atualizar Produto\n");

                    System.out.print("Informe o ID do produto para atualização: ");
                    id = leia.nextInt();

                    Produto produtoAtualizar = produtos.consultarProdutoPorId(id);

                    if (produtoAtualizar == null) {
                        System.out.println(Cores.TEXT_RED_BOLD + "Produto não encontrado!" + Cores.TEXT_RESET);
                    } else {
                        System.out.print("Novo preço: ");
                        preco = leia.nextFloat();

                        System.out.print("Novo estoque: ");
                        estoque = leia.nextInt();

                        produtoAtualizar.setPreco(preco);
                        produtoAtualizar.setEstoque(estoque);

                        System.out.println("Produto atualizado com sucesso!");
                        produtoAtualizar.visualizar();
                    }

                    keyPress();
                    break;

                case 5:
                    System.out.println(Cores.TEXT_WHITE + "Remover Produto\n");

                    System.out.print("Informe o ID do produto a ser removido: ");
                    id = leia.nextInt();

                    Produto produtoRemover = produtos.consultarProdutoPorId(id);

                    if (produtoRemover == null) {
                        System.out.println(Cores.TEXT_RED_BOLD + "Produto não encontrado!" + Cores.TEXT_RESET);
                    } else {
                        System.out.print("Tem certeza que deseja remover este produto? (S/N): ");
                        leia.nextLine();
                        String confirmacao = leia.nextLine();

                        if (confirmacao.equalsIgnoreCase("S")) {
                            produtos.removerProduto(id);
                            System.out.println("Produto removido com sucesso!");
                        } else {
                            System.out.println("Operação cancelada.");
                        }
                    }

                    keyPress();
                    break;

                case 6:
                    System.out.println(Cores.TEXT_WHITE + "Comprar Produto\n");

                    System.out.print("Informe o ID do produto que deseja comprar: ");
                    id = leia.nextInt();

                    Produto produtoComprar = produtos.consultarProdutoPorId(id);

                    if (produtoComprar == null) {
                        System.out.println(Cores.TEXT_RED_BOLD + "Produto não encontrado!" + Cores.TEXT_RESET);
                    } else {
                        System.out.print("Quantidade desejada: ");
                        int quantidade = leia.nextInt();

                        if (quantidade > produtoComprar.getEstoque()) {
                            System.out.println(Cores.TEXT_RED_BOLD + "Estoque insuficiente!" + Cores.TEXT_RESET);
                        } else {
                            produtoComprar.setEstoque(produtoComprar.getEstoque() - quantidade);
                            System.out.println("Compra realizada com sucesso! Total: R$" + (produtoComprar.getPreco() * quantidade));
                            produtoComprar.visualizar();
                        }
                    }

                    keyPress();
                    break;

                default:
                    System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida! Tente novamente." + Cores.TEXT_RESET);
                    keyPress();
                    break;
            }
        }
    }

    public static void keyPress() {
        try {
            System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar...");
            System.in.read();
        } catch (IOException e) {
            System.err.println("Erro ao tentar ler do teclado.");
        }
    }

    public static void sobre() {
        System.out.println("\n*********************************************************");
        System.out.println("Projeto desenvolvido por: ");
        System.out.println("Rafaela - github.com/rafagiometti");
        System.out.println("*********************************************************");
    }
}
