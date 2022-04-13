 

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

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.stream.Collectors;


/**
 * A CasaInteligente faz a gestão dos SmartDevices que existem e dos 
 * espaços (as salas) que existem na casa.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CasaInteligente
{
    //variáveis de instância
    private String proprietario;
    private String morada;
    private int NIF;
    private Map<String, SmartDevice> devices; // identificador -> SmartDevice
    private Map<String, List<String>> locations; // Espaço -> Lista codigo dos devices
    private String comercializadorEn;

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

    }

    public CasaInteligente(String morada){
        this.proprietario = "";
        this.morada = morada;
        this.NIF = 0;
        this.devices = new HashMap<>();
        this.locations = new HashMap<>();
        this.comercializadorEn = "";
    }

    /**
     * Construtor parametrizado de CasaInteligente.
     * Aceita como parâmetros o nome do proprietario, a morada, o Nif , a estrutura de dados devices, a estrutura de dados locations, e o nome do comercializador de energia
     *
     */
    public CasaInteligente(String proprietario, String morada, int NIF, Map<String, SmartDevice> devices, Map<String, List<String>> locations, String comercializadorEn)
    {
        this.proprietario = proprietario;
        this.morada = morada;
        this.NIF = NIF;
        this.devices = devices.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,e-> e.getValue().clone()));
        this.locations = locations.entrySet().stream().collect(Collectors.toMap(e->e.getKey(),e-> e.getValue()));
        this.comercializadorEn = comercializadorEn;
    }

    public CasaInteligente(String proprietario, String morada, int NIF, String comercializadorEn)
    {
        this.proprietario = proprietario;
        this.morada = morada;
        this.NIF = NIF;
        this.comercializadorEn = comercializadorEn;
        this.devices = new HashMap<>();
        this.locations = new HashMap<>();
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public int getNIF() {
        return NIF;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    public String getComercializadorEn() {
        return comercializadorEn;
    }

    public void setComercializadorEn(String comercializadorEn) {
        this.comercializadorEn = comercializadorEn;
    }

    /**
     * Constructor for objects of class CasaInteligente
     */
    
    public void setDeviceOn(String devCode) {
        this.devices.get(devCode).turnOn();
    }

    public void setDeviceOff(String devCode) {
        this.devices.get(devCode).turnOff();
    }
    
    public boolean existsDevice(String id) {
        return this.devices.containsKey(id);
    }
    
    public void addDevice(SmartDevice s) {
        this.devices.put(s.getID(),s.clone());
    }
    
    public SmartDevice getDevice(String s) {
        return this.devices.getOrDefault(s,null);
    }
    
    public void setOn(String s, boolean b) {
        for (SmartDevice sd : this.devices.values()){
            if (s.equals(sd.getID())) sd.setOn(true);
        }
    }
    
    public void setAllOn(boolean b) {
        for (SmartDevice sd : this.devices.values()){
            sd.setOn(b);
        }
    }
    
    public void addRoom(String s) {
        this.locations.put(s,new ArrayList<>());
    }
    
    public boolean hasRoom(String s) {
        for (String e : this.locations.keySet()){
            if (s.equals(e)){
                return true;
            }
        }
        return false;
    }
    
    public void addToRoom (String s1, String s2) {
        List<String> l = this.locations.get(s1);
        l.add(s2);
    }
    
    public boolean roomHasDevice (String s1, String s2)
    {
        List<String> l = this.locations.get(s1);
        return l.contains(s2);
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


}
