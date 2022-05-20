import java.io.Serializable;
import java.util.Objects;

/**
 * A classe SmartDevice é um contactor simples.
 * Permite ligar ou desligar circuitos. 
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class SmartDevice implements Serializable {

    private String id;
    private boolean on;
    private double custoInstalation;

    /*
    IDEIA PARA O CUSTO DE INSTALAÇÃO
    public static final double custoCamera = 2;
    public static final double custoBulb = 1;
    public static final double custoSpeaker = 0;

     */

    /**
     * Constructor for objects of class SmartDevice
     */
    public SmartDevice() {
        this.id = "";
        this.on = false;
        this.custoInstalation = 0;
    }

    public SmartDevice(String s) {
        this.id = s;
        this.on = false;
        this.custoInstalation = 0;
    }

    public SmartDevice(String s, boolean b) {
        this.id = s;
        this.on = b;
        this.custoInstalation = 0;
    }

    public SmartDevice(String s, boolean b,double custo) {
        this.id = s;
        this.on = b;
        this.custoInstalation = custo;
    }


    public SmartDevice(SmartDevice umDevice){
        this.id = umDevice.getID();
        this.on = umDevice.getOn();
        this.custoInstalation = umDevice.getCustoInstalation();
    }

    /**
     * funçoes que ligam e desligam dispositivos
     */
    public void turnOn() {
        this.on = true;
    }
    
    public void turnOff() {
        this.on = false;
    }

    /**
     *getters e setters de S martDevice
     */
    public boolean getOn(){
        return this.on;
    }
    
    public void setOn(boolean b){
        this.on = b;
    }
    
    public String getID(){
        return this.id;
    }

    public void setCustoInstalation(double custoInstalation) {
        this.custoInstalation = custoInstalation;
    }

    public double getCustoInstalation() {
        return custoInstalation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartDevice that = (SmartDevice) o;
        return on == that.getOn() && this.getID().equals(that.getID());
    }

    /**
     * declaraçoes de funçoes abstractas necessarias para subclasses de smartdevice
     */
    public abstract double custoEnergia();

    public abstract SmartDevice clone();

    @Override
    public String toString() {
        return "SmartDevice{" +
                "id='" + id + '\'' +
                ", on=" + on +
                ", custoInstalation=" + custoInstalation +
                '}';
    }
}
