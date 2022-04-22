import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//TODO LIGAR E DESLIGAR DISPOSiTIVOS
//TODO ALTERAR CASA
//TODO CRIAR MENU ESTATICAS
//TODO MUDANCA DE FORNECEDOR E ALTERAR VALORES DO FORNECEDOR

public class Menu
{

    private Simulacao simular;

    public Menu()
    {
        this.simular = new Simulacao();
    }
    public Menu(Simulacao simul){
        this.simular = simul;
    }
    public void setComercializadores(Map<String, ComercializadorEnergia> comercializadores)
    {
        this.simular.setComercializadores(comercializadores);
    }

    public void setMarcas(Map<String, Marca> marcas) {
        this.simular.setMarcas(marcas);
    }

    public Map<String,Marca> getMarcas() {
        return this.simular.getMarcas();
    }

    public Map<String,ComercializadorEnergia> getComercializadores() {
        return this.simular.getComercializadores();
    }

    public void addComer(ComercializadorEnergia comer) {
        this.simular.addComercializador(comer);
    }

    public void addMarca(Marca m) {
        this.simular.addMarca(m);
    }

    public ArrayList<String> getMarcasString(){
        ArrayList<String> marca = new ArrayList<>();
        for(String marc: this.getMarcas().keySet()){
            marca.add(marc);
        }
        return marca;
    }
    public ComercializadorEnergia criarComercializador()
    {
        ComercializadorEnergia comer = new ComercializadorEnergia();
        Scanner menu = new Scanner(System.in);
        System.out.println("Nome do comercializador ");
        comer.setNome(menu.nextLine());
        System.out.println("Custo diario energia :");
        comer.setCustoDiarioEner(menu.nextDouble());
        System.out.println("Volume de fatura :");
        comer.setVolumeFatura(menu.nextDouble());
        this.simular.addComercializador(comer);
        //System.out.println(comercializadores);
        return comer;
    }

    public void instalarDevices(CasaInteligente nova)
    {
        Scanner menu = new Scanner(System.in);
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
            }
            else
            {
                break;
            }
        }
    }


    public SmartDevice criarDevice()
    {
        Scanner menu = new Scanner(System.in);
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


    public CasaInteligente criarCasa ()
    {
        System.out.println(this.getComercializadores());
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
        if (this.getComercializadores().containsKey(comerc))
        {
            nova.setComercializadorEn(comerc);
        }
        else
        {
            System.out.println("COMERCIALIZADOR NAO EXISTE PUTAS");
            return null;
        }
        criaQuartoDevice(nova);
        instalarDevices(nova);
        return nova;
    }

    public void criarNovoSimular (Simulacao simular) throws IOException {
        Scanner menu = new Scanner(System.in);
        int aux = 0;
        this.simular = simular;

        while (aux == 0) {
                System.out.print("##-----Menu para adicionar Casas e Devices------##\n\n");
                System.out.println("|----------------------------------------------|");
                System.out.print("| Opção 1 - Nova casa                            |\n");
                System.out.print("| Opção 2 - Novo comercializador                 |\n");
                System.out.print("| Opção 3 - Simular                              |\n");
                System.out.print("| Opção 4 - Salvar                               |\n");
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
                        this.simular.simular(7);
                        break;
                    case 4:
                        this.simular.salvar();
                    default:
                        aux = 1;

                }

            }
    }




}



