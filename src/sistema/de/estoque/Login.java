
package sistema.de.estoque;
import java.util.Scanner;

public class Login {
    static String usuarioFixo = "admin";
    static String senhaFixo = "1234";

    public static boolean autenticar() {
        
        System.out.print("Olá! Seja bem-vindo ao nosso estoque\n");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Usuário: ");
        String usuario = scanner.nextLine().intern();

        System.out.print("Senha: ");
        String senha = scanner.nextLine().intern();

        return usuario ==  usuarioFixo && senha == senhaFixo;
    }
    
}
