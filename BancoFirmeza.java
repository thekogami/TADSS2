// O banco Firmeza foi fundado com 100 contas correntes com R$ 1.000,00 de saldo inicial. Para avaliar a performance do sistema, crie um teste com programação concorrente que simule 5 sistemas fazendo transferências de valores aleatórios de até R$ 2.500,00 de uma conta aleatória para outra igualmente aleatória. Para avaliar a robusteza das transações, imprima o valor total no cofre do banco a cada 5 segundos, que deverá ser sempre de R$ 100.000,00. Após 3 minutos de execução, verifique a quantidade de transações que foram executadas e se o valor total no cofre continua sendo R$ 100.000,00.

import java.util.Random;

public class BancoFirmeza {
  public static void main(String[] args) throws Exception {
    Banco banco = new Banco(100, 1000);
    int numSistemas = 5;
    int duracaoTeste = 3 * 60 * 1000; // 3 minutos
    long inicioTeste = System.currentTimeMillis();

    // Criar e iniciar threads de sistemas de transferência
    for (int i  = 0; i < numSistemas; i++) {
      new Thread() {
        public void run() {
          Random random = new Random();
          while (System.currentTimeMillis() - inicioTeste < duracaoTeste) {
            int contaOrigem = random.nextInt(100);
            int contaDestino = random.nextInt(100);
            double valor = random.nextDouble() * 2500;
            banco.transferir(contaOrigem, contaDestino, valor);
            try {
              Thread.sleep(10); // Pequeno intervalo entre transferências
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }.start();
    }

    // Thread para imprimir o valor total a cada 5 segundos
    new Thread() {
      public void run() {
        try {
          while (System.currentTimeMillis() - inicioTeste < duracaoTeste) {
            Thread.sleep(5000);
            double saldoTotal = banco.getSaldoTotal();
            System.out.printf("Saldo total no banco: R$ %.2f%n", saldoTotal);
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }.start();
  }
}

