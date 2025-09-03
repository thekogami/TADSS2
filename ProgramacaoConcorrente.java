// Faça um programa que gere um array de 1 bilhão de números inteiros aleatórios e faça as seguintes tarefas:

// Some todos os valores de forma sequencial e meça o tempo de execução;
// Some todos os valores de forma concorrente com 10 threads e meça o tempo de execução;
// Some todos os valores de forma concorrente com 100 threads e meça o tempo de execução.
// Responda as seguintes perguntas:
// Qual foi o speedup1 obtido?
// Teve algum caso que o speedup foi negativo?
// Repita os testes acima usando Threads virtuais.
// Houve diferenças entre Threads de plataforma e Threads virtuais? Se houve, quais foram e explique o porquê das diferenças.

import java.util.Random;

public class ProgramacaoConcorrente {
  public static void main(String[] args) throws Exception {
    int size = 1_000_000_000;
    int[] array = new int[size];
    Random random = new Random();
    for (int i = 0; i < size; i++) {
        array[i] = random.nextInt();
    }
    System.out.println("Soma sequencial: " + somarSequencial(array));
  }

  public static long somarSequencial(int[] array) {
    long soma = 0;
    for (int i : array) {
      soma += i;
    }
    return soma;
  }

  public static long somarConcorrente(int[] array, int numThreads) throws InterruptedException {
    long[] somaParcial = new long[numThreads];
    Thread[] threads = new Thread[numThreads];
    int tamanho = array.length / numThreads;

    for (int i = 0; i < numThreads; i++) {
      final int indice = i;
      threads[i] = new Thread(() -> {
        long soma = 0;
        for (int j = indice * tamanho; j < (indice + 1) * tamanho; j++) {
          soma += array[j];
        }
        somaParcial[indice] = soma;
        System.out.println("Thread " + Thread.currentThread().getName() + " soma parcial: " + soma);
      });
      threads[i].start();
      System.out.println("Thread " + i + " started.");
    }

    for (Thread thread : threads) {
      thread.join();
      System.out.println("Thread " + thread.getName() + " finished.");
    }

    long somaTotal = 0;
    for (long soma : somaParcial) {
      somaTotal += soma;
      System.out.println("Soma parcial: " + soma);
    }
    return somaTotal;
  }

}
