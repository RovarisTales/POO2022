 

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

    /**
     * Construtor parametrizado de SmartCamera.
     * Aceita como parâmetros o nome do proprietario  o endereço da morada
     * o nif e o nome do comercializador de energia
     */
    public CasaInteligente(String proprietario, String morada, int NIF, String comercializadorEn)
    {
        this.proprietario = proprietario;
        this.morada = morada;
        this.NIF = NIF;
        this.comercializadorEn = comercializadorEn;
        this.devices = new HashMap<>();
        this.locations = new HashMap<>();
    }

    /**
     * métodos de instância
     */

    /**
     * Devolve o nome do proprietario
     *
     * @return nome do proprietario
     */
    public String getProprietario() {
        return proprietario;
    }

    /**
     * Actualiza o nome do proprietario
     *
     * @param proprietario novo nome do proprietario
     */
    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    /**
     * Devolve o nif do proprietario da casa inteligente
     *
     * @return nif do proprietario da casa inteligente
     */
    public int getNIF() {
        return NIF;
    }

    /**
     * Actualiza o nif do proprietario
     *
     * @param NIF novo nif do proprietario
     */
    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    /**
     * Devolve o nome do comercializador de energia
     *
     * @return nome do comercializador de energia
     */
    public String getComercializadorEn() {
        return comercializadorEn;
    }

    /**
     * Actualiza o comercializador de energia
     *
     * @param comercializadorEn novo comercializador de energia
     */
    public void setComercializadorEn(String comercializadorEn) {
        this.comercializadorEn = comercializadorEn;
    }

    /**
     * Liga o device que tem o id igual a o parametro devCode
     *
     * @param devCode id do device que queremos ligar
     */
    public void setDeviceOn(String devCode) {
        this.devices.get(devCode).turnOn();
    }

    /**
     * Desliga o device que tem o id igual a o parametro devCode
     *
     * @param devCode id do device que queremos desligar
     */
    public void setDeviceOff(String devCode) {
        this.devices.get(devCode).turnOff();
    }
    /**
     * Diz se existe o device de id igual a o parametro id
     *
     * @param id id do device que queremos saber se existe
     *
     * @return verdadeiro ou falso, se existe ou não o dispositivo
     */
    public boolean existsDevice(String id) {
        return this.devices.containsKey(id);
    }

    /**
     * Adiciona o device que recebe como argumentos no hashmap devices
     *
     * @param s , smart device que queremos adicionar
     *
     */
    public void addDevice(SmartDevice s) {
        this.devices.put(s.getID(),s.clone());
    }

    /**
     * Da o smartDevice de id s ou se não existir retorna null
     *
     * @param s , id do smartDevice
     *
     * @return o SmartDevice de id igual a String s que recebemos como parametro
     */
    public SmartDevice getDevice(String s) {
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
        for (SmartDevice sd : this.devices.values()){
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
        for (SmartDevice sd : this.devices.values()){
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
     * @param s1,s2 s1 é  nome do quarto e s2 o id do device
     *
     */
    public void addToRoom (String s1, String s2)
    {
        this.locations.get(s1).add(s2);
        /*
        List<String> l = this.locations.get(s1);
        l.add(s2);
        */
    }
    /**
     * Verifica se o quarto de nome s1 contém o device de id s2
     *
     * @param s1,s2 s1 é  nome do quarto e s2 o id do device
     *
     * @return Se contém ou não
     */
    public boolean roomHasDevice (String s1, String s2)
    {
        return this.locations.get(s1).contains(s2);
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
    public void setAllOnOrOffCasa(boolean b){
        for(String quartos : locations.keySet()){
            setAllOnOrOffRoom(quartos,b);
        }
    }

}
