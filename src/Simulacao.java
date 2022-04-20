import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Simulacao
{
    List<CasaInteligente> casas;
    Map<String,ComercializadorEnergia> comercializadores;
    //TODO VARIAVEL LOCAL DATE TIME o dia

    /**
     * Construtor por omissão de Simulacao.
     */
    public Simulacao()
    {
        this.casas = new ArrayList<>();
        this.comercializadores = new HashMap<>();
        //TODO iniciar a variavel O DIA

    }

    /**
     * Construtor parametrizado com o nome do ficheiro que queremos ler
     * para fazer as configurações do programa.
     */
    public Simulacao(String filename) throws FileNotFoundException
    {
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        this.casas = new ArrayList<>();
        this.comercializadores = new HashMap<>();
        this.lerArquivo(filename);
        //TODO iniciar a variavel
    }

    public void lerArquivo(String filename) throws FileNotFoundException
    {
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        int count = 0;
        while ()
        while (myReader.hasNextLine())
        {
            String linha = myReader.nextLine();
            if (valores.length != 1 )
            {
                if (linha.equals("Comercializadores"))
                {
                    linha = myReader.nextLine();
                    String[] valores = myReader.nextLine().split("\\|");
                    for (int i = 1; i< valores.length; i = i+4)
                    {
                        ComercializadorEnergia ce = new ComercializadorEnergia(valores[i].split("=")[1]
                                ,Double.parseDouble(valores[i+1].split("=")[1]),Double.parseDouble(valores[i+2].split("=")[1])
                                ,new ArrayList<String>());
                        while ()
                        this.addComercializador(ce);
                    }
                    System.out.println(this.comercializadores);

                }
                else if (valores[0].equals("Casas"))
                {
                    for (int i = 1; i< valores.length; i = i+4)
                    {
                        Map<String,SmartDevice> devices = new HashMap<>();
                        Map<String, List<String>> locations = new HashMap<>();

                        CasaInteligente ci = new CasaInteligente(valores[i].split("=")[1]
                                ,valores[i+1].split("=")[1],Integer.parseInt(valores[i+2].split("=")[1])
                                ,valores[i+3].split("=")[1]
                                ,Double.parseDouble(valores[i+4].split("=")[1]));
                        this.addCasa(ci);
                    }
                }

            }
        }
    }
    /*
    TALVEZ CRIAR UMA CLASSE PRA SALVAR E LER
     */
    public void salvar () throws IOException
    {
        File myObj = new File("anterior.txt");
        FileWriter fw = new FileWriter("anterior.txt");
        fw.write("Comercializadores ");
        for (ComercializadorEnergia ce : this.comercializadores.values())
        {
            fw.write("nome=" + ce.getNome() +"|CustoDiarioEner=" + ce.getCustoDiarioEner()
                    +"|VolumeFatura=" + ce.getVolumeFatura() + "\n");
            for (String fatura : ce.getFaturas())
            {
                fw.write(fatura + " ");
                fw.write("\n");
            }
        }
        fw.write("\n");
        fw.write("Casas ");
        for (CasaInteligente ci : this.casas)
        {
            fw.write("Proprietario=" + ci.getProprietario() +"|Morada=" + ci.getMorada()
                    + "|Nif=" + ci.getNIF() +"|ComercializadorEn=" + ci.getComercializadorEn()
                    + "|GastoCasa=" + ci.getGastoCasa() + "\nDevices:\n");
            Map<String,SmartDevice> sd = ci.getDevices();
            for (String id : sd.keySet())
            {
                SmartDevice device = sd.get(id);
                switch (device.getClass().getSimpleName())
                {

                    case ("SmartBulb"):
                        SmartBulb sb= (SmartBulb) device;
                        fw.write("SmartBulb Id=" + sb.getID() + " On=" + sb.getOn() +
                                " CustoInstallation=" + sb.getCustoInstalation()+ " tone=" + sb.getTone() + " Dimensao=" +sb.getTone()
                                + " CustoDiario=" + sb.getCustoDiario()+ "\n");
                        break;
                    case ("SmartSpeaker"):
                        SmartSpeaker sp= (SmartSpeaker) device;
                        fw.write("SmartSpeaker Id=" + sp.getID() +" On=" + sp.getOn() +
                                " CustoInstallation=" + sp.getCustoInstalation()
                                + " Volume=" + sp.getVolume() + " Canal=" + sp.getChannel()
                                + " Marca=" + sp.getMarca().getNome() + " Custo=" + sp.getMarca().getCusto()+ "\n");
                        break;
                    case ("SmartCamera"):
                        SmartCamera sc= (SmartCamera) device;
                        fw.write("SmartCamera Id=" + sc.getID() +" On=" + sc.getOn() +
                                " CustoInstallation=" + sc.getCustoInstalation()
                                + " Resolucao=" + sc.getResolucao() + " TamanhoFicheiro=" + sc.getTamanho_ficheiro()+ "\n");
                        break;
                    default:
                        break;
                }
            }
            fw.write("Locations: ");
            Map<String,List<String>> l = ci.getLocations();
            for (String quarto : l.keySet())
            {
                fw.write(quarto);
                /*
                l.get(quarto).forEach( e -> {
                    try {
                        fw.write(" " + e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });
                 */
                for (String ids : l.get(quarto))
                {
                    fw.write(" " + ids + " ");
                }

            }
            fw.write("\n");

        }
       fw.close();
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

    public Map<String,ComercializadorEnergia> getComercializadores()
    {
        return this.comercializadores.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e-> e.getValue().clone()));
    }

    public void setComercializadores(Map<String,ComercializadorEnergia> comercializadores)
    {
        this.comercializadores = comercializadores.entrySet()
                .stream().collect(Collectors.toMap(Map.Entry::getKey, e-> e.getValue().clone()));
    }

    public void addCasa(CasaInteligente ci)
    {
        this.casas.add(ci);
    }

    public void addComercializador(ComercializadorEnergia ce){
        this.comercializadores.put(ce.getNome(),ce);
    }
    /**
     *
     * Método que atualiza fatura dos comercializadores
     * Calcula o consumo total de cada comercializador
     */
    public void simular(int dias)
    {
        for (CasaInteligente ci : this.casas)
        {
           String comercializador =  ci.getComercializadorEn();
           ComercializadorEnergia ce = this.comercializadores.get(comercializador);
           double preco = dias * ce.preçoDiaDisp(ci.custoDiario());
           ce.setVolumeFatura(ce.getVolumeFatura() + preco);
           ci.setGastoCasa(ci.getGastoCasa() + preco);
           //TODO FAZER LOCAL DATE TIME e atualizar com o tempo pra colocar no fatura
           int dia3 = 0;
           ce.addFatura(ci.getNIF(),ci.getMorada(),ci.getProprietario(),preco ,dia3, dia3 + dias);
        }
    }

    /**
     * Método que devolve o comercializador com o maior volume de fatura
     * @return Comercializador do comercializador
     */
    public ComercializadorEnergia ComercializadorComMaiorFatura()
    {
        Comparator<ComercializadorEnergia> c = (e1, e2) -> (int) (e2.getVolumeFatura() - e1.getVolumeFatura());
        return this.comercializadores.values().stream().sorted(c).findFirst().orElse(null);
    }

    //Todas as faturas de um dado comercializador
    /**
     * Método que devolve todas as faturas de um dado comercializador
     * @return Lista de (String)faturas do dado comercializador
     */
    public List<String> faturasComercializador (String comercializador)
    {
        for (ComercializadorEnergia ce : this.comercializadores.values())
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
        return this.comercializadores.values().stream().sorted(c).collect(Collectors.toList());
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
