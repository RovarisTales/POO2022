 

/*********************************************************************************/
/** DISCLAIMER: Este código foi criado e alterado durante as aulas práticas      */
/** de POO. Representa uma solução em construção, com base na matéria leccionada */ 
/** até ao momento da sua elaboração, e resulta da discussão e experimentação    */
/** durante as aulas. Como tal, não deverá ser visto como uma solução canónica,  */
/** ou mesmo acabada. É disponibilizado para auxiliar o processo de estudo.      */
/** Os alunos são encorajados a testar adequadamente o código fornecido e a      */
/** procurar soluções alternativas, à medida que forem adquirindo mais           */
/** conhecimentos de POO.                                                        */
/*********************************************************************************/

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;


/**
 * A CasaInteligente faz a gestão dos SmartDevices que existem e dos 
 * espaços (as salas) que existem na casa.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class  CasaInteligente implements Serializable
{
    //variáveis de instância
    private String proprietario;
    private String morada;
    private int NIF;
    private Map<String, SmartDevice> devices; // identificador -> SmartDevice
    private Map<String, List<String>> locations; // Espaço -> Lista codigo dos devices
    private String comercializadorEn;
    private double gastoCasa;
    private double gastoEnergia;

    private double gastoSimulacao;
    /**
     * Construtor por omissão de CasaInteligente.
     */
    public CasaInteligente()
    {
        this.proprietario = "";
        this.morada = "";
        this.NIF = 0;
        this.devices = new HashMap<>();
        this.locations = new HashMap<>();
        this.comercializadorEn = "";
        this.gastoCasa = 0;

    }
    /**
     * Construtor parametrizado de Casa inteligente.
     * Aceita como parâmetros o valor da morada
     */
    public CasaInteligente(String morada){
        this.proprietario = "";
        this.morada = morada;
        this.NIF = 0;
        this.devices = new HashMap<>();
        this.locations = new HashMap<>();
        this.comercializadorEn = "";
        this.gastoCasa = 0;
    }

    /**
     * Construtor parametrizado de CasaInteligente.
     * Aceita como parâmetros o nome do proprietario, a morada, o Nif , a estrutura de dados devices, a estrutura de dados locations, e o nome do comercializador de energia
     *
     */
    public CasaInteligente(String proprietario, String morada, int NIF, Map<String, SmartDevice> devices, Map<String, List<String>> locations, String comercializadorEn,double gasto)
    {
        this.proprietario = proprietario;
        this.morada = morada;
        this.NIF = NIF;
        this.devices = devices.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,e-> e.getValue().clone()));
        this.locations = locations.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),e-> e.getValue()));
        this.comercializadorEn = comercializadorEn;
        this.gastoCasa = gasto;
    }

    /**
     * Construtor parametrizado de SmartCamera.
     * Aceita como parâmetros o nome do proprietario  o endereço da morada
     * o nif e o nome do comercializador de energia
     */
    public CasaInteligente(String proprietario, String morada, int NIF, String comercializadorEn,double gastoCasa)
    {
        this.proprietario = proprietario;
        this.morada = morada;
        this.NIF = NIF;
        this.comercializadorEn = comercializadorEn;
        this.devices = new HashMap<>();
        this.locations = new HashMap<>();
        this.gastoCasa = gastoCasa;
    }

    public CasaInteligente(CasaInteligente umaCasa)
    {
        this.proprietario = umaCasa.getProprietario();
        this.morada = umaCasa.getMorada();
        this.NIF = umaCasa.getNIF();
        this.comercializadorEn = umaCasa.getComercializadorEn();
        this.devices = umaCasa.getDevices();
        this.locations = umaCasa.getLocations();
        this.gastoCasa = umaCasa.getGastoCasa();

    }

    /**
     * métodos de instância
     */

    public double getGastoCasa() {
        return gastoCasa;
    }

    public double getGastoEnergia() {
        return gastoCasa;
    }


    public void setGastoEnergia(double gastoEnergia) {
        this.gastoEnergia= gastoEnergia;
    }

    public void setGastoCasa(double gastoCasa) {
        this.gastoCasa = gastoCasa;
    }

    public String getMorada()
    {
        return this.morada;
    }

    public void setMorada(String morada)
    {
        this.morada = morada;
    }

    public double getGastoSimulacao()
    {
        return gastoSimulacao;
    }

    public void setGastoSimulacao(double gastoSimulacao)
    {
        this.gastoSimulacao = gastoSimulacao;
    }
    public Map<String,SmartDevice> getDevices()
    {
        if (this.devices == null) {

            return null;
        }
        return this.devices.entrySet()
                .stream()
                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue().clone()));
    }

    public void setDevices(Map<String, SmartDevice> devices)
    {
        this.devices = devices.entrySet()
                .stream()
                .collect(Collectors.toMap(e->e.getKey(), e->e.getValue().clone(), (a,b) -> b, HashMap::new));
    }

    public Map<String, List<String>> getLocations()
    {
        if (this.locations == null) return null;
        return this.locations.entrySet().stream().collect(Collectors.toMap(e-> e.getKey(),e->new ArrayList<>(e.getValue())));
    }

    public void setLocations(Map<String, List<String>> locations)
    {
        this.locations = locations;
    }

    public double custoDiario()
    {
        return this.devices.values().stream().mapToDouble(e-> e.custoEnergia()).sum();
    }
    /**
     * Devolve o nome do proprietario
     *
     * @return nome do proprietario
     */
    public String getProprietario()
    {
        return proprietario;
    }

    /**
     * Actualiza o nome do proprietario
     *
     * @param proprietario novo nome do proprietario
     */
    public void setProprietario(String proprietario)
    {
        this.proprietario = proprietario;
    }

    /**
     * Devolve o nif do proprietario da casa inteligente
     *
     * @return nif do proprietario da casa inteligente
     */
    public int getNIF()
    {
        return this.NIF;
    }

    /**
     * Actualiza o nif do proprietario
     *
     * @param NIF novo nif do proprietario
     */
    public void setNIF(int NIF)
    {
        this.NIF = NIF;
    }

    /**
     * Devolve o nome do comercializador de energia
     *
     * @return nome do comercializador de energia
     */
    public String getComercializadorEn()
    {
        return comercializadorEn;
    }

    /**
     * Actualiza o comercializador de energia
     *
     * @param comercializadorEn novo comercializador de energia
     */
    public void setComercializadorEn(String comercializadorEn)
    {
        this.comercializadorEn = comercializadorEn;
    }

    /**
     * Liga o device que tem o id igual a o parametro devCode
     *
     * @param devCode id do device que queremos ligar
     */
    public void setDeviceOn(String devCode)
    {
        this.devices.get(devCode).turnOn();
    }

    /**
     * Desliga o device que tem o id igual a o parametro devCode
     *
     * @param devCode id do device que queremos desligar
     */
    public void setDeviceOff(String devCode)
    {
        this.devices.get(devCode).turnOff();
    }
    /**
     * Diz se existe o device de id igual a o parametro id
     *
     * @param id id do device que queremos saber se existe
     *
     * @return verdadeiro ou falso, se existe ou não o dispositivo
     */
    public boolean existsDevice(String id)
    {
        return this.devices.containsKey(id);
    }

    /**
     * Adiciona o device que recebe como argumentos no hashmap devices
     *
     * @param s , smart device que queremos adicionar
     *
     */
    public void addDevice(SmartDevice s)
    {
        this.devices.put(s.getID(),s.clone());
    }

    /**
     * Da o smartDevice de id s ou se não existir retorna null
     *
     * @param s , id do smartDevice
     *
     * @return o SmartDevice de id igual a String s que recebemos como parametro
     */
    public SmartDevice getDevice(String s)
    {
        return this.devices.getOrDefault(s,null);
    }

    /**
     * coloca como parametro on o boolean b no device de id igual a s
     *
     * @param s,b s é o id do smart device que queremos ligar e b é se queremos ligar como verdadeiro ou falso
     *
     */
    public void setOn(String s, boolean b)
    {
        for (SmartDevice sd : this.devices.values())
        {
            if (s.equals(sd.getID())) sd.setOn(b);
        }
    }

    /**
     * coloca como parametro on o boolean b em todos os devices que pertencem a cas inteligente
     *
     * @param b , b é o parametro no qual queremos ligar os devices
     *
     */
    public void setAllOn(boolean b)
    {
        for (SmartDevice sd : this.devices.values())
        {
            sd.setOn(b);
        }
    }
    /**
     * adiciona um quarto a o hashmap locations
     *
     * @param s , nome do novo quarto que adicionamos
     *
     */
    public void addRoom(String s)
    {
        this.locations.put(s,new ArrayList<>());
    }
    /**
     * Verifica se existe o quarto s na casaInteligente
     *
     * @param s , nome do  quarto que queremos saber se pertence a locations
     *
     * @return se existe ou não esse quarto
     */
    public boolean hasRoom(String s)
    {
        for (String e : this.locations.keySet()){
            if (s.equals(e)){
                return true;
            }
        }
        return false;
    }
    /**
     * Adiciona a o quarto s1 o device com id s2
     *
     * @param sala,device sala é  nome do quarto e device o id do device
     *
     */
    public void addToRoom (String sala, String device)
    {
        this.locations.get(sala).add(device);
        this.gastoCasa = this.gastoCasa + this.devices.get(device).getCustoInstalation();
        /*
        List<String> l = this.locations.get(s1);
        l.add(s2);
        */
    }
    /**
     * Verifica se o quarto de nome s1 contém o device de id s2
     *
     * @param sala,device sala é  nome do quarto e device o id do device
     *
     * @return Se contém ou não
     */
    public boolean roomHasDevice (String sala, String device)
    {
        return this.locations.get(sala).contains(device);
        /*
        List<String> l = this.locations.get(s1);
        return l.contains(s2);
         */
    }

    /**
     * Ligar e desligar todos os dispositivos de uma divisao
     * @param b
     */

    public void setAllOnOrOffRoom(String quarto,boolean b)
    {
        /*for(String id : locations.get(quarto)){
            devices.get(id).setOn(b);
        }*/

        this.locations.get(quarto).forEach(id -> devices.get(id).setOn(b));
    }

    /**
     * Ligar e desligar todos os dispositivos da casaInteligente
     * @param b
     */
    public void setAllOnOrOffCasa(boolean b)
    {
        for(String quartos : locations.keySet()){
            setAllOnOrOffRoom(quartos,b);
        }
    }


    public CasaInteligente clone()
    {
        return new CasaInteligente(this);
    }

    @Override
    public String toString()
    {
        return "CasaInteligente{" +
                "proprietario='" + proprietario + '\'' +
                ", morada='" + morada + '\'' +
                ", NIF=" + NIF +
                ", devices=" + devices +
                ", locations=" + locations +
                ", comercializadorEn='" + comercializadorEn + '\'' +
                ", gastoCasa='" + gastoCasa +  '\'' +
                '}';
    }

    public String whereIsDevice(SmartDevice sd){
        for (String s : this.locations.keySet()){
            if (roomHasDevice(s,sd.getID())){
                return s;
            }
        }
        return null;
    }


    /**
     * Calcula o preco diario de energia
     *
     * @param o, o objecto que iremos comparar
     *
     * @return se é igual ou não
     */
    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CasaInteligente that = (CasaInteligente) o;

        return NIF == that.getNIF() && this.proprietario.equals(that.getProprietario())
                && this.morada.equals(that.getMorada()) && this.devices.equals(that.getDevices())
                && this.locations.equals(that.getLocations())
                && this.comercializadorEn.equals(that.getComercializadorEn())
                && this.gastoCasa  == that.getGastoCasa();
    }
}
