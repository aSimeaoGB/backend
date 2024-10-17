public class Classe2 {
    public static int calcularSoma(int numero1, int numero2) {
        return numero1 + numero2;
    }

    public static String[] mostrarOpcoes() {
        return Classe3.pegarOpcoes();
    }

    public static String resultado(int intInputUsuario1, int intInputUsuario2, int opcaoEscolhida) {
        return Classe3.processarDados(intInputUsuario1, intInputUsuario2, opcaoEscolhida);
    }

    public static String HelloWorld() {
        return "Olá mundo!";
    }

    public static String cumprimentar() {
        return "Olá! Bom Dia. Tudo bem?";
    }
}

