import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;
import java.time.Month;

import static java.time.LocalDateTime.now;

public class Simulacao
{
    private Map<Integer, CasaInteligente> casas;
    private Map<String,ComercializadorEnergia> comercializadores;
    private LocalDateTime dia;
    private Map<String,Marca> marcas;


    /**
     * Construtor por omissão de Simulacao.
     */
    public Simulacao()
    {
        this.casas = new HashMap<>();
        this.comercializadores = new HashMap<>();
        this.dia = now();
        this.marcas = new HashMap<>();
    }

    /**
     * Construtor parametrizado com o nome do ficheiro que queremos ler
     * para fazer as configurações do programa.
     */
    public Simulacao(String filename) throws FileNotFoundException
    {
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        this.casas = new HashMap<>();
        this.comercializadores = new HashMap<>();
        this.dia = LocalDateTime.of(0, Month.JANUARY, 1, 1, 1, 1);
        this.marcas = new HashMap<>();
        this.lerArquivo(filename);

    }

    public void lerArquivo(String filename) throws FileNotFoundException
    {
        File myObj = new File(filename);
        Scanner myReader = new Scanner(myObj);
        String linha = myReader.nextLine();
        this.dia = LocalDateTime.of(0,Integer.parseInt(linha.split("/")[1]), Integer.parseInt(linha.split("/")[0]), 1, 1, 1);
        String inicio = myReader.nextLine();
        String[] dividida;
        while (!inicio.equals("Casas"))
        {
            dividida = inicio.split(",");
            ComercializadorEnergia ce = new ComercializadorEnergia(dividida[0].split("=")[1]
                    , Double.parseDouble(dividida[1].split("=")[1]), Double.parseDouble(dividida[2].split("=")[1])
                    , new ArrayList<String>());
            String fat[] = myReader.nextLine().split(",");
            for (String fats : fat)
            {
                ce.addFatura(fats);

            }
            this.addComercializador(ce);
            inicio = myReader.nextLine();
        }
        inicio = myReader.nextLine();
        while (!inicio.equals("EndOfFile"))
        {
            dividida = inicio.split(",");
            CasaInteligente ci = new CasaInteligente(dividida[0].split("=")[1]
                    , dividida[1].split("=")[1], Integer.parseInt(dividida[2].split("=")[1])
                    , new HashMap<>(), new HashMap<>(), dividida[3].split("=")[1] , Double.parseDouble(dividida[4].split("=")[1] ));
            inicio = myReader.nextLine();
            dividida = inicio.split(";");
            for (int i = 0 ; i < dividida.length ; i++)
            {
                String[] div2 = dividida[i].split(" ");
                switch (div2[0])
                {
                    case("SmartCamera"):
                        SmartCamera sc = new SmartCamera(div2[1].split("=")[1],Boolean.parseBoolean(div2[2].split("=")[1]),
                                Double.parseDouble(div2[3].split("=")[1]),Double.parseDouble(div2[4].split("=")[1])
                                , Double.parseDouble(div2[5].split("=")[1]));
                        ci.addDevice(sc);
                        break;
                    case("SmartBulb"):
                        SmartBulb sb = new SmartBulb(div2[1].split("=")[1],Boolean.parseBoolean(div2[2].split("=")[1]),
                                Double.parseDouble(div2[3].split("=")[1]),Integer.parseInt(div2[4].split("=")[1])
                                , Integer.parseInt(div2[5].split("=")[1]),Integer.parseInt(div2[6].split("=")[1]));
                        ci.addDevice(sb);
                        break;
                    case("SmartSpeaker"):
                        Marca marca = new Marca(div2[6].split("=")[1]
                                , Integer.parseInt(div2[7].split("=")[1]));
                        this.addMarca(marca);
                        SmartSpeaker sp = new SmartSpeaker(div2[1].split("=")[1],Boolean.parseBoolean(div2[2].split("=")[1]),
                                Double.parseDouble(div2[3].split("=")[1]),Integer.parseInt(div2[4].split("=")[1])
                                , (div2[5].split("=")[1]));
                        sp.setMarca(marca);
                        ci.addDevice(sp);
                        break;
                }
            }
            inicio = myReader.nextLine();
            dividida = inicio.split(";");
            for (int j = 0 ; j < dividida.length ; j++)
            {
                String[] div2 = dividida[j].split(" ");
                ci.addRoom(div2[0]);

                for (int a = 1 ; a < div2.length ; a ++)
                {
                    ci.addToRoom(div2[0],div2[a]);
                }
            }
            this.addCasa(ci);
            inicio = myReader.nextLine();

        }
        System.out.println(this.comercializadores);
        System.out.println(this.casas);
    }
    
    
    //FIZ NADA KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK
        //FIZ NADA KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK

        //FIZ NADA KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK

        //FIZ NADA KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK

        //FIZ NADA KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK

        //FIZ NADA KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK

        //FIZ NADA KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK

        //FIZ NADA KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK
    //FIZ NADA KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK
    //FIZ NADA KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK
    //FIZ NADA KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK

        //FIZ NADA KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK
    //FIZ NADA KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK
    //FIZ NADA KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK

        //FIZ NADA KKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKK

    public void salvar () throws IOException
    {
        File myObj = new File("anterior.txt");
        FileWriter fw = new FileWriter("anterior.txt");
        fw.write(this.dia.getDayOfMonth()  + "/" + this.dia.getMonthValue());
        fw.write("\n");
        for (ComercializadorEnergia ce : this.comercializadores.values())
        {
            fw.write("nome=" + ce.getNome() +",CustoDiarioEner=" + ce.getCustoDiarioEner()
                    +",VolumeFatura=" + ce.getVolumeFatura() + "\n");
            for (String fatura : ce.getFaturas())
            {
                fw.write(fatura + " ");
                fw.write(",");
            }
            fw.write("\n");
        }
        fw.write("Casas\n");
        for (CasaInteligente ci : this.casas.values())
        {
            fw.write("Proprietario=" + ci.getProprietario() +",Morada=" + ci.getMorada()
                    + ",Nif=" + ci.getNIF() +",ComercializadorEn=" + ci.getComercializadorEn()
                    + ",GastoCasa=" + ci.getGastoCasa() + "\n");
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
                                + " CustoDiario=" + sb.getCustoDiario()+ ";");
                        break;
                    case ("SmartSpeaker"):
                        SmartSpeaker sp= (SmartSpeaker) device;
                        fw.write("SmartSpeaker Id=" + sp.getID() +" On=" + sp.getOn() +
                                " CustoInstallation=" + sp.getCustoInstalation()
                                + " Volume=" + sp.getVolume() + " Canal=" + sp.getChannel()
                                + " Marca=" + sp.getMarca().getNome() + " Custo=" + sp.getMarca().getCusto()+ ";");
                        break;
                    case ("SmartCamera"):
                        SmartCamera sc= (SmartCamera) device;
                        fw.write("SmartCamera Id=" + sc.getID() +" On=" + sc.getOn() +
                                " CustoInstallation=" + sc.getCustoInstalation()
                                + " Resolucao=" + sc.getResolucao() + " TamanhoFicheiro=" + sc.getTamanho_ficheiro()+ ";");
                        break;
                    default:
                        break;
                }
            }
            fw.write("\n");
            Map<String,List<String>> l = ci.getLocations();
            for (String quarto : l.keySet())
            {
                fw.write(quarto);
                for (String ids : l.get(quarto))
                {
                    fw.write(" " + ids );
                }
                fw.write(";");

            }
            fw.write("\n");
        }
        fw.write("EndOfFile");
        fw.close();
    }

    /**
     * Métodos de instância
     */

    /**
     * Getters e setters
     */
    public void setMarcas(Map<String, Marca> marcas) {
        this.marcas = marcas;
    }

    public Map<String,Marca> getMarcas() {
        return marcas;
    }
    public Map<Integer,CasaInteligente> getCasas()
    {
        return this.casas.entrySet()
                .stream()
                .collect(Collectors.toMap(e-> e.getKey(), e-> e.getValue().clone()));
    }

    public void setCasas(Map<Integer,CasaInteligente> casas)
    {
        this.casas = casas.entrySet()
                .stream().collect(Collectors.toMap(Map.Entry::getKey, e-> e.getValue().clone()));
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
    public void addMarca(Marca m){
        this.marcas.put(m.getNome(),m);
    }
    public void addCasa(CasaInteligente ci)
    {
        this.casas.put(ci.getNIF (),ci);
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
        for (CasaInteligente ci : this.casas.values())
        {
           String comercializador =  ci.getComercializadorEn();
           ComercializadorEnergia ce = this.comercializadores.get(comercializador);
           double preco = dias * ce.preçoDiaDisp(ci.custoDiario());
           ce.setVolumeFatura(ce.getVolumeFatura() + preco);
           ci.setGastoCasa(ci.getGastoCasa() + preco);
           ci.setGastoEnergia(ci.getGastoEnergia() +  ci.custoDiario() * dias);
           ci.setGastoSimulacao(preco);
           ce.addFatura(ci.getNIF(),ci.getMorada(),ci.getProprietario(),preco ,dia.getDayOfMonth(),dia.getDayOfMonth()+dias );

        }
        dia = dia.plusDays(dias);
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
        CasaInteligente ret = this.casas.values().stream().sorted(c).findFirst().orElse(null);
        return ret;
    }

    // dar uma ordenacao dos maiores consumidores de energia durante um periodo a determinar
    /**
     * Método que devolve os maiores consumidores de energia durante um período ordenados.
     * @return List ordenada pelos maiores consumidores.
     */
    public List<CasaInteligente> ordenacaoMaioresConsumidoresEnergia()
    {
        //TODO criar essa  variavel
        Comparator<CasaInteligente> c = (e1, e2) -> (int) (e2.getGastoEnergia() - e1.getGastoEnergia());
        return this.casas.values().stream().sorted(c).collect(Collectors.toList());
    }

    @Override
    public String toString()
    {
        return "Simulacao{" +
                "casas=" + casas +
                ", comercializadores=" + comercializadores +
                '}';
    }

}
