import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    // Declaração de um objeto Lock para controlar o acesso concorrente
    private final Lock lock = new ReentrantLock();
    // Variável para armazenar o total transferido pelo banco
    private double totalTransferido = 0;

    // Método para transferir dinheiro entre duas contas
    public void transferencia(Conta conta_1, Conta conta_2, double valor) {
        // Bloqueia o acesso para evitar concorrência
        lock.lock();
        try {
            // Verifica se a conta de origem tem saldo suficiente para a transferência
            if (conta_1.get_saldo() >= valor) {
                // Remove o valor da conta de origem
                conta_1.remover(valor);
                // Adiciona o valor na conta de destino
                conta_2.adicionar(valor);
                // Atualiza o total transferido pelo banco
                totalTransferido += valor;
                // Imprime mensagem de confirmação da transferência
                System.out.println(valor + " Reais enviados para conta " + conta_2.get_id_dono());
                System.out.println("---------------------------\n");
            } else {
                // Caso o saldo da conta de origem seja insuficiente, imprime mensagem de erro
                System.out.println("Saldo insuficiente na conta " + conta_1.get_id_dono());
                System.out.println("---------------------------\n");
            }
        } finally {
            // Libera o bloqueio após o término da operação
            lock.unlock();
        }
    }

    // Método para obter o total transferido pelo banco
    public double getTotalTransferido() {
        return totalTransferido;
    }

    // Método para imprimir o saldo das contas
    public void restante(Conta[] contas) {
        // Imprime uma série de novas linhas para limpar a tela
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n ");
        // Imprime título para o saldo das contas
        System.out.println("-----SALDO DAS CONTAS------\n");
        // Itera sobre todas as contas fornecidas
        for (Conta conta : contas) {
            System.out.println("---------------------------");
            // Imprime o saldo da conta atual
            System.out.println("Na conta  " + conta.get_id_dono() + " Restam " + conta.get_saldo() + " Reais");
        }
    }
}
