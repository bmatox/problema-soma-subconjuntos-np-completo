import java.util.ArrayList;
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
            for (int i = 0; i < subconjuntosComSomaZero.size(); i++) {
                System.out.println(subconjuntosComSomaZero.get(i));
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

        for (int i = 0; i < numeros.length; i++) {
            int numero = numeros[i];
            List<List<Integer>> novosSubconjuntos = new ArrayList<>();
            for (int j = 0; j < subconjuntos.size(); j++) {
                List<Integer> subconjunto = subconjuntos.get(j);
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
        for (int i = 0; i < subconjunto.size(); i++) {
            soma += subconjunto.get(i);
        }
        return soma;
    }
}