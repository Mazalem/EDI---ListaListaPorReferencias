public class Node {
    public Node proximo;
    public Veiculo elemento;

    public Node() {
        this.proximo = null;
        this.elemento = null;
    }
    public Node(Node proximo, Veiculo elemento) {
        this.proximo = proximo;
        this.elemento = elemento;
    }

}
