import java.util.Scanner;

public class SomaSubconjuntoZero {
    private static int[] numeros; // Array para armazenar os números de entrada
    private static boolean[] subconjunto; // Array para armazenar se um número está no subconjunto ou não
    private static boolean solucaoEncontrada = false; // Variável para indicar se uma solução foi encontrada ou não

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

    public static void encontrarSubconjuntoComSomaZero(int[] numerosEntrada) {
        numeros = numerosEntrada;
        subconjunto = new boolean[numeros.length]; // Inicializa o array de subconjunto com o mesmo tamanho que o array de números
        buscarSubconjunto(0, 0);
        if (!solucaoEncontrada) { // Se nenhuma solução foi encontrada, exibe uma mensagem
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
        // Recursão para o próximo índice com a soma atualizada com o número atual
        buscarSubconjunto(indice + 1, somaAtual + numeros[indice]);

        // Não incluir o número atual no subconjunto e continuar a busca
        subconjunto[indice] = false;
        // Recursão para o próximo índice com a soma atualizada sem o número atual.
        // Isso é importante porque pode haver mais de um subconjunto com soma zero no conjunto de números.
        buscarSubconjunto(indice + 1, somaAtual);
    }

    // Verifica se o subconjunto não está vazio
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
}

/*

O código implementa um algoritmo para encontrar um subconjunto de números que somam zero.
Ele utiliza uma abordagem de backtracking, que é um paradigma algorítmico para resolver problemas recursivamente,
tentando construir uma solução de maneira incremental, removendo soluções que falham em satisfazer as restrições
do problema em qualquer ponto do tempo. No contexto deste código, o backtracking é usado para explorar todas as
combinações possíveis de números para encontrar um subconjunto cuja soma é zero. Se tal subconjunto for encontrado,
ele é impresso; caso contrário, uma mensagem é exibida indicando que não foi possível encontrar um subconjunto com
soma zero.

No código SomaSubconjuntoZero.java, o backtracking é usado para encontrar um subconjunto de números que somam zero.
O algoritmo tenta incluir cada número no subconjunto (primeira chamada recursiva em buscarSubconjunto()) e também
explora a possibilidade de não incluir o número (segunda chamada recursiva em buscarSubconjunto()).  Se a soma do
subconjunto for zero, o subconjunto é impresso. Se não, o algoritmo "volta atrás" (daí o termo "backtracking") e
tenta uma combinação diferente, excluindo o número atual do subconjunto.  O backtracking é evidente na maneira
como o algoritmo explora todas as combinações possíveis de inclusão e exclusão de números, e como ele "volta atrás"
se uma combinação particular não leva a uma solução. Isso é feito através das chamadas recursivas em buscarSubconjunto(),
que permitem ao algoritmo explorar todas as possibilidades e encontrar todas as soluções possíveis.

*/
