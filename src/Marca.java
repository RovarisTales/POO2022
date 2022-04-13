/**
 * Classe para a SmartSpeaker que tem uma Marca.
 */

public class Marca {
    private String nome;
    private int custo;

    public Marca(){
        this.nome = " ";
        this.custo = 10000;
    }

    public Marca(String nome, int custo) {
        this.nome = nome;
        this.custo = custo;
    }

    public Marca(Marca umaMarca){
        this.nome = umaMarca.getNome();
        this.custo = umaMarca.getCusto();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public Marca clone(){
        return new Marca(this);
    }


}
