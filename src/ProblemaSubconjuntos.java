/* import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemaSubconjuntos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite os números separados por espaço: ");
        String entrada = scanner.nextLine();
        scanner.close();

        SolucionadorSomaSubconjuntos solucionador = new SolucionadorSomaSubconjuntos(entrada);
        List<List<Integer>> subconjuntosComSomaZero = solucionador.encontrarTodosSubconjuntosComSomaZero();

        if (!subconjuntosComSomaZero.isEmpty()) {
            System.out.println("Subconjuntos com soma zero encontrados:");
            for (List<Integer> subconjunto : subconjuntosComSomaZero) {
                System.out.println(subconjunto);
            }
        } else {
            System.out.println("Não foram encontrados subconjuntos com soma zero.");
        }
    }
}

class SolucionadorSomaSubconjuntos {
    private int[] numeros;

    public SolucionadorSomaSubconjuntos(String entrada) {
        String[] numerosString = entrada.split(" ");
        this.numeros = new int[numerosString.length];
        for (int i = 0; i < numerosString.length; i++) {
            this.numeros[i] = Integer.parseInt(numerosString[i]);
        }
    }

    public List<List<Integer>> encontrarTodosSubconjuntosComSomaZero() {
        List<List<Integer>> todosSubconjuntos = encontrarTodosSubconjuntos();
        List<List<Integer>> subconjuntosComSomaZero = new ArrayList<>();

        for (int i = 0; i < todosSubconjuntos.size(); i++) {
            List<Integer> subconjunto = todosSubconjuntos.get(i);
            if (somar(subconjunto) == 0 && !subconjunto.isEmpty()) {
                subconjuntosComSomaZero.add(subconjunto);
            }
        }
        return subconjuntosComSomaZero;
    }

    private List<List<Integer>> encontrarTodosSubconjuntos() {
        List<List<Integer>> subconjuntos = new ArrayList<>();
        subconjuntos.add(new ArrayList<>()); // Adiciona o subconjunto vazio

        for (int numero : numeros) {
            List<List<Integer>> novosSubconjuntos = new ArrayList<>();
            for (int i = 0; i < subconjuntos.size(); i++) {
                List<Integer> subconjunto = subconjuntos.get(i);
                List<Integer> novoSubconjunto = new ArrayList<>(subconjunto);
                novoSubconjunto.add(numero);
                novosSubconjuntos.add(novoSubconjunto);
            }
            subconjuntos.addAll(novosSubconjuntos);
        }

        return subconjuntos;
    }

    private int somar(List<Integer> subconjunto) {
        int soma = 0;
        for (int numero : subconjunto) {
            soma += numero;
        }
        return soma;
    }
}
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemaSubconjuntos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de números no conjunto: ");
        int tamanho = scanner.nextInt();

        int[] A = new int[tamanho];
        System.out.println("Digite os números do conjunto separados por espaço:");
        for (int i = 0; i < tamanho; i++) {
            A[i] = scanner.nextInt();
        }
        scanner.close();

        SolucionadorSubconjuntos solucionador = new SolucionadorSubconjuntos(A);
        solucionador.exibirSubconjuntosComSomaZero();
    }
}

class SolucionadorSubconjuntos {
    private int[] A;

    public SolucionadorSubconjuntos(int[] A) {
        this.A = A;
    }

    public void exibirSubconjuntosComSomaZero() {
        List<List<Integer>> todosSubconjuntos = new ArrayList<>();
        encontrarSubconjuntosComSomaZero(A.length - 1, 0, new ArrayList<>(), todosSubconjuntos);

        if (!todosSubconjuntos.isEmpty()) {
            System.out.println("Subconjuntos com soma zero encontrados:");
            for (List<Integer> subconjunto : todosSubconjuntos) {
                System.out.println(subconjunto);
            }
        } else {
            System.out.println("Não foram encontrados subconjuntos com soma zero.");
        }
    }

    private void encontrarSubconjuntosComSomaZero(int n, int somaAtual, List<Integer> subconjuntoAtual, List<List<Integer>> todosSubconjuntos) {
        if (n < 0) {
            if (somaAtual == 0 && !subconjuntoAtual.isEmpty() && !contemSubconjunto(todosSubconjuntos, subconjuntoAtual)) {
                todosSubconjuntos.add(new ArrayList<>(subconjuntoAtual));
            }
            return;
        }

        subconjuntoAtual.add(A[n]);
        encontrarSubconjuntosComSomaZero(n - 1, somaAtual + A[n], subconjuntoAtual, todosSubconjuntos);

        subconjuntoAtual.remove(subconjuntoAtual.size() - 1);
        encontrarSubconjuntosComSomaZero(n - 1, somaAtual, subconjuntoAtual, todosSubconjuntos);
    }

    private boolean contemSubconjunto(List<List<Integer>> todosSubconjuntos, List<Integer> subconjuntoAtual) {
        for (int i = 0; i < todosSubconjuntos.size(); i++) {
            if (new ArrayList<>(todosSubconjuntos.get(i)).equals(new ArrayList<>(subconjuntoAtual))) {
                return true;
            }
        }
        return false;
    }
}

/*
PSEUDOCÓDIGO 1:

Procedimento EncontrarSubconjuntosComSomaZero(entrada)
numeros[] ← ConverterParaInteiros(entrada)
todosSubconjuntos ← [[]]
Para i de 0 até |numeros| - 1
novosSubconjuntos ← []
Para j de 0 até |subconjuntos| - 1
novoSubconjunto ← subconjuntos[j] + numeros[i]
novosSubconjuntos ← novosSubconjuntos + novoSubconjunto
        FimPara
todosSubconjuntos ← todosSubconjuntos + novosSubconjuntos
        FimPara
subconjuntosComSomaZero ← []
Para cada subconjunto em todosSubconjuntos
Se Somar(subconjunto) = 0
subconjuntosComSomaZero ← subconjuntosComSomaZero + subconjunto
        FimSe
FimPara
Retornar subconjuntosComSomaZero
FimProcedimento

PSEUDOCÓDIGO 2:

Procedimento ExibirSubconjuntosComSomaZero(A[])
todosSubconjuntos ← []
EncontrarSubconjuntosComSomaZero(|A| - 1, 0, [], todosSubconjuntos)
Para cada subconjunto em todosSubconjuntos
Imprimir subconjunto
FimPara
        FimProcedimento

Procedimento EncontrarSubconjuntosComSomaZero(n, somaAtual, subconjuntoAtual, todosSubconjuntos)
Se n < 0
Se somaAtual = 0 ∧ ¬subconjuntoAtual = []
todosSubconjuntos ← todosSubconjuntos + subconjuntoAtual
        FimSe
Retornar
        FimSe
EncontrarSubconjuntosComSomaZero(n - 1, somaAtual + A[n], subconjuntoAtual + A[n], todosSubconjuntos)
EncontrarSubconjuntosComSomaZero(n - 1, somaAtual, subconjuntoAtual, todosSubconjuntos)
FimProcedimento
*/