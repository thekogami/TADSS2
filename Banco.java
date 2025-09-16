public class Banco {
  private final double[] contas;

  public Banco(int numContas, double saldoInicial) {
    contas = new double[numContas];
    for (int i = 0; i < contas.length; i++) {
      contas[i] = saldoInicial;
    }
  }

  public synchronized void transferir(int contaOrigem, int contaDestino, double valor) {
    if (contaOrigem == contaDestino) return; // não permite transferências para a mesma conta
    if (valor <= 0) return; // valor invalido
    if (contaOrigem < 0 || contaOrigem >= contas.length) return; // conta origem inválida
    if (contaDestino < 0 || contaDestino >= contas.length) return; // conta destino inválida
    if (contas[contaOrigem] < valor) return; // saldo insuficiente

    contas[contaOrigem] -= valor;
    contas[contaDestino] += valor;
  }

  public synchronized double getSaldoTotal() {
    double total = 0;
    for (double saldo : contas) {
      total += saldo;
    }
    return total;
  }

  public int getNumContas() {
    return contas.length;
  }
}
