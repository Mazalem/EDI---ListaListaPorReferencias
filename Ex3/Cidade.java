public class Cidade {
    private String nome, pais, principaisAtrativos;
    private int nota;
    
    public Cidade(String nome, String pais, String principaisAtrativos, int nota) {
        this.nome = nome;
        this.pais = pais;
        this.principaisAtrativos = principaisAtrativos;
        this.nota = nota;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getPrincipaisAtrativos() {
        return principaisAtrativos;
    }
    public void setPrincipaisAtrativos(String principaisAtrativos) {
        this.principaisAtrativos = principaisAtrativos;
    }
    public int getNota() {
        return nota;
    }
    public void setNota(int nota) {
        this.nota = nota;
    }
}