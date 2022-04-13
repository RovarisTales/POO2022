/**
 * Um SmartSpeaker é um SmartDevice que além de ligar e desligar permite também
 * reproduzir som.
 * Consegue ligar-se a um canal (por simplificação uma rádio online) e permite
 * a regulação do seu nível de volume.
 *
 * @author Tiago Rodrigues
 * @version 13/04/2022
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
        this.marca = new Marca();
    }

    public SmartSpeaker(String s) {
        // initialise instance variables
        super();
        this.volume = 10;
        this.channel = s;
        this.marca = new Marca();
    }

    public SmartSpeaker(String cod, String channel, int i) {
        // initialise instance variables
        super(cod);
        this.channel = channel;
        this.volume = Math.max(i, 0);
        this.marca = new Marca();
    }

    public SmartSpeaker(String cod, String channel, int i,String nome,int custo) {
        // initialise instance variables
        super(cod);
        this.channel = channel;
        this.volume = Math.max(i, 0);
        this.marca.setNome(nome);
        this.marca.setCusto(custo);
    }

    public SmartSpeaker(String cod,boolean b,int custoInstalacao, String channel, int i,String nome,int custo) {
        // initialise instance variables
        super(cod,b,custoInstalacao);
        this.channel = channel;
        this.volume = Math.max(i, 0);
        this.marca.setNome(nome);
        this.marca.setCusto(custo);
    }

    public SmartSpeaker(SmartSpeaker umSpeaker){
        super(umSpeaker.getID(), umSpeaker.getOn(), umSpeaker.getCustoInstalation());
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
        return this.volume == that.getVolume() && this.getChannel().equals(that.getChannel())
                && this.marca.getCusto() == that.getMarca().getCusto()
                && this.marca.getNome().equals(that.getMarca().getNome());
    }

    @Override
    public double custoEnergia() {
        return this.marca.getCusto() + (1.5) * this.volume;
    }

    public SmartSpeaker clone(){
        return new SmartSpeaker(this);
    }


}
