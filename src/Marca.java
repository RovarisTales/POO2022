import java.util.Objects;

/**
 * Uma Marca é uma empresa que contém o seu nome e o custo energético das colunas da marca.
 * @author Tiago Rodrigues
 * @version 13/04/2022
 */

public class Marca {
    private String nome;
    private int custo;

    /**
     * Construtor por omissão de Marca.
     */

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return (this.custo == marca.getCusto()) && this.nome.equals(marca.getNome());
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append("\n")
                .append("Custo Energético: ").append(this.custo).append("\n");

        return sb.toString();
    }
}
