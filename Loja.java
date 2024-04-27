public class Loja {
    private final int id_loja; // Identificador único da loja
    private final Conta conta; // Conta bancária da loja
    private final Funcionario[] funcionarios; // Array de funcionários da loja

    // Construtor da classe Loja
    public Loja(int id_loja, Conta conta, Funcionario[] funcionarios) {
        this.id_loja = id_loja;
        this.conta = conta;
        this.funcionarios = funcionarios;
    }

    // Método para obter o ID da loja
    public int get_id_loja() {
        return id_loja;
    }

    // Método para obter a conta da loja
    public Conta getConta() {
        return conta;
    }

    // Método para pagar os funcionários da loja
    void pagarFuncionarios() {
        synchronized (conta) { // Bloco sincronizado para garantir operações seguras na conta da loja
            for (Funcionario funcionario : funcionarios) { // Iteração sobre os funcionários da loja
                if (conta.get_saldo() >= Funcionario.getSalario()) { // Verifica se há saldo suficiente para pagar o funcionário
                    conta.remover(Funcionario.getSalario()); // Remove o salário da conta da loja
                    // Imprime mensagem informando que o funcionário recebeu seu salário
                    System.out.println("O Funcionário " + funcionario.get_id_func() + " que trabalha na loja " + id_loja +
                            " recebeu o seu salário de " + Funcionario.getSalario());
                    System.out.println("---------------------------\n");
                } else {
                    // Se o saldo for insuficiente, imprime mensagem informando isso
                    System.out.println("Saldo insuficiente para pagar o funcionário " + funcionario.get_id_func() +
                            " da loja " + id_loja);
                    System.out.println("---------------------------\n");
                }
            }
        }
    }
}
