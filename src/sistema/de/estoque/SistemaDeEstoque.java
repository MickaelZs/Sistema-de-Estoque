
package sistema.de.estoque;
import java.util.Scanner;

public class SistemaDeEstoque {

    public static void main(String[] args) {
     if (!Login.autenticar()) {
            System.out.println("Acesso negado.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n==== MENU ESTOQUE SUPERMERCADO ====");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Atualizar Produto");
            System.out.println("4 - Remover Produto");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            
        } while (opcao <= 1 || opcao > 5);
       
    }
    }


