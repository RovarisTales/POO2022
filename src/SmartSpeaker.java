/**
 * Um SmartSpeaker é um SmartDevice que além de ligar e desligar permite também
 * reproduzir som.
 * Consegue ligar-se a um canal (por simplificação uma rádio online) e permite
 * a regulação do seu nível de volume.
 *
 * @author Tiago Rodrigues
 * @version 15/04/2022
 */
public class SmartSpeaker extends SmartDevice {
    public static final int MAX = 20; //volume máximo
    
    private int volume;
    private String channel;
    private Marca marca;

    /**
     * Constructores para objectos da class SmartSpeaker
     */

    /**
     * Construtor por omissão de SmartSpeaker.
     */
    public SmartSpeaker() {
        // initialise instance variables
        super();
        this.volume = 0;
        this.channel = "";
        this.marca = new Marca();
    }

    /**
     * Construtor parametrizado de SmartSpeaker.
     * Aceita como parâmetros o id do SmartSpeaker.
     */
    public SmartSpeaker(String s) {
        // initialise instance variables
        super(s);
        this.volume = 10;
        this.channel = "";
        this.marca = new Marca();
    }

    /**
     * Construtor parametrizado de SmartSpeaker.
     * Aceita como parâmetros o id,canal e o volume do SmartSpeaker
     */
    public SmartSpeaker(String cod, String channel, int i) {
        // initialise instance variables
        super(cod);
        this.channel = channel;
        this.volume = Math.max(i, 0);
        this.marca = new Marca();
    }

    /**
     * Construtor parametrizado de SmartSpeaker.
     * Aceita como parâmetros o id,canal e o volume do SmartSpeaker. Recebe parâmetros para a Marca.
     */
    public SmartSpeaker(String cod, String channel, int i,String nome,int custo) {
        // initialise instance variables
        super(cod);
        this.channel = channel;
        this.volume = Math.max(i, 0);
        this.marca.setNome(nome);
        this.marca.setCusto(custo);
    }

    /**
     * Construtor parametrizado de SmartSpeaker.
     * Aceita como parâmetros o id,se está ligado,custo de instalar o Device,
     * canal e o volume do SmartSpeaker. Recebe parâmetros para a Marca.
     */
    public SmartSpeaker(String cod,boolean b,double custoInstalacao, String channel, int i,String nome,int custo) {
        // initialise instance variables
        super(cod,b,custoInstalacao);
        this.channel = channel;
        this.volume = Math.max(i, 0);
        this.marca.setNome(nome);
        this.marca.setCusto(custo);
    }

    /**
     * Construtor parametrizado de SmartSpeaker.
     * Aceita como parâmetro um SmartSpeaker.
     */
    public SmartSpeaker(SmartSpeaker umSpeaker){
        super(umSpeaker.getID(), umSpeaker.getOn(), umSpeaker.getCustoInstalation());
        this.channel = umSpeaker.getChannel();
        this.volume = umSpeaker.getVolume();
        this.marca = umSpeaker.getMarca();
    }

    /**
     * Métodos de instância
     */

    /**
     * Método que aumento o volume de uma SmartSpeaker
     */
    public void volumeUp() {
        if (this.volume<MAX) this.volume++;
    }

    /**
     * Método que diminui o volume de uma SmartSpeaker
     */
    public void volumeDown() {
        if (this.volume>0) this.volume--;
    }

    /**
     * Getters e setters
     */

    public int getVolume() {return this.volume;}

    public void setVolume(int volume)
    {
        this.volume = volume;
    }
    
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
    /**
     * Método que verifica se um objeto é igual a outro.
     *
     * @return boolean true se os objetos tiveram as atribuições iguais e o inverso.
     */
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
    /**
     * Método que calcula o custo de engergia de uma SmartSpeaker
     *
     * @return  o custo de energia da SmartSpeaker
     */
    public double custoEnergia() {
        return this.marca.getCusto() + (1.5) * this.volume;
    }

    /**
     * Método que faz uma cópia do objecto receptor da mensagem.
     * Para tal invoca o construtor de cópia.
     *
     * @return objecto clone do objecto que recebe a mensagem.
     */
    public SmartSpeaker clone(){
        return new SmartSpeaker(this);
    }

    @Override
    /**
     * Método que devolve a representação em String do SmartSpeaker
     * @return String com o super e o inteiro com o volume, String do canal e a marca.
     */
    public String toString() {
        return "SmartSpeaker{" + super.toString() +
                "volume=" + volume +
                ", channel='" + channel + '\'' +
                ", marca=" + marca.toString() +
                '}';
    }
}
