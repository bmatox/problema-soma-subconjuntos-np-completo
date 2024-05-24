import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProblemaSubconjuntos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite os números separados por espaço: ");
        String entrada = scanner.nextLine();
        String[] numerosString = entrada.split(" ");
        int[] numeros = new int[numerosString.length];

        for (int i = 0; i < numerosString.length; i++) {
            numeros[i] = Integer.parseInt(numerosString[i]);
        }

        SolucionadorSomaSubconjuntos solucionador = new SolucionadorSomaSubconjuntos(numeros);
        List<List<Integer>> subconjuntosComSomaZero = solucionador.encontrarTodosSubconjuntosComSomaZero();

        if (!subconjuntosComSomaZero.isEmpty()) {
            System.out.println("Subconjuntos com soma zero encontrados: " + subconjuntosComSomaZero);
        } else {
            System.out.println("Não foram encontrados subconjuntos com soma zero.");
        }
    }
}

class SolucionadorSomaSubconjuntos {
    private int[] numeros;

    public SolucionadorSomaSubconjuntos(int[] numeros) {
        this.numeros = numeros;
    }

    public List<List<Integer>> encontrarTodosSubconjuntosComSomaZero() {
        List<List<Integer>> todosSubconjuntos = encontrarTodosSubconjuntos();
        List<List<Integer>> subconjuntosComSomaZero = new ArrayList<>();

        for (List<Integer> subconjunto : todosSubconjuntos) {
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
            for (List<Integer> subconjunto : subconjuntos) {
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
