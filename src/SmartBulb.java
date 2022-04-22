import java.util.Objects;

/**
 * Smartbulb é uma subclasse de SmartDevice que contem a dimensão da lâmpada,
 * seu tom e o custo diario energetico
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
       
        super();
        this.tone = NEUTRAL;
        this.custoDiario = 0;
    }

    public SmartBulb(String id, int tone,int custoEnergi) {
        
        super(id);
        this.tone = tone;
        this.custoDiario = custoEnergi;
        this.dimensao = 0;
    }

    public SmartBulb(String id) {
       
        super(id);
        this.tone = NEUTRAL;
        this.custoDiario = 0;
        this.dimensao = 0;
    }

    public SmartBulb(String id,int tone,int custoEnergi,int dimensao) {
        
        super(id);
        this.tone = tone;
        this.custoDiario = custoEnergi;
        this.dimensao = dimensao;
    }

    public SmartBulb (SmartDevice n,int tone, int custo) {
        super(n);
        this.tone = tone;
        this.custoDiario = custo;
    }
    public SmartBulb(String id,boolean b, double custoinst, int tone,int custodia, int dimensao){
        super(id,b,custoinst);
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
    /**
    sets e gets da smartbulb
    */
    public void setTone(int t) {
        if (t>WARM) this.tone = WARM;
        else if (t<COLD) this.tone = COLD;
        else this.tone = t;
    }

    public int getTone() {
        return this.tone;
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
    /**
    custo de energia arbritario necessario por causa da superclasse
    */
    @Override
    public double custoEnergia() {
        return this.tone*2 + this.custoDiario;
    }
    /**
    clone da Smartbulb a partir do contrutor de classe
    */
    public SmartBulb clone(){
        return new SmartBulb(this);
    }
    /**
    equals da classe Smartbulb
    */
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmartBulb smartBulb = (SmartBulb) o;
        return tone == smartBulb.getTone() && dimensao == smartBulb.getDimensao()
                && custoDiario == smartBulb.getCustoDiario();
    }
    /**
    toString basico
    */
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

