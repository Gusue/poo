public class Main {
    public static void main(String[] args) {
        // Criando o banco
        Banco banco = new Banco();

        // Criando as contas das lojas
        Conta Loja1 = new Conta(1000, 0);
        Conta Loja2 = new Conta(1001, 0);

        // Criando os funcionários das lojas
        Funcionario Funcionario_loja1 = new Funcionario(100, Loja1, null);
        Funcionario funcionario_1_loja1 = new Funcionario(101, Loja1, null);
        Funcionario funcionario_1_loja_2 = new Funcionario(102, Loja2, null);
        Funcionario funcionario_2_loja_2 = new Funcionario(103, Loja2, null);

        // Passando os funcionários para as lojas
        Loja loja1 = new Loja(0, Loja1, new Funcionario[]{Funcionario_loja1, funcionario_1_loja1});
        Loja loja2 = new Loja(1, Loja2, new Funcionario[]{funcionario_1_loja_2, funcionario_2_loja_2});

        // Criando as contas dos funcionários
        Conta Funcionario_1 = new Conta(100, 0);
        Conta Investimento_funcionario_1 = new Conta(0, 0);

        Conta Funcionario_2 = new Conta(101, 0);
        Conta Investimento_funcionario_2 = new Conta(1, 0);

        Conta Funcionario_3 = new Conta(102, 0);
        Conta Investimento_funcionario_3 = new Conta(2, 0);

        Conta Funcionario_4 = new Conta(103, 0);
        Conta Investimento_funcionario_4 = new Conta(3, 0);

        // Criando as contas dos clientes
        Conta contaCliente1 = new Conta(0, 1000);
        Cliente cliente1 = new Cliente(0, contaCliente1, new Loja[]{loja1, loja2}, banco);

        Conta contaCliente2 = new Conta(1, 1000);
        Cliente cliente2 = new Cliente(1, contaCliente2, new Loja[]{loja1, loja2}, banco);

        Conta contaCliente3 = new Conta(2, 1000);
        Cliente cliente3 = new Cliente(2, contaCliente3, new Loja[]{loja1, loja2}, banco);

        Conta contaCliente4 = new Conta(3, 1000);
        Cliente cliente4 = new Cliente(3, contaCliente4, new Loja[]{loja1, loja2}, banco);

        Conta contaCliente5 = new Conta(4, 1000);
        Cliente cliente5 = new Cliente(4, contaCliente5, new Loja[]{loja1, loja2}, banco);


        // Iniciando as threads dos clientes
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();

        // Aguardando pelas threads dos clientes terminarem
        try {
            cliente1.join();
            cliente2.join();
            cliente3.join();
            cliente4.join();
            cliente5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Pagando os funcionários
        loja1.pagarFuncionarios();
        loja2.pagarFuncionarios();

        // Exibindo saldo final das contas
        Conta[] contas = {contaCliente1, contaCliente2, contaCliente3, contaCliente4, contaCliente5,
                Funcionario_1, Funcionario_2, Funcionario_3, Funcionario_4,
                Investimento_funcionario_1, Investimento_funcionario_2, Investimento_funcionario_3,
                Investimento_funcionario_4, Loja1, Loja2};
        banco.restante(contas);
    }
}