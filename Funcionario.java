public class Funcionario extends Thread {
    private final int id_func; // Identificador único do funcionário
    private final Conta contaSalario; // Conta de salário do funcionário
    private final Conta contaInvestimento; // Conta de investimento do funcionário
    private static final double salario_func = 1400; // Salário fixo do funcionário

    // Construtor da classe Funcionario
    public Funcionario(int id_func, Conta contaSalario, Conta contaInvestimento) {
        this.id_func = id_func;
        this.contaSalario = contaSalario;
        this.contaInvestimento = contaInvestimento;
    }

    // Método run() sobrescrito da classe Thread, que define o comportamento do funcionário quando executado
    @Override
    public void run() {
        // Bloco sincronizado para garantir que as operações na conta de salário sejam feitas atomicamente
        synchronized (contaSalario) {
            // Adiciona o salário à conta de salário
            contaSalario.adicionar(salario_func);
            // Calcula o valor a ser investido (20% do salário) e adiciona à conta de investimento
            double valorInvestimento = salario_func * 0.2;
            contaInvestimento.adicionar(valorInvestimento);
            // Imprime mensagem informando que o funcionário recebeu seu salário e investiu parte dele na bolsa
            System.out.println("O funcionario " + id_func + " recebeu seu salario de: " + salario_func + " E então ele investiu " + valorInvestimento + " Reais na bolsa");
            System.out.println("---------------------------\n");
        }
    }

    // Método para obter o ID do funcionário
    public int get_id_func() {
        return id_func;
    }

    // Método estático para obter o valor fixo do salário
    public static double getSalario() {
        return salario_func;
    }
}
