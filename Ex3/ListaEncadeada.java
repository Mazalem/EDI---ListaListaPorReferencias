public class ListaEncadeada {
    public int tamanho = 0;
    public Node cabeca = new Node();
    public Node cauda = cabeca;
    public Node elemento;

    public void add(Cidade cidade) {
        if(this.tamanho == 0) {
            elemento = new Node(cidade, cabeca, null);
            cabeca.proximo = elemento;
            cauda = elemento;
            tamanho++;
        }
        else {
            Node el = cabeca.proximo;
            for(int i = 1; i <= tamanho; i++) {
                if(el.elemento.getNota() < cidade.getNota()) {
                    elemento = new Node(cidade, el.anterior, el);
                    el.anterior.proximo = elemento;
                    el.anterior = elemento;
                    tamanho++;
                    break;
                }
                else if(el.elemento.getNota() == cidade.getNota()) {
                    elemento = new Node(cidade, el, el.proximo);
                    if(el.proximo == null) {
                        el.proximo = elemento;
                        cauda = elemento;
                        tamanho++;
                        break;
                    }else if(el.proximo.elemento.getNota() != cidade.getNota()) {
                        el.proximo.anterior = elemento;
                        el.proximo = elemento;
                        tamanho++;
                        break;
                    }
                }else if(i == tamanho) {
                    elemento = new Node(cidade, cauda, null);
                    cauda.proximo = elemento;
                    cauda = elemento;
                }

                el = el.proximo;
            }
        }
    }

    public void del(String nome, String pais) throws Exception {
        if (this.tamanho == 0) {
            throw new Exception("Lista Vazia");
        }
    
        Node el = cabeca.proximo;
        boolean achou = false;
    
        for (int i = 1; i <= tamanho; i++) {
            if (el.elemento.getNome().toLowerCase().equals(nome.toLowerCase()) && el.elemento.getPais().toLowerCase().equals(pais.toLowerCase())) {
                achou = true;
    
                if (tamanho == 1) {
                    cabeca.proximo = null;
                    cauda = null;
                } else if (i == 1) {
                    el.proximo.anterior = cabeca;
                    cabeca.proximo = el.proximo;
                } else if (i == tamanho) {
                    cauda = el.anterior;
                    cauda.proximo = null;
                } else {
                    el.anterior.proximo = el.proximo;
                    el.proximo.anterior = el.anterior;
                }
    
                tamanho--;
                break;
            }
    
            el = el.proximo;
        }
    
        if (!achou) {
            System.out.println("Não encontrado!");
        }
    }
    

    public void printTudo() {
        Node el = cabeca.proximo;
        while(el!=null) {
            System.out.println("Nome: " + el.elemento.getNome());
            el = el.proximo;
        }
    }

    public Cidade print(int posicao) {
        Node printer = cabeca.proximo;
        for(int i = 1; i < posicao; i++) {
            printer = printer.proximo;
        }
        return printer.elemento;
    }
}
