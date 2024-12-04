public class Node {
    public Node proximo;
    public Node anterior;
    public Cliente elemento;

    public Node() {
        this.elemento = null;
        this.proximo = null;
        this.anterior = null;
    }

    public Node(Cliente elemento, Node anterior, Node proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
        this.anterior = anterior;
    }
}
