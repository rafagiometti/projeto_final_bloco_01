package projeto_final_bloco_01;

import java.io.IOException;
import java.util.Scanner;
import projeto_final_bloco_01.util.Cores;

public class Menu {
    public static void main(String[] args) {

        Scanner leia = new Scanner(System.in);
        int opcao;

        while (true) {

            System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
                    + "*****************************************************");
            System.out.println("                                                     ");
            System.out.println("              PETSHOP FAZENDA DAS PATINHAS           ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("                                                     ");
            System.out.println("            1 - Adicionar Produto                    ");
            System.out.println("            2 - Listar todos os Produtos             ");
            System.out.println("            3 - Consultar Produto por ID             ");
            System.out.println("            4 - Atualizar Produto                    ");
            System.out.println("            5 - Remover Produto                      ");
            System.out.println("            6 - Comprar Produto                      ");
            System.out.println("            7 - Sair                                 ");
            System.out.println("                                                     ");
            System.out.println("*****************************************************");
            System.out.println("Entre com a opção desejada:                          ");
            System.out.println("                                                     " + Cores.TEXT_RESET);

            
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
                    System.out.println(Cores.TEXT_WHITE + "Adicionar Produto\n\n");
                    keyPress();
                    break;
                case 2:
                    System.out.println(Cores.TEXT_WHITE + "Listar todos os Produtos\n\n");
                    keyPress();
                    break;
                case 3:
                    System.out.println(Cores.TEXT_WHITE + "Consultar Produto por ID\n\n");
                    keyPress();
                    break;
                case 4:
                    System.out.println(Cores.TEXT_WHITE + "Atualizar Produto\n\n");
                    keyPress();
                    break;
                case 5:
                    System.out.println(Cores.TEXT_WHITE + "Remover Produto\n\n");
                    keyPress();
                    break;
                case 6:
                    System.out.println(Cores.TEXT_WHITE + "Comprar Produto\n\n");
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

