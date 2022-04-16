import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Simulacao {
    List<CasaInteligente> casas;
    List<ComercializadorEnergia> comercializadores;

    /**
     * Construtor por omissão de Simulacao.
     */
    public Simulacao()
    {
        this.casas = new ArrayList<>();
        this.comercializadores = new ArrayList<>();
    }

    /**
     * Construtor parametrizado com o nome do ficheiro que queremos ler
     * para fazer as configurações do programa.
     */
    public Simulacao(String filename) throws FileNotFoundException
    {
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
    }

    /**
     * Métodos de instância
     */

    /**
     * Getters e setters
     */
    public List<CasaInteligente> getCasas()
    {
        return this.casas.stream().map(CasaInteligente::clone).collect(Collectors.toList());
    }

    public void setCasas(List<CasaInteligente> casas)
    {
        this.casas = casas.stream().map(CasaInteligente::clone).collect(Collectors.toList());
    }

    public List<ComercializadorEnergia> getComercializadores()
    {
        return this.comercializadores.stream().map(ComercializadorEnergia::clone).collect(Collectors.toList());
    }

    public void setComercializadores(List<ComercializadorEnergia> comercializadores)
    {
        this.comercializadores = comercializadores.stream().map(ComercializadorEnergia::clone).collect(Collectors.toList());
    }

    public void addCasa(CasaInteligente ci)
    {
        this.casas.add(ci);
    }

    public void addComercializador(ComercializadorEnergia ce){
        this.comercializadores.add(ce);
    }
    /**
     *
     * Método que atualiza fatura dos comercializadores
     * Calcula o consumo total de cada comercializador
     * Calcula qual c
     */
    public void simular(int dias)
    {
        //Atualizar fatura comercializadores
        //calcular consumo total de cada comercializador
        //calcular qual c
    }

    /**
     * Método que devolve o comercializador com o maior volume de fatura
     * @return Comercializador do comercializador
     */
    public ComercializadorEnergia ComercializadorComMaiorFatura()
    {
        Comparator<ComercializadorEnergia> c = (e1, e2) -> (int) (e2.getVolumeFatura() - e1.getVolumeFatura());
        return this.comercializadores.stream().sorted(c).findFirst().orElse(null);
    }

    //Todas as faturas de um dado comercializador
    /**
     * Método que devolve todas as faturas de um dado comercializador
     * @return Lista de (String)faturas do dado comercializador
     */
    public List<String> faturasComercializador (String comercializador)
    {
        for (ComercializadorEnergia ce : this.comercializadores)
        {
            if (ce.getNome().equals(comercializador))
            {
                return ce.getFaturas();
            }
        }
        return null;
    }


    //Casa com maior gasto
    /**
     * Método que calcula a casa com maior gasto energético.
     * @return CasaInteligente com o nome da casa.
     */
    public CasaInteligente casaMaiorGasto()
    {
        // temos de ver por qual o argumento que queremos ordenar
        Comparator<CasaInteligente> c = (e1, e2) -> (int) (e2.custoDiario() - e1.custoDiario());
        CasaInteligente ret = this.casas.stream().sorted(c).findFirst().orElse(null);
        return ret;
    }

    // dar uma ordenacao dos maiores consumidores de energia durante um periodo a determinar
    /**
     * Método que devolve os maiores consumidores de energia durante um período ordenados.
     * @return List ordenada pelos maiores consumidores.
     */
    public List<ComercializadorEnergia> ordenacaoMaioresConsumidoresEnergia(int tempo)
    {
        Comparator<ComercializadorEnergia> c = (e1, e2) -> (int) (e2.getVolumeFatura() - e1.getVolumeFatura());
        return this.comercializadores.stream().sorted(c).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Simulacao{" +
                "casas=" + casas +
                ", comercializadores=" + comercializadores +
                '}';
    }

    /*
    area de criar todas as funções que iremos precisar para alterar coisas q o utilizador pediu
    IMPORTANTE PARA 18 valores

    public int funcoesDeAlteracoes()
    {

    }
    IMPORTANTE!!!!!!
    IMPORTANTE!!!!!
    IMPORTANTE!!!!
    IMPORTANTE!!!
    IMPORTANTE!!
    IMPORTANTE!
    IMPORTANTE
    IMPORTANTE!
    IMPORTANTE!!
    IMPORTANTE!!!
    IMPORTANTE!!!!


     */

}
