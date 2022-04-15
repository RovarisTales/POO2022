import java.util.Objects;

/**
 * Uma Marca é uma empresa que contém o seu nome e o custo energético das colunas da marca.
 * @author Tiago Rodrigues
 * @version 15/04/2022
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

    /**
     * Construtor parametrizado de Marca.
     * Aceita como parâmetros o nome da marca e o custo de energia do produtos da marca
     */
    public Marca(String nome, int custo) {
        this.nome = nome;
        this.custo = custo;
    }

    /**
     * Construtor parametrizado de Marca.
     * Aceita como parâmetro uma Marca.
     */
    public Marca(Marca umaMarca){
        this.nome = umaMarca.getNome();
        this.custo = umaMarca.getCusto();
    }

    /**
     * métodos de instância
     */

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

    /**
     * Método que faz uma cópia do objecto receptor da mensagem.
     * Para tal invoca o construtor de cópia.
     *
     * @return objecto clone do objecto que recebe a mensagem.
     */

    public Marca clone(){
        return new Marca(this);
    }

    @Override
    /**
     * Método que verifica se um objeto é igual a outro.
     *
     * @return boolean true se os objetos tiveram as atribuições iguais e o inverso.
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return (this.custo == marca.getCusto()) && this.nome.equals(marca.getNome());
    }

    /**
     * Método que devolve a representação em String da Marca
     * @return String com o nome e o inteiro com custo de energia
     */

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append("\n")
                .append("Custo Energético: ").append(this.custo).append("\n");

        return sb.toString();
    }
}
