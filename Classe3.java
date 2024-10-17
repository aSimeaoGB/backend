public class Classe3 {
    private static final String[] operadoresMatematicos = {"Soma", "Subtração", "Multiplicação", "Divisão"};

    public static String[] pegarOpcoes() {
        return operadoresMatematicos;
    }

    public static String processarDados(int intInputUsuario1, int intInputUsuario2, int opcaoEscolhida) {
        int resultado;
        switch (opcaoEscolhida) {
            case 0:
                resultado = somar(intInputUsuario1, intInputUsuario2);
                break;

            case 1:
                resultado = subtrair(intInputUsuario1, intInputUsuario2);
                break;
            
            case 2:
                resultado = multiplicar(intInputUsuario1, intInputUsuario2);
                break;

            case 3:
                resultado = dividir(intInputUsuario1, intInputUsuario2);
                break;

            default:
                resultado = 0;
                break;
        }
        return String.valueOf(resultado);
    }

    public static int somar(int numero1, int numero2) {
        return numero1 + numero2;
    }

    public static int subtrair(int numero1, int numero2) {
        return numero1 - numero2;
    }

    public static int multiplicar(int numero1, int numero2) {
        return numero1 * numero2;
    }

    public static int dividir(int numero1, int numero2) {
        return numero1 / numero2;
    }
}
