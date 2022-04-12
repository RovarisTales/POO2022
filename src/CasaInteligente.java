 

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


/**
 * A CasaInteligente faz a gestão dos SmartDevices que existem e dos 
 * espaços (as salas) que existem na casa.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CasaInteligente {

    private String proprietario;
    private String morada;
    private int NIF;
    private Map<String, SmartDevice> devices; // identificador -> SmartDevice
    private Map<String, List<String>> locations; // Espaço -> Lista codigo dos devices
    private String comercializadorEn;

    /**
     * Constructor for objects of class CasaInteligente
     */
    public CasaInteligente() {
        // initialise instance variables
        this.morada = "";
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    public CasaInteligente(String morada) {
        // initialise instance variables
        this.morada = morada;
        this.devices = new HashMap();
        this.locations = new HashMap();
    }

    
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
    
    public boolean roomHasDevice (String s1, String s2) {
        List<String> l = this.locations.get(s1);
        return l.contains(s2);
    }

    /**
     * Ligar e desligar todos os dispositivos de uma divisao
     * @param b
     */

    public void setAllOnRoom(boolean b) {

    }

    public void setAllOffRoom(boolean b) {

    }
    
}
