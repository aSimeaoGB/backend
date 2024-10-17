import java.util.*;

public class Classe1 {
    public static void main(String[] args) {
        Scanner scnInputUsuario = new Scanner(System.in); // serve para criar o imput de entrada, via terminal.
        System.out.println("Olá! Bem vindo a calculadora de Java. Digite o primeiro número a ser calculado e tecle: \"Enter\"");
        int intInputUsuario1 = scnInputUsuario.nextInt();// serve para que o usuario digite algo no terminal.
        System.out.println("Digite o segundo número a ser calculado e tecle: \"Enter\"");
        int intInputUsuario2 = scnInputUsuario.nextInt();
        System.out.println("Digite o número da opção desejada e tecle: \"Enter\"");
        String[] opcoes = Classe2.mostrarOpcoes();
        
        for (int count = 0; count < opcoes.length; count++) {
            System.out.println(count + " - " + opcoes[count]);
        }

        int opcaoEscolhida = scnInputUsuario.nextInt();

        System.out.println("o rsultado da " + opcoes[opcaoEscolhida] + " é: " + Classe2.resultado(intInputUsuario1, intInputUsuario2, opcaoEscolhida));
        scnInputUsuario.close();
    }      
}