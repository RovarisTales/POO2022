import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//TODO ALTERAR POR ARQUIVO -> TALES
//TODO DIAS FATURAS
//TODO COMENTAR CODIGO
/**
 * A classe menu é a classe q cria a interface de menu que o utilizador ira comunicar com o programa
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu
{
    //variáveis de instância
    private Simulacao simular;
    private Scanner menu;

    /**
     * Construtor por omissão de Menu.
     */
    public Menu()
    {
        this.simular = new Simulacao();
        this.menu = new Scanner(System.in);
    }
    /**
     * Construtor parametrizado de menu.
     * Aceita como parâmetro uma simulação
     */
    public Menu(Simulacao simul)
    {
        this.simular = simul;
        this.menu = new Scanner(System.in);
    }

    /**
     * Cria um novo comercializador.
     *
     * @return O novo comercializador
     */
    public ComercializadorEnergia criarComercializador()
    {
        ComercializadorEnergia comer = new ComercializadorEnergia();

        System.out.println("Nome do comercializador ");
        comer.setNome(this.menu.nextLine());
        System.out.println("Custo diario energia :");
        comer.setCustoDiarioEner(this.menu.nextDouble());
        System.out.println("Volume de fatura :");
        comer.setVolumeFatura(this.menu.nextDouble());
        this.simular.addComercializador(comer);
        //System.out.println(comercializadores);
        return comer;
    }

    /**
     * Disponibiliza o menu que nos permite alterar algum comercializador ou uma casa/device
     *
     */
    public void alterar ()
    {


        System.out.print("##--Menu para alterar comercializador , quartos e Devices--##\n\n");
        System.out.println("|----------------------------------------------|");
        System.out.println("| Opção 1 - Alterar Casa ou device             |");
        System.out.println("| Opção 2 - Comercializador                    |");
        System.out.println("|Aperte qualquer outra tecla para acabar criaçao");
        System.out.println("|----------------------------------------------|");

        switch (menu.nextInt())
        {
            case 1:
                System.out.println("NIF da casa : ");
                int NIF = menu.nextInt();
                if (this.simular.getCasas().containsKey(NIF))
                {
                    alterarCasa(NIF);
                }
                else
                {
                    System.out.println("Casa NAO EXISTE");
                }
                break;
            case 2:
                System.out.println("Qual o nome do comercializador?");
                String nome = menu.next();
                if (simular.getComercializadores().containsKey(nome))
                {
                    alterarComercializador(nome);
                }
                else
                {
                    System.out.println("COMERCIALIZADOR NAO EXISTE ");
                }
                break;
            default:
                break;
        }
    }

    /**
     * Altera uma casa.
     *
     * @param NIF  O NIF da casa que queremos alterar
     */
    public void alterarCasa(int NIF){
        System.out.println("|----------------------------------------------|");
        System.out.println("| Opção 1 - Alterar comercializador            |");
        System.out.println("| Opção 2 - Alterar devices                    |");
        System.out.println("| Opção 3 - Ligar/desligar todos devices quartos|");
        System.out.println("|Aperte qualquer outra tecla para acabar alteração");
        System.out.println("|----------------------------------------------|");

        switch (menu.nextInt()){
            case 1:
                System.out.println("Qual o nome do comercializador?");
                menu.next();
                String nome = menu.nextLine();
                if (simular.getComercializadores().containsKey(nome))
                {
                    CasaInteligente ci = simular.getCasas().get(NIF);
                    ci.setComercializadorEn(nome);
                    simular.addCasa(ci);
                }
                else
                {
                    System.out.println("COMERCIALIZADOR NAO EXISTE ");
                }
                break;
            case 2:
                CasaInteligente ci = simular.getCasas().get(NIF);
                System.out.println("Qual o id do device?");
                String id = menu.next();
                SmartDevice sd = ci.getDevices().get(id);
                if(sd == null)
                {
                    System.out.println("O device não existe");
                    break;
                }
                alterarDevice(sd);
                String quarto = ci.whereIsDevice(sd);
                ci.addToRoom(quarto, sd.getID());
                ci.addDevice(sd);
                break;
            case 3:
                System.out.println("Qual o quarto?");
                String quarto1 = menu.next();
                System.out.println("1 - Ligar | 2 - Desligar");
                CasaInteligente ci1 = simular.getCasas().get(NIF);
                switch (menu.nextInt()){
                    case 1:
                        ci1.setAllOnOrOffRoom(quarto1,true);
                    case 2:
                        ci1.setAllOnOrOffRoom(quarto1,false);
                    default:
                        System.out.println("Input inválido");
                        break;
                }
                break;
            default:
                break;
        }
    }

    /**
     * Liga ou desliga um device.
     *
     * @param sd   O smartDevice que queremos alterar
     */
  
    public void alterarDevice(SmartDevice sd)
    {
        System.out.println("|----------------------------------------------|");
        System.out.println("| 1 - Ligar | 2 - Desligar                     |");
        System.out.println("|Aperte qualquer outra tecla para acabar alteração");
        System.out.println("|----------------------------------------------|");
        if (menu.nextInt() == 1)
        {
            sd.setOn(true);
        }
        else {
            sd.setOn(false);
        }
    }
    /**
     * Altera dados de um comercializador.
     *
     * @param nome o nome do comercializador que queremos alterar
     */
    public void alterarComercializador(String nome){
        System.out.println("|----------------------------------------------|");
        System.out.println("| Opção 1 - Alterar custo diário               |");
        System.out.println("| Opção 2 - Alterar volume fatura              |");
        System.out.println("|Aperte qualquer outra tecla para acabar alteração");
        System.out.println("|----------------------------------------------|");

        switch (menu.nextInt()){
            case 1:
                System.out.println("Custo desejado : ");
                double custo = menu.nextDouble();
                ComercializadorEnergia ce = simular.getComercializadores().get(nome);
                ce.setCustoDiarioEner(custo);
                simular.addComercializador(ce);
                break;
            case 2:
                System.out.println("Qual o volume de fatura?");
                double custoFat = menu.nextDouble();
                ComercializadorEnergia ce2 = simular.getComercializadores().get(nome);
                ce2.setVolumeFatura(custoFat);
                simular.addComercializador(ce2);
                break;
            default:
                break;
        }
    }

    /**
     * Instalar devices em uma casa.
     *
     * @param nova a casa inteligente que queremos instalar os devices
     */
    public void instalarDevices(CasaInteligente nova)
    {

        for (String id : nova.getDevices().keySet())
        {
            System.out.println("Deseja instalar o device "  + id + "? ");
            System.out.println();
            System.out.println("1 - Sim  \n2 - Não");
            if (menu.nextInt() == 1)
            {
                while (true)
                {
                    System.out.println("Em qual quarto deseja adicionar o device " + id + " ?");
                    String quarto = menu.next();
                    if (nova.getLocations().containsKey(quarto))
                    {
                        System.out.println("Deseja deixar o device  "  + id + " ligado ? ");
                        System.out.println("1 - Sim  \n2 - Não");
                        if (menu.nextInt() == 1)
                        {
                            nova.getDevices().get(id).turnOn();
                        }
                        nova.addToRoom(quarto,id);

                        break;
                    }
                    else
                    {
                        System.out.println("Bro o quarto não existe Dred, queres um quarto novo? ;)");
                        System.out.println("1 - Sim  \n2 - Não");
                        if (menu.nextInt() == 1)
                        {
                            nova.addRoom(quarto);
                            System.out.println("Deseja deixar o device  "  + id + " ligado ? ");
                            System.out.println("1 - Sim  \n2 - Não");
                            if (menu.nextInt() == 1)
                            {
                                nova.getDevices().get(id).turnOn();
                            }
                            nova.addToRoom(quarto, id);
                            break;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                nova.setGastoCasa(nova.getGastoCasa()+nova.getDevices().get(id).getCustoInstalation());
            }
            else
            {
                break;
            }
        }
    }


    /**
     * Criar um device
     *
     * @return O device que foi criado
     */
    public SmartDevice criarDevice()
    {
        System.out.println("Qual seria o id do device");
        String id = menu.next();
        System.out.println("");
        System.out.print("##--Menu para adicionar quartos e Devices--##\n\n");
        System.out.println("|----------------------------------------------|");
        System.out.println("| Opção 1 - SmartSpeaker                       |");
        System.out.println("| Opção 2 - SmartCamera                        |");
        System.out.println("| Opção 3 - SmartBulb                          |");
        System.out.println("|Aperte qualquer outra tecla para acabar criaçao");
        System.out.println("|----------------------------------------------|");
        System.out.println("Digite uma opção: ");

        switch (menu.nextInt())
        {
            case 1:
                SmartSpeaker sp = new SmartSpeaker(id);
                System.out.println("Volume do SmartSpeaker : ");
                sp.setVolume(menu.nextInt());
                System.out.println("Channel do SmartSpeaker : ");
                sp.setChannel(menu.next());
                System.out.println("Qual o nome da Marca ?");
                String nome = menu.next();
                if (this.simular.getMarcas().containsKey(nome))
                {
                    sp.setMarca(this.simular.getMarcas().get(nome));
                } else
                {
                    System.out.println("Qual o custo da Marca ?");
                    Marca oii = new Marca(nome, menu.nextInt());
                    sp.setMarca(oii);
                    this.simular.addMarca(oii);
                }
                System.out.println(sp.toString());
                return sp;
                                        /*
                                        LIGADA OU DESLIGADA
                                         */
            case 2:
                SmartCamera sc = new SmartCamera(id);
                System.out.println("Resolução?");
                System.out.println("QuatroK - 1; UltraHD - 0.6; HD - 0.3");
                sc.setResolucao(menu.nextDouble());
                System.out.println("Tamanho dos ficheiros?");
                sc.setTamanho_ficheiro(menu.nextDouble());
                System.out.println(sc.toString());
                return sc;

            case 3:
                SmartBulb sb = new SmartBulb(id);
                System.out.println("Intensidade?");
                System.out.println("Warm - 2; Neutral - 1; Cold - 0");
                sb.setTone(menu.nextInt());
                System.out.println("Dimensão da lâmpada");
                sb.setDimensao(menu.nextInt());
                System.out.println("Custo diário de energia?");
                sb.setCustoEnergia(menu.nextInt());
                System.out.println(sb.toString());
                return sb;
            default:
                //nao ha breaks nessa merda
                return null;
        }
    }

    /**
     * Menu que da a opção de criar um quarto ou um device a casa nova
     *
     * @param nova a casa inteligente que queremos adicionar quartos/devices
     */
    public void criaQuartoDevice(CasaInteligente nova)
    {
        int i = 0;
        while (i == 0) {
            Scanner menu = new Scanner(System.in);
            System.out.print("##--Menu para adicionar quartos e Devices-------##\n\n");
            System.out.println("|----------------------------------------------|");
            System.out.println("|----------------------------------------------|");
            System.out.println("| Opção 1 - novo quarto                        |");
            System.out.println("| Opção 2 - novo device                        |");
            System.out.println("|Aperte qualquer outra tecla para acabar criaçao");
            System.out.println("|----------------------------------------------|");
            System.out.println("Digite uma opção:");
            int op2 = menu.nextInt();


            switch (op2)
            {
                case 1:
                    //criar novo quarto na casa
                    System.out.println("Diga o nome do quarto");
                    nova.addRoom(menu.next());
                    break;
                case 2:
                    nova.addDevice(criarDevice());
                    //criar novo device


                    break;
                default:
                    i = 1;
            }
        }
    }

    /**
     * Menu que permite o utilizador a descobrir estatisticas
     */
    public void estatisticas()
    {
        int i = 0;
        Scanner menu = new Scanner(System.in);
        System.out.print("##------------Menu para adicionar quartos e Device------------##\n\n");
        System.out.println("| Opção 1 - ordenacao dos maiores consumidores de energia    |");
        System.out.println("| Opção 2 - Casa com maior gasto                             |");
        System.out.println("| Opção 3 - Faturas de um comercializador                    |");
        System.out.println("| Opção 4 - Comercializador com maior volume de faturação    |");
        System.out.println("|Aperte qualquer outra tecla para acabar criaçao             |");
        System.out.println("|------------------------------------------------------------|");
        System.out.println("Digite uma opção:");
        int op2 = menu.nextInt();

        switch (op2)
        {
            case 1:
                System.out.println(this.simular.ordenacaoMaioresConsumidoresEnergia(/*int dia1 , int dia 2*/));
                break;
            case 2:
                //Novo metodo ?
                System.out.println(this.simular.casaMaiorGasto());
                break;
            case 3:
                System.out.println("Qual o comercializador : ");
                menu.next();
                System.out.println(this.simular.faturasComercializador(menu.nextLine()));
                break;
            case 4:
                System.out.println(this.simular.ComercializadorComMaiorFatura());
                break;
            default:
                break;

        }
    }

    /**
     * Cria uma casa inteligente.
     *
     * @return A casa inteligente que foi criada
     */
    public CasaInteligente criarCasa ()
    {
        System.out.println(this.simular.getComercializadores());
        Scanner menu = new Scanner(System.in);
        int i = 0;
        CasaInteligente nova = new CasaInteligente();
        System.out.println("Nome do proprietatário");
        nova.setProprietario(menu.nextLine());
        System.out.println("Morada :");
        //implementar casa com mais de um noime
        nova.setMorada(menu.nextLine());
        System.out.println("Nif :");
        nova.setNIF(menu.nextInt());
        System.out.println("Comercializador de energia :");
        String comerc = menu.next();
        if (this.simular.getComercializadores().containsKey(comerc))
        {
            nova.setComercializadorEn(comerc);
        }
        else
        {
            System.out.println("COMERCIALIZADOR NAO EXISTE");
            return null;
        }
        criaQuartoDevice(nova);
        instalarDevices(nova);
        return nova;
    }

    /**
     * Cria o cenario de simualção
     *
     * @param simular , aonde vamos armazenar os dados da simulação
     */
    public void criarNovoSimular (Simulacao simular) throws IOException {
        int aux = 0;
        this.simular = simular;

        while (aux == 0) {
                System.out.print("##-----Menu para adicionar Casas e Devices------##\n\n");
                System.out.println("|----------------------------------------------|");
                System.out.print("| Opção 1 - Nova casa                            |\n");
                System.out.print("| Opção 2 - Novo comercializador                 |\n");
                System.out.print("| Opção 3 - Simular                              |\n");
                System.out.print("| Opção 4 - Alterar casa, comercializador, device|\n");
                System.out.print("| Opção 5 - Salvar                               |\n");
                System.out.print("| Opção 6 - Estatísticas                         |\n");
                System.out.print("|------------------------------------------------|\n");
                System.out.print("Digite uma opção: ");

                int opcao = menu.nextInt();
                switch (opcao) {
                    case 1:
                        this.simular.addCasa(criarCasa());
                        break;

                    case 2:
                        this.simular.addComercializador(criarComercializador());//adicionar comercializador
                        //System.out.println(mc);
                        break;
                    case 3:
                        System.out.println("Quantos dias gostaria de simular?");
                        int n = menu.nextInt();
                        this.simular.simular(n);
                        break;
                    case 4 :
                        alterar();
                        break;
                    case 5:
                        this.simular.salvar();
                        break;
                    case 6:
                        estatisticas();
                        break;
                    default:
                        aux = 1;

                }

            }
    }

}



