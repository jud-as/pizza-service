package Programa;

import java.util.ArrayList;
import java.util.Scanner;

public class Pizzaria {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Pedido> pedidosPendentes;
    static ArrayList<String> saboresDisponiveis;

    public static int numeroEntregadores = 3;

    public static void main(String[] args) {
        pedidosPendentes = new ArrayList<Pedido>();
        saboresDisponiveis = new ArrayList<String>();
        operacoes();
    }



    public static void operacoes() {

        System.out.println("------------------------------------");
        System.out.println("-------SELECIONE UMA OPERAÇÃO-------\n");
        System.out.println("|   1 - Fazer Pedido                 |");
        System.out.println("|   2 - Listar Sabores               |");
        System.out.println("|   3 - Registrar Despache           |");
        System.out.println("|   4 - Registrar Entrega            |");
        System.out.println("|   5 - Listar Pedidos               |");
        System.out.println("|   6 - Sair                         |");

        int opc = input.nextInt();
        switch(opc){
            case 1:
                fazerPedido();
                break;
            case 2:
                listarSabores();
                break;
            case 3:
                registrarDespache();
                break;
            case 4:
                registrarEntrega();
                break;
            case 5:
                listarPedidos();
                break;
            case 6:
                System.out.println("Encerrando programa.");
                System.exit(0);
            default:
                System.out.println("Opção inválida.");
                operacoes();
                break;
        }
    }

    public static void fazerPedido(){

        if (pedidosPendentes.size()<6){
            System.out.println("\nSabor: ");
            String sabor = input.next();
            System.out.println("\nTamanho: ");
            String tamanho = input.next();
            Pizza pizza = new Pizza(sabor, tamanho);

            System.out.println("\nNome do cliente: ");
            String nome = input.nextLine();
            nome += input.nextLine();
            System.out.println("\nEndereço de entrega: ");
            String endereco = input.nextLine();
            System.out.println("\nTelefone para contato: ");
            String telefone = input.next();
            Cliente cliente = new Cliente(nome, telefone);

            Pedido pedido = new Pedido(cliente, pizza, endereco);
            pedidosPendentes.add(pedido);
            System.out.println("\nPedido realizado com sucesso.");
        }else{
            System.out.println("\nQuantidade máxima de pedidos excedida.");
        }

        operacoes();
    }

    private static Pedido encontrarPedido(int numeroPedido) {
        Pedido pedido = null;
        if(pedidosPendentes.size()>0) {
            for(Pedido p: pedidosPendentes) {
                if(p.getNumeroPedido() == numeroPedido){
                    pedido = p;
                }
            }
        }else{
            System.out.println("\nNão há registro de pedidos: ");
        }
        return pedido;
    }

    public static void listarPedidos(){
        if(!pedidosPendentes.isEmpty()){
            for(Pedido pedido: pedidosPendentes){
                System.out.println(pedido);
            }
        }else{
            System.out.println("Não há registro de pedidos.");
        }
        operacoes();
    }

    public static void listarSabores(){
        saboresDisponiveis.add("Calabresa");
        saboresDisponiveis.add("Marguerita");
        saboresDisponiveis.add("Chocolate");
        saboresDisponiveis.add("Estrogonofe");
        saboresDisponiveis.add("4 Queijos");

        int n = saboresDisponiveis.size();
        for (int i = 0; i < n; i++){
            System.out.printf("%s\n", saboresDisponiveis.get(i));
        }
        operacoes();
    }

    public static void registrarDespache(){
        System.out.println("\nNúmero do pedido: ");
        int numeroPedido = input.nextInt();

        Pedido pedido = encontrarPedido(numeroPedido);
        if (pedido != null){
            if (numeroEntregadores > 0){
                if (pedido.isDespachado() == false){
                    numeroEntregadores -= 1;
                    pedido.setDespachado(true);
                    System.out.println("\nPedido despachado com sucesso.");
                }else{
                    System.out.println("\nPedido já saiu para entrega.");
                }
            }else{
                System.out.println("\nSem entregadores disponíveis.");
            }
        }else{
            System.out.println("\nCódigo de pedido não encontrado.");
        }
        operacoes();
    }

    public static void registrarEntrega(){
        System.out.println("\nNúmero do pedido: ");
        int numeroPedido = input.nextInt();

        Pedido pedido = encontrarPedido(numeroPedido);
        if (pedido != null){
            if (pedido.isDespachado() == true){
                numeroEntregadores += 1;
                pedidosPendentes.remove(pedido);
                System.out.println("\nPedido entregue com sucesso.");
            }else{
                System.out.println("\nPedido ainda não saiu para entrega.");
            }
        }else{
            System.out.println("\nCódigo de pedido não encontrado.");
        }
        operacoes();
    }


}
