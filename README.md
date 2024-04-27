# Sistema de Gerenciamento Bancário e de Lojas

Este é um projeto de sistema de gerenciamento bancário e de lojas que visa simular transações entre clientes, funcionários, lojas e um banco. O sistema foi desenvolvido com as seguintes funcionalidades:

## Funcionalidades

### Entidades

O sistema contém as seguintes entidades:

- **Banco**: Responsável por intermediar transações e garantir a consistência dos saldos das contas.
- **Loja**: Estabelecimento comercial que recebe pagamentos dos clientes e paga os salários dos funcionários.
- **Funcionário**: Indivíduos empregados pelas lojas, responsáveis por receber salários e investir parte deles.
- **Cliente**: Indivíduos que realizam compras nas lojas.
- **Conta**: Registro que mantém o saldo e as transações financeiras de cada entidade.

### Total de Entidades

O sistema possui o seguinte total de entidades:

- **1 Banco**
- **2 Lojas**
- **4 Funcionários** (2 por loja)
- **5 Clientes**

### Comportamento das Entidades

- **Cliente**: Cada cliente é representado por uma thread e possui uma conta com um saldo inicial de R$ 1.000,00. Eles realizam compras alternando entre as lojas até que o saldo da conta esteja vazio.
- **Loja**: Cada loja possui uma conta para receber pagamentos dos clientes e paga os funcionários assim que possuir o valor de seus salários (R$ 1.400,00).
- **Funcionário**: Cada funcionário é uma thread que possui duas contas: uma para receber o salário da loja e outra para investimentos. Eles investem 20% do salário na conta de investimentos logo após o recebimento.
- **Banco**: O banco é responsável por intermediar transações de forma síncrona e coordenada, garantindo a consistência dos saldos das contas.

## Executando o Sistema

Para executar o sistema, siga as instruções abaixo:

1. Clone o repositório do projeto.
2. Compile e execute o código-fonte do sistema.
3. Observe as transações e interações entre as entidades.

