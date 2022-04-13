import java.util.Objects;

public class SmartCamera extends SmartDevice
{
    public static final double QUATROK = 1;
    public static final double ULTRAHD = 0.6;
    public static final double HD= 0.3;

    private double resolucao;
    private double tamanho_ficheiro;

    public SmartCamera()
    {
        super();
        this.resolucao = HD;
    }

    public SmartCamera(double resolucao, double tamanho_ficheiro)
    {
        super();
        this.resolucao = resolucao;
        this.tamanho_ficheiro = tamanho_ficheiro;
    }

    public SmartCamera(String s, double resolucao, double tamanho_ficheiro)
    {
        super(s);
        this.resolucao = resolucao;
        this.tamanho_ficheiro = tamanho_ficheiro;
    }

    public SmartCamera(String s, boolean b, double resolucao, double tamanho_ficheiro)
    {
        super(s, b);
        this.resolucao = resolucao;
        this.tamanho_ficheiro = tamanho_ficheiro;
    }


    public double getResolucao() {
        return resolucao;
    }

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

    public double getTamanho_ficheiro()
    {
        return tamanho_ficheiro;
    }

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

    public SmartCamera(SmartCamera sc)
    {
        super(sc.getID(),sc.getOn());
        this.resolucao = sc.getResolucao();
        this.tamanho_ficheiro = sc.tamanho_ficheiro;
    }
    @Override
    public double custoEnergia()
    {
        return this.tamanho_ficheiro * this.resolucao;
    }

    @Override
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
    public int hashCode()
    {
        return Objects.hash(resolucao, tamanho_ficheiro);
    }

    @Override
    public String toString()
    {
        return "SmartCamera{" +
                "resolucao=" + resolucao +
                ", tamanho_ficheiro=" + tamanho_ficheiro +
                '}';
    }
}
