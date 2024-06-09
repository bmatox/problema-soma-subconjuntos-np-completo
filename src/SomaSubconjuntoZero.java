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
        for (int i = 0; i < subconjunto.length; i++) {
            if (subconjunto[i]) {
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

/*COMENTÁRIO: Este código Java implementa um algoritmo para encontrar um subconjunto de números que somam zero.
Ele utiliza uma abordagem de backtracking, que é um paradigma algorítmico para resolver problemas recursivamente,
tentando construir uma solução de maneira incremental, removendo soluções que falham em satisfazer as restrições
do problema em qualquer ponto do tempo. No contexto deste código, o backtracking é usado para explorar todas as
combinações possíveis de números para encontrar um subconjunto cuja soma é zero. Se tal subconjunto for encontrado,
ele é impresso; caso contrário, uma mensagem é exibida indicando que não foi possível encontrar um subconjunto com
soma zero. Espero que isso ajude a entender a lógica por trás dos métodos!*/
