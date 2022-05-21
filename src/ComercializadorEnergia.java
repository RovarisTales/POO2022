import java.io.Serializable;
import java.util.*;

/**
 * O comercializador energia contém a informação referente a um comercializador
 *
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ComercializadorEnergia implements Serializable
{
    //variáveis de instância
    private String nome;
    private double custoDiarioEner;
    private static double IMPOSTO = 2.0;
    private double volumeFatura;
    private List<String> faturas;

    /**
     * Construtor por omissão do comercializador de energia.
     */
    public ComercializadorEnergia(){
        this.nome = "";
        this.custoDiarioEner = 0;
        this.volumeFatura = 0;
        this.faturas = new ArrayList<>();
    }
    /**
     * Construtor parametrizado de Comercializador de energia.
     * Aceita como parametros o nome ,o custo diario de energia e o volume de fatura
     * @param nome, custoDiarioEner, VolumeFatura
     *
     */
    public ComercializadorEnergia(String nome, double custoDiarioEner, double volumeFatura)
    {
        this.nome = nome;
        this.custoDiarioEner = custoDiarioEner;
        this.volumeFatura = volumeFatura;
        this.faturas = new ArrayList<>();
    }
     /**
     * Construtor parametrizado de Comercializador de energia.
     * Aceita como parametros o nome ,o custo diario de energia e o volume de fatura e faturas
     * @param nome
     * @param custoDiarioEner
      * @param faturas
      * @param volumeFatura
     */
    public ComercializadorEnergia(String nome, double custoDiarioEner, double volumeFatura, List<String> faturas) {
        this.nome = nome;
        this.custoDiarioEner = custoDiarioEner;
        this.volumeFatura = volumeFatura;
        this.faturas = new ArrayList<>(faturas);

    }
    /**
     * Construtor parametrizado de Comercializador de energia.
     * Aceita como parametros um ComercializadorEnergia
     * @param umConstrutor
     *
     *
     */
    public ComercializadorEnergia(ComercializadorEnergia umConstrutor){
        this.nome = umConstrutor.getNome();
        this.custoDiarioEner = umConstrutor.getCustoDiarioEner();
        this.volumeFatura = umConstrutor.getVolumeFatura();
        this.faturas = umConstrutor.getFaturas();
    }

    /**
     * métodos de instância
     *
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getCustoDiarioEner() {
        return custoDiarioEner;
    }

    public void setCustoDiarioEner(double custoDiarioEner) {
        this.custoDiarioEner = custoDiarioEner;
    }

    public static double getIMPOSTO() {
        return IMPOSTO;
    }

    public static void setIMPOSTO(double IMPOSTO) {
        ComercializadorEnergia.IMPOSTO = IMPOSTO;
    }

    public double getVolumeFatura() {
        return volumeFatura;
    }

    public void setVolumeFatura(double volumeFatura) {
        this.volumeFatura = volumeFatura;
    }

    public List<String> getFaturas()
    {
        return new ArrayList<>(this.faturas);
    }

    public void setFaturas(List<String> faturas) {
        this.faturas = new ArrayList<>(faturas);
    }


    public void addFatura(int nif, String morada, String proprietario, double preco, int dia1, int dia2)
    {
        this.faturas.add(
                "{" +
                "nome : '" + proprietario + '\'' +
                " NIF : " + nif +
                " Preço : " + preco +
                " Do dia " + dia1 + " até " + dia2 +
                " Morada: " + morada +
                '}');

    }

    public void addFatura(String fat){
        this.faturas.add(fat);

    }

    public ComercializadorEnergia clone(){
        return new ComercializadorEnergia(this);
    }
    /**
     * Calcula o preco diario de energia
     *
     * @param consumoDisp, o consumo do dispostivio
     *
     * @return o preço por dia
     */
    public double preçoDiaDisp(double consumoDisp)
    {
        return (custoDiarioEner * consumoDisp* (1 + IMPOSTO)) * 0.9;
    }

    /**
     * Calcula o preco diario de energia
     *
     * @param o, o objecto que iremos comparar
     *
     * @return se é igual ou não
     */
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComercializadorEnergia that = (ComercializadorEnergia) o;

        return this.nome.equals(that.getNome()) && this.custoDiarioEner == that.getCustoDiarioEner()
                && this.volumeFatura == that.getVolumeFatura() && this.getFaturas().equals(that.getFaturas());
    }

    @Override
    public String toString()
    {
        return "ComercializadorEnergia{" +
                "nome='" + nome + '\'' +
                ", custoDiarioEner=" + custoDiarioEner +
                ", volumeFatura=" + volumeFatura +
                ", faturas=" + faturas.toString() +
                '}';
    }
}
