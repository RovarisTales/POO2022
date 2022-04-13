 

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

/**
 * Um SmartSpeaker é um SmartDevice que além de ligar e desligar permite também
 * reproduzir som.
 * Consegue ligar-se a um canal (por simplificação uma rádio online) e permite
 * a regulação do seu nível de volume.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SmartSpeaker extends SmartDevice {
    public static final int MAX = 20; //volume máximo
    
    private int volume;
    private String channel;
    private Marca marca;

    /**
     * Constructor for objects of class SmartSpeaker
     */
    public SmartSpeaker() {
        // initialise instance variables
        super();
        this.volume = 0;
        this.channel = "";
    }

    public SmartSpeaker(String s) {
        // initialise instance variables
        super();
        this.volume = 10;
        this.channel = s;
    }

    public SmartSpeaker(String cod, String channel, int i) {
        // initialise instance variables
        super(cod);
        this.channel = channel;
        this.volume = i < 0 ? 0 : i;
    }

    public SmartSpeaker(SmartSpeaker umSpeaker){
        this.channel = umSpeaker.getChannel();
        this.volume = umSpeaker.getVolume();
        this.marca = umSpeaker.getMarca();
    }

    public void volumeUp() {
        if (this.volume<MAX) this.volume++;
    }

    public void volumeDown() {
        if (this.volume>0) this.volume--;
    }

    public int getVolume() {return this.volume;}
    
    public String getChannel() {return this.channel;}
    
    public void setChannel(String c) {
        this.channel = c;
    }

    public Marca getMarca() {
        return marca.clone();
    }

    public void setMarca(Marca marca) {
        this.marca = marca.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartSpeaker that = (SmartSpeaker) o;
        return this.volume == that.getVolume() && this.getChannel().equals(that.getChannel());
    }

    @Override
    public double custoEnergia() {
        return 0;
    }

    public SmartSpeaker clone(){
        return new SmartSpeaker(this);
    }


}
