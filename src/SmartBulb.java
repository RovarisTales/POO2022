 

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

import java.util.Objects;

/**
 * Uma SmartBulb é uma lâmpada inteligente que além de ligar e desligar (já que
 * é subclasse de SmartDevice) também permite escolher a intensidade da iluminação 
 * (a cor da mesma).
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SmartBulb extends SmartDevice {
    public static final int WARM = 2;
    public static final int NEUTRAL = 1;
    public static final int COLD = 0;
    
    private int tone;
    private int dimensão;
    private int custoEnergia;

    /**
     * Constructor for objects of class SmartBulb
     */
    public SmartBulb() {
        // initialise instance variables
        super();
        this.tone = NEUTRAL;
        this.custoEnergia = 0;
    }

    public SmartBulb(String id, int tone,int custoEnergi) {
        // initialise instance variables
        super(id);
        this.tone = tone;
        this.custoEnergia = custoEnergi;
    }

    public SmartBulb(String id) {
        // initialise instance variables
        super(id);
        this.tone = NEUTRAL;
        this.custoEnergia = 0;
    }
    public SmartBulb (int tone, SmartDevice n,int custo){
        super(n);
        this.tone = tone;
        this.custoEnergia = custo;
    }
<<<<<<< HEAD
    public int getCustoIntslation(){
        return this.getCustoInstalation();
    }
=======
>>>>>>> 7687608de2bfcccc7f5d0d6226f9062920c55f3d

    public SmartBulb(SmartBulb umaBulb){
        super(umaBulb.getID(),umaBulb.getOn(),umaBulb.getCustoInstalation());
        this.tone = umaBulb.getTone();
        this.custoEnergia = umaBulb.getCustoEnergia();
        this.dimensão = umaBulb.getDimensão();
    }

    @Override
    public boolean getOn() {
        return this.getOn();
    }

    @Override
    public String getID() {
        return this.getID();
    }

    @Override
    public double custoEnergia() {
        return this.tone*2 + this.custoEnergia;
    }

    public void setTone(int t) {
        if (t>WARM) this.tone = WARM;
        else if (t<COLD) this.tone = COLD;
        else this.tone = t;
    }

    public int getTone() {
        return this.tone;
    }

    public SmartBulb clone(){
        return new SmartBulb(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmartBulb smartBulb = (SmartBulb) o;
        return tone == smartBulb.getTone() && dimensão == smartBulb.getDimensão()
                && custoEnergia == smartBulb.getCustoEnergia();
    }

    public int getCustoEnergia() {
        return this.custoEnergia;
    }

    public int getDimensão() {
        return this.dimensão;
    }

    @Override
    public void setOn(boolean b) {
        super.setOn(b);
    }

    public void setDimensão(int dimensão) {
        this.dimensão = dimensão;
    }

    public void setCustoEnergia(int custoEnergia) {
        this.custoEnergia = custoEnergia;
    }
}

