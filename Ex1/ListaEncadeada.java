public class ListaEncadeada {
    public int tamanho = 0;
    public Node cabeca = new Node();
    public Node calda = cabeca;
    public Node elemento;

    public void add(Cliente cliente) throws Exception {
        elemento = new Node(cliente, null, null);
    
        if (tamanho == 0) {
            cabeca.proximo = elemento;
            elemento.anterior = cabeca;
            calda = elemento;
        } else {
            Node el = cabeca.proximo;
    
            while (el != null) {
                if (el.elemento.getCodigo() == cliente.getCodigo()) {
                    throw new Exception("Código já existe");
                } else if (el.elemento.getCodigo() > cliente.getCodigo()) {
                    elemento.anterior = el.anterior;
                    elemento.proximo = el;
                    el.anterior.proximo = elemento;
                    el.anterior = elemento;
                    if (el == cabeca.proximo) {
                        cabeca.proximo = elemento;
                    }
                    tamanho++;
                    return;
                }
                el = el.proximo;
            }
            calda.proximo = elemento;
            elemento.anterior = calda;
            calda = elemento;
        }
        tamanho++;
    }    

    public void printCresc() {
        Node el = cabeca.proximo;
        while (el != null) {
            System.out.println(el.elemento.getCodigo() + ": " + el.elemento.getNome() + " | " + el.elemento.getTelefone());
            el = el.proximo;
        }
    }

    public void printDecresc() {
        Node el = calda;
        while (el != cabeca) {
            System.out.println(el.elemento.getCodigo() + ": " + el.elemento.getNome() + " | " + el.elemento.getTelefone());
            el = el.anterior;
        }
    }
}

/*public void add(Cliente cliente) {
        if (tamanho == 0) {
            elemento = new Node(cliente, cabeca, null);
            cabeca.proximo = elemento;
            calda = elemento;
            tamanho++;
        } else {
            Node el = cabeca.proximo;
            while (el != null) {
                if (el.elemento.getCodigo() == cliente.getCodigo()) {
                    System.out.println("Código já existe");
                    return;
                } else if (el.elemento.getCodigo() > cliente.getCodigo()) {
                    elemento = new Node(cliente, el.anterior, el);
                    el.anterior.proximo = elemento;
                    el.anterior = elemento;
                    tamanho++;
                    return;
                }
                el = el.proximo;
            }
            elemento = new Node(cliente, calda, null);
            calda.proximo = elemento;
            calda = elemento;
            tamanho++;
        }
    } */
