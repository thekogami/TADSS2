// Faça um programa que crie uma lista (ArrayList) e manipule ela com as seguintes threads:

// Duas threads incluindo valores aleatórios na lista.
// Uma thread removendo o primeiro valor da lista.
// Uma thread imprimindo a cada segundo os valores existentes.


import java.util.List;
import java.util.Random;
import java.util.Collections;

public class ArrayList {
  public static void main(String[] args) throws Exception {
    List<Integer> list = Collections.synchronizedList(new java.util.ArrayList<>());
    Random random = new Random();

    // Thread para adicionar valores aleatorios
    new Thread(() -> {
      while (true) {
        list.add(random.nextInt(100));
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    // Segunda thread para adicionar valores aleatorios
    new Thread(() -> {
      while (true) {
        list.add(random.nextInt(100));
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    // Thread para remover o primeiro valor da lista
    new Thread(() -> {
      while (true) {
        if (!list.isEmpty()) {
          list.remove(0);
        }
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();

    // Thread para imprimir os valores da lista
    new Thread(() -> {
      while (true) {
        synchronized (list) {
          System.out.println(list);
        }
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }).start();
  }
}