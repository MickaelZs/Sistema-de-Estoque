package sistema.de.estoque;

import java.util.Scanner;

class Produto {
    String nome;
    double preco;
    int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Preço: " + preco + ", Quantidade: " + quantidade;
    }
}

public class SistemaEstoque {

    // Vetor para armazenar os produtos
    static Produto[] produtos = new Produto[10]; // Tamanho do vetor inicial
    static int contadorProdutos = 0; // Para controlar a quantidade de produtos cadastrados

    // Método para o menu
    public static int menu() {
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
            scanner.nextLine(); // Consumir a quebra de linha
        } while (opcao < 1 || opcao > 5);
        
        return opcao;
    }
    
    // Método para autenticação
    public static boolean autenticar() {
        String usuarioFixo = "admin";
        String senhaFixo = "1234";
        
        System.out.print("Olá! Seja bem-vindo ao nosso estoque\n");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        
        return usuario.equals(usuarioFixo) && senha.equals(senhaFixo);
    }
    
    // Método para cadastrar produto
    public static void cadastrarProduto() {
        if (contadorProdutos >= produtos.length) {
            System.out.println("Não há espaço suficiente para cadastrar mais produtos.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Digite a quantidade do produto: ");
        int quantidade = scanner.nextInt();

        produtos[contadorProdutos] = new Produto(nome, preco, quantidade);
        contadorProdutos++;
        System.out.println("Produto cadastrado com sucesso!");
    }

    // Método para listar produtos
    public static void listarProdutos() {
        if (contadorProdutos == 0) {
            System.out.println("Não há produtos cadastrados.");
            return;
        }

        System.out.println("\n==== LISTA DE PRODUTOS ====");
        for (int i = 0; i < contadorProdutos; i++) {
            System.out.println((i + 1) + ". " + produtos[i]);
        }
    }

    // Método para atualizar produto
    public static void atualizarProduto() {
        listarProdutos();
        if (contadorProdutos == 0) return;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do produto que deseja atualizar: ");
        int indice = scanner.nextInt() - 1;
        
        if (indice < 0 || indice >= contadorProdutos) {
            System.out.println("Produto inválido!");
            return;
        }

        scanner.nextLine(); // Consumir a quebra de linha
        System.out.print("Digite o novo nome do produto: ");
        String novoNome = scanner.nextLine();
        System.out.print("Digite o novo preço do produto: ");
        double novoPreco = scanner.nextDouble();
        System.out.print("Digite a nova quantidade do produto: ");
        int novaQuantidade = scanner.nextInt();

        produtos[indice].nome = novoNome;
        produtos[indice].preco = novoPreco;
        produtos[indice].quantidade = novaQuantidade;
        
        System.out.println("Produto atualizado com sucesso!");
    }

    // Método para remover produto
    public static void removerProduto() {
        listarProdutos();
        if (contadorProdutos == 0) return;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número do produto que deseja remover: ");
        int indice = scanner.nextInt() - 1;

        if (indice < 0 || indice >= contadorProdutos) {
            System.out.println("Produto inválido!");
            return;
        }

        for (int i = indice; i < contadorProdutos - 1; i++) {
            produtos[i] = produtos[i + 1];
        }

        produtos[contadorProdutos - 1] = null;
        contadorProdutos--;
        
        System.out.println("Produto removido com sucesso!");
    }

    public static void main(String[] args) {
        boolean autenticador = autenticar();
        if (!autenticador) {
            System.out.println("Usuário ou senha incorretos!");
            return;
        }

        int opcao;
        do {
            opcao = menu();
            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    removerProduto();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
            }
        } while (opcao != 5);
    }
}
