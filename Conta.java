public class Conta {
    private final int id_dono; // Identificador único do dono da conta
    private double saldo; // Saldo da conta

    // Construtor da classe Conta
    public Conta(int id_dono, double saldoInicial) {
        this.id_dono = id_dono;
        this.saldo = saldoInicial;
    }
    
    // Método para obter o ID do dono da conta
    public int get_id_dono() {
        return id_dono;
    }

    // Método para obter o saldo da conta
    public double get_saldo() {
        return saldo;
    }

    // Método sincronizado para adicionar um valor ao saldo da conta
    public synchronized void adicionar(double valor) {
        saldo += valor;
    }

    // Método sincronizado para remover um valor do saldo da conta
    public synchronized void remover(double valor) {
        saldo -= valor;
    }
}
