import java.util.*;

public class ComercializadorEnergia {
    private String nome;
    private double custoDiarioEner;
    private static double IMPOSTO = 2.0;
    private double volumeFatura;
    private List<String> faturas;

    public ComercializadorEnergia(){
        this.nome = "";
        this.custoDiarioEner = 0;
        this.volumeFatura = 0;
        this.faturas = new ArrayList<>();
    }
    public ComercializadorEnergia(String nome, double custoDiarioEner, double volumeFatura)
    {
        this.nome = nome;
        this.custoDiarioEner = custoDiarioEner;
        this.volumeFatura = volumeFatura;
        this.faturas = new ArrayList<>();
    }

    public ComercializadorEnergia(String nome, double custoDiarioEner, double volumeFatura, List<String> faturas) {
        this.nome = nome;
        this.custoDiarioEner = custoDiarioEner;
        this.volumeFatura = volumeFatura;
        this.faturas = new ArrayList<>(faturas);

    }

    public ComercializadorEnergia(ComercializadorEnergia umConstrutor){
        this.nome = umConstrutor.getNome();
        this.custoDiarioEner = umConstrutor.getCustoDiarioEner();
        this.volumeFatura = umConstrutor.getVolumeFatura();
        this.faturas = umConstrutor.getFaturas();
    }

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

    public List<String> getFaturas() {
        return new ArrayList<>(this.faturas);
    }

    public void setFaturas(List<String> faturas) {
        this.faturas = new ArrayList<>(faturas);
    }


    public void addFatura(int nif, String morada, String proprietario)
    {
        this.faturas.add("ComercializadorEnergia{" +
                "nome :'" + proprietario + '\'' +
                "NIF :" + nif +
                "Morada: " + morada +
                ", Custo Diario Energia:" + this.custoDiarioEner +
                ", volumeFatura: " + volumeFatura +
                '}');

    }

    public ComercializadorEnergia clone(){
        return new ComercializadorEnergia(this);
    }

    public double preçoDiaDisp(double consumoDisp)
    {
        return (custoDiarioEner * consumoDisp* (1 + IMPOSTO)) * 0.9;
    }

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
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
