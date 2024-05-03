package Programa;

public class Pedido {

    private static int contadorPedido = 1;
    private int numeroPedido;
    private String endereco;
    private Cliente cliente;
    private Pizza pizza;
    private boolean isDespachado = false;

    public Pedido(Cliente cliente, Pizza pizza, String endereco) {
        this.numeroPedido = contadorPedido;
        this.cliente = cliente;
        this.pizza = pizza;
        this.endereco = endereco;
        contadorPedido += 1;
    }

    public boolean isDespachado() {
        return isDespachado;
    }

    public void setDespachado(boolean despachado) {
        isDespachado = despachado;
    }

    public static int getContadorPedido() {
        return contadorPedido;
    }

    public static void setContadorPedido(int contadorPedido) {
        Pedido.contadorPedido = contadorPedido;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String toString(){
        return STR."\nNúmero do Pedido: \{this.getNumeroPedido()}\nNome do Cliente: \{this.cliente.getNome()}\nEndereço de Entrega: \{this.getEndereco()}\nSabor da Pizza: \{this.pizza.getSabor()}\nTamanho da Pizza: \{this.pizza.getTamanho()}\nEm entrega: \{this.isDespachado()}";
    }

}
