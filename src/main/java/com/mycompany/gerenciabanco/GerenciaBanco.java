/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gerenciabanco;

import java.util.Scanner; //importação da biblioteca Java!

class Cliente {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double saldo;
    
    
    
    public Cliente(String nome, String sobrenome, String cpf) {
        this.nome= nome;
        this.sobrenome= sobrenome;
        this.cpf= cpf;
        this.saldo= 0.0;
    }
    
    
    //início dos métodos da classe cliente 
    public void consultarSaldo() {
        System.out.println("Seu saldo é: " + saldo);
    }
    //fim da consulta
    
    
    public void realizarDeposito(double valor) {
        if (valor > 0){
            saldo += valor;
            System.out.println("Depósito de R$" + valor + "realizado com sucesso!");
        } else {
            System.out.println("Valor inválido.");
        }
        
    }
    //fim da realização do depósito
    
    
    public void realizarSaque(double valor) {
        if (valor > 0 && valor <= saldo) {
        saldo -= valor;
        System.out.println("O saque de R$:" + valor + "realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficente ou valor inválido");
        }
    }
    //fim da realização do saque
    
 }
//fim da classe ciente

public class GerenciaBanco {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Informe seu nome por favor:");
        String nome = scanner.nextLine();
        System.out.println("Informe seu sobrenome por favor:");
        String sobrenome = scanner.nextLine();
        System.out.println("Informe seu CPF por favor:");
        String cpf = scanner.nextLine();
        
        //criando um objeto da classe cliente para instanciar as respostas
        
        Cliente cliente = new Cliente(nome, sobrenome, cpf);
        
        boolean continuar = true;
        
        while (continuar) {
            System.out.println("===============================");
            System.out.println("O que deseja?");
            System.out.println("1. Consultar saldo.");
            System.out.println("2. Realizar depósito.");
            System.out.println("3. Realizar saque.");
            System.out.println("4. Finalizar");
            System.out.println("===============================");
            
            int escolha = scanner.nextInt();
            
            switch (escolha) {
                case 1:
                    cliente.consultarSaldo();
                    break;
                case 2:
                    System.out.println("Informe o valor a ser depósitado:");
                    double valorDeposito = scanner.nextDouble();
                    cliente.realizarDeposito(valorDeposito);
                    break;
                case 3:
                    System.out.println("Informe o valor a ser sacado:");
                    double valorSaque = scanner.nextDouble();
                    cliente.realizarSaque(valorSaque);
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Muito obrigado por usar nossos serviços!");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente");
                    break;
            }
        }
        scanner.close();
    }
}

