public class Cliente extends Thread {
    private final int id_cli; // Identificador único do cliente
    private final Conta conta; // Conta bancária do cliente
    private final Loja[] lojas; // Array de lojas disponíveis para fazer compras
    private final Banco banco; // Referência ao banco para realizar transferências

    // Construtor da classe Cliente
    public Cliente(int id_cli, Conta conta, Loja[] lojas, Banco banco) {
        this.id_cli = id_cli;
        this.conta = conta;
        this.lojas = lojas;
        this.banco = banco;
    }

    // Método run() sobrescrito da classe Thread, que define o comportamento do cliente quando executado
    @Override
    public void run() {
        // Loop para realizar compras até o saldo da conta ficar vazio
        while (conta.get_saldo() > 0) {
            // Escolha aleatória de uma loja
            Loja loja = lojas[(int) (Math.random() * lojas.length)];
            // Valor da compra aleatória
            double valorCompra = Math.random() < 0.5 ? 100 : 200;

            // Realiza a compra na loja escolhida
            synchronized (loja) { // Bloco sincronizado para evitar conflitos de acesso à loja
                if (conta.get_saldo() >= valorCompra) {
                    banco.transferencia(conta, loja.getConta(), valorCompra); // Transferência de fundos da conta do cliente para a conta da loja
                    System.out.println("O cliente " + id_cli + " comprou algo no valor de " + valorCompra + " na loja " + loja.get_id_loja() +
                            " Seu saldo restante é: " + conta.get_saldo() + " Reais");
                    System.out.println("---------------------------\n");
                } else {
                    // Caso não haja saldo suficiente na conta para a compra, imprime uma mensagem e encerra o loop
                    System.out.println("O cliente " + id_cli + " não possui mais saldo para a compra");
                    System.out.println("---------------------------\n");
                    break;
                }
            }

            // Aguarda um tempo antes de ir para a próxima loja
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Quando o saldo da conta fica zerado, imprime uma mensagem informando isso
        System.out.println("A conta do cliente " + id_cli + " está zerada");
        System.out.println("---------------------------\n");
    }

    // Método para obter o ID do cliente
    public int get_id_cli() {
        return id_cli;
    }
}
