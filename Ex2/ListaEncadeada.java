public class ListaEncadeada {
    public int tamanho = 0;
    public Node cabeca = new Node();
    public Node calda = cabeca;
    public Node elemento;

    public void add(Veiculo veiculo) {
        if(this.tamanho == 0) {
            elemento = new Node(null, veiculo);
            calda = elemento;
            cabeca.proximo = elemento;
        }else {
            elemento = new Node(null, veiculo);
            calda.proximo = elemento;
            calda = elemento;
        }
        tamanho++;
    }

    public boolean del(String placa) {
        Node excluido = cabeca;
        while(excluido.proximo!=null) {
            if(excluido.proximo.elemento.getPlaca().equals(placa)) {
                excluido.proximo = excluido.proximo.proximo;
                tamanho--;
                return true;
            }
            excluido = excluido.proximo;
        }
        return false;

    }

    public void printLista() {
        Node elemento = cabeca.proximo;
        while(elemento != null) {
            Veiculo veiculo = elemento.elemento;
            System.out.println(veiculo.getMarca()+" "+veiculo.getModelo()+" : Placa "+veiculo.getPlaca()+" | Valor: R$"+veiculo.getValor());
            elemento = elemento.proximo;
        }
    }
}
