import java.util.Objects;

/**
 * A classe SmartDCamera é uma sub-classe de SmartDevice.
 * Permite calcular o custo de energia de uma SmartCamera.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class SmartCamera extends SmartDevice
{
    //variáveis estaticas
    public static final double QUATROK = 1;
    public static final double ULTRAHD = 0.6;
    public static final double HD= 0.3;

    //variáveis de instância
    private double resolucao;
    private double tamanho_ficheiro;

    /**
     * Construtor por omissão de SmartCamera.
     */
    public SmartCamera()
    {
        super();
        this.resolucao = HD;
    }

    /**
     * Construtor parametrizado de Ponto.
     * Aceita como parâmetros os valores de resolução e do tamanho do ficheiro
     */
    public SmartCamera(double resolucao, double tamanho_ficheiro)
    {
        super();
        this.resolucao = resolucao;
        this.tamanho_ficheiro = tamanho_ficheiro;
    }

    /**
     * Construtor parametrizado de Ponto.
     * Aceita como parâmetros os valores de resolução e do tamanho do ficheiro e a string s que contem o id do smart device
     */
    public SmartCamera(String s, double resolucao, double tamanho_ficheiro)
    {
        super(s);
        this.resolucao = resolucao;
        this.tamanho_ficheiro = tamanho_ficheiro;
    }

    /**
     * Construtor parametrizado de Ponto.
     * Aceita como parâmetros os valores de resolução e do tamanho do ficheiro
     * e a string s que contem o id do smart device, e o boolean b que contém o estado do smart device
     */
    public SmartCamera(String s, boolean b, double resolucao, double tamanho_ficheiro)
    {
        super(s, b);
        this.resolucao = resolucao;
        this.tamanho_ficheiro = tamanho_ficheiro;
    }

    /**
     * métodos de instância
     */

    /**
     * Devolve o valor da resolucao.
     *
     * @return valor da resolucao.
     */
    public double getResolucao() {
        return resolucao;
    }

    /**
     * Actualiza o valor da resolução.
     *
     * @param resolucao novo valor da resolucao
     */
    public void setResolucao(double resolucao)
    {
        if (resolucao>QUATROK)
        {
            this.resolucao = QUATROK;
        }
        else if (resolucao<HD)
        {
            this.resolucao = HD;
        }
        else this.resolucao = ULTRAHD;
    }

    /**
     * Devolve o valor do tamanho do ficheiro.
     *
     * @return valor do tamanho do ficheiro.
     */
    public double getTamanho_ficheiro()
    {
        return tamanho_ficheiro;
    }

    /**
     * Actualiza o valor do tamanho do ficheiro.
     *
     * @param tamanho_ficheiro novo valor do tamanho do ficheiro.
     */
    public void setTamanho_ficheiro(double tamanho_ficheiro)
    {
        this.tamanho_ficheiro = tamanho_ficheiro;
    }


    public SmartCamera(SmartDevice umDevice, double resolucao, double tamanho_ficheiro)
    {
        super(umDevice);
        this.resolucao = resolucao;
        this.tamanho_ficheiro = tamanho_ficheiro;
    }

    /**
     * Construtor de cópia de SmartCamera.
     * Aceita como parâmetro outra SmartCamera e utiliza os métodos
     * de acesso aos valores das variáveis de instância.
     */
    public SmartCamera(SmartCamera sc)
    {
        super(sc.getID(),sc.getOn());
        this.resolucao = sc.getResolucao();
        this.tamanho_ficheiro = sc.tamanho_ficheiro;
    }
    @Override
    /**
     * Método que calcula o custo de engergia de uma SmartCamera
     *
     *
     * @return  o custo de energia da smartCamera
     */
    public double custoEnergia()
    {
        return this.tamanho_ficheiro * this.resolucao;
    }

    @Override
    /**
     * Método que faz uma cópia do objecto receptor da mensagem.
     * Para tal invoca o construtor de cópia.
     *
     * @return objecto clone do objecto que recebe a mensagem.
     */
    public SmartCamera clone()
    {
        return new SmartCamera(this);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SmartCamera that = (SmartCamera) o;
        return Double.compare(that.resolucao, resolucao) == 0 && Double.compare(that.tamanho_ficheiro, tamanho_ficheiro) == 0;
    }

    @Override
    /**
     * Método que devolve a representação em String do SmartCamera
     * @return String com a resolução
     */
    public String toString()
    {
        return "SmartCamera{" +
                "resolucao=" + resolucao +
                ", tamanho_ficheiro=" + tamanho_ficheiro +
                '}';
    }

}
