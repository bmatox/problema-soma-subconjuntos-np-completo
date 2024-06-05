import java.util.Scanner;

public class SomaSubconjuntoZero {
    private static int[] numeros;
    private static boolean[] subconjunto;
    private static boolean solucaoEncontrada = false;

    public static void encontrarSubconjuntoComSomaZero(int[] numerosEntrada) {
        numeros = numerosEntrada;
        subconjunto = new boolean[numeros.length];
        buscarSubconjunto(0, 0);
        if (!solucaoEncontrada) {
            System.out.println("Não foi possível encontrar um subconjunto com soma zero.");
        }
    }

    private static void buscarSubconjunto(int indice, int somaAtual) {
        if (indice == numeros.length) {
            if (somaAtual == 0 && subconjuntoNaoVazio()) {
                solucaoEncontrada = true;
                imprimirSubconjunto();
            }
            return;
        }

        // Incluir o número atual no subconjunto e continuar a busca
        subconjunto[indice] = true;
        buscarSubconjunto(indice + 1, somaAtual + numeros[indice]);

        // Não incluir o número atual no subconjunto e continuar a busca
        subconjunto[indice] = false;
        buscarSubconjunto(indice + 1, somaAtual);
    }

    private static boolean subconjuntoNaoVazio() {
        for (boolean incluido : subconjunto) {
            if (incluido) {
                return true;
            }
        }
        return false;
    }

    private static void imprimirSubconjunto() {
        System.out.print("Subconjunto com soma zero encontrado: ");
        for (int i = 0; i < numeros.length; i++) {
            if (subconjunto[i]) {
                System.out.print(numeros[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de números: ");
        int quantidade = scanner.nextInt();
        int[] numerosEntrada = new int[quantidade];

        System.out.print("Digite os números (positivos e negativos): ");
        for (int i = 0; i < quantidade; i++) {
            numerosEntrada[i] = scanner.nextInt();
        }

        encontrarSubconjuntoComSomaZero(numerosEntrada);
    }
}
