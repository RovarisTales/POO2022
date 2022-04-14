 

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
public class SmartBulb extends SmartDevice{
    public static final int WARM = 2;
    public static final int NEUTRAL = 1;
    public static final int COLD = 0;
    
    private int tone;
    private int dimensao;
    private int custoDiario;

    /**
     * Constructor for objects of class SmartBulb
     */
    public SmartBulb() {
        // initialise instance variables
        super();
        this.tone = NEUTRAL;
        this.custoDiario = 0;
    }

    public SmartBulb(String id, int tone,int custoEnergi) {
        // initialise instance variables
        super(id);
        this.tone = tone;
        this.custoDiario = custoEnergi;
        this.dimensao = 0;
    }

    public SmartBulb(String id) {
        // initialise instance variables
        super(id);
        this.tone = NEUTRAL;
        this.custoDiario = 0;
        this.dimensao = 0;
    }

    public SmartBulb(String id,int tone,int custoEnergi,int dimensao) {
        // initialise instance variables
        super(id);
        this.tone = tone;
        this.custoDiario = custoEnergi;
        this.dimensao = dimensao;
    }

    public SmartBulb (int tone, SmartDevice n,int custo) {
        super(n);
        this.tone = tone;
        this.custoDiario = custo;
    }
    public SmartBulb(String cod,boolean b, int custoinst, int tone,int custodia, int dimensao){
        super(cod,b,custoinst);
        this.tone = tone;
        this.custoDiario = custodia;
        this.dimensao = dimensao;
    }

    public SmartBulb(SmartBulb umaBulb) {
        super(umaBulb.getID(),umaBulb.getOn(),umaBulb.getCustoInstalation());
        this.tone = umaBulb.getTone();
        this.custoDiario = umaBulb.getCustoDiario();
        this.dimensao = umaBulb.getDimensao();
    }

    @Override
    public double custoEnergia() {
        return this.tone*2 + this.custoDiario;
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
        return tone == smartBulb.getTone() && dimensao == smartBulb.getDimensao()
                && custoDiario == smartBulb.getCustoDiario();
    }

    public int getCustoDiario() {
        return this.custoDiario;
    }

    public int getDimensao() {
        return this.dimensao;
    }

    public void setDimensao(int dimensao) {
        this.dimensao = dimensao;
    }

    public void setCustoEnergia(int custoEnergia) {
        this.custoDiario = custoEnergia;
    }

    @Override
    public String toString() {
        return "SmartBulb{" +
                super.toString() +
                "tone=" + tone +
                ", dimensao=" + dimensao +
                ", custoEnergia=" + custoDiario +
                '}' ;
    }
}

