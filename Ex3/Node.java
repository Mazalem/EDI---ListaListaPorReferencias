public class Node {
    public Cidade elemento;
    public Node anterior;
    public Node proximo;
    
    public Node(Cidade elemento, Node anterior, Node proximo) {
        this.elemento = elemento;
        this.anterior = anterior;
        this.proximo = proximo;
    }

    public Node() {
        this.elemento = null;
        this.anterior = null;
        this.proximo = null;
    }
}
