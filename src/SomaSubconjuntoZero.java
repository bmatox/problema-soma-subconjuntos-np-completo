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

// pseudocódigo

/*
procedimento EncontrarSubconjuntoComSomaZero(numerosEntrada : inteiros)
1.  numeros := numerosEntrada
2.  subconjunto := novo array booleano[numeros.length]
3.  solucaoEncontrada := falso
4.  buscarSubconjunto(0, 0)
5.  se (!solucaoEncontrada)
6.      print "Não foi possível encontrar um subconjunto com soma zero."

procedimento buscarSubconjunto(indice : inteiro, somaAtual : inteiro)
7.  se (indice = numeros.length)
8.      se (somaAtual = 0 e subconjuntoNaoVazio())
9.          solucaoEncontrada := verdadeiro
10.         imprimirSubconjunto()
11.     retorne
12. subconjunto[indice] := verdadeiro
13. buscarSubconjunto(indice + 1, somaAtual + numeros[indice])
14. subconjunto[indice] := falso
15. buscarSubconjunto(indice + 1, somaAtual)

função subconjuntoNaoVazio() : booleano
16. para i ← 0 até subconjunto.length - 1
17.     se (subconjunto[i])
18.         retorne verdadeiro
19. retorne falso

procedimento imprimirSubconjunto()
20. print "Subconjunto com soma zero encontrado: "
21. para i ← 0 até numeros.length - 1
22.     se (subconjunto[i])
23.         print numeros[i] + " "
24. print "\n"

procedimento main()
25. iniciar o programa
26. print "Digite a quantidade de números: "
27. quantidade := ler número inteiro
28. numerosEntrada := novo array int[quantidade]
29. print "Digite os números (positivos e negativos): "
30. para i ← 0 até quantidade - 1
31.     numerosEntrada[i] := ler número inteiro
32. EncontrarSubconjuntoComSomaZero(numerosEntrada)

    */