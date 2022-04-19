import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
TODO
TODO TRANSFORMAR ISSO EM UMA CLASSE NA QUAL COMERCIALIZADORES E MARCAS SAO VARIAVEIS DE INSTANCIA E DA PRA PEGAR COM GET E SET O Q ESTA AGORA É MT C E O PROFESSOR RECLAMOU Q OS ALUNOS FAZIAM ISSO POR EXEMPLO AS FUNCOES RECEBEREM ARGUMENTOS Q USAMOS EM VARIAS FUNCOES TIPO COMERCIALIZADORES E MARCAS
TODO IMPORTANTE
TODO IMPORTANTE
TODO IMPORTANTE
 */
public class Menu{
    /*
    private ArrayList<ComercializadorEnergia> comercializadores;
    private ArrayList<Marca> marcas;

    public ArrayList<Marca> getMarcas() {
        return marcas;
    }

    public ArrayList<ComercializadorEnergia> getComercializadores() {
        return comercializadores;
    }

    public void addComer(ComercializadorEnergia comer){
        this.comercializadores.add(comer);
    }

    public void addMarca(Marca m){
        this.marcas.add(m);
    }
    */
    public static ComercializadorEnergia criarComercializador(Map<String,ComercializadorEnergia> b)
    {
        ComercializadorEnergia comer = new ComercializadorEnergia();
        Scanner menu = new Scanner(System.in);
        System.out.println("Nome do comercializador ");
        comer.setNome(menu.next());
        System.out.println("Custo diario energia :");
        comer.setCustoDiarioEner(menu.nextDouble());
        System.out.println("Volume de fatura :");
        comer.setVolumeFatura(menu.nextDouble());
        //b.put(comer.getNome(),comer);
        //addComer(comer);
        //System.out.println(comercializadores);
        return comer;
    }

    public static void instalarDevices(CasaInteligente nova)
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


    public static SmartDevice criarDevice(Map<String, Marca> marcas)
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
                if (marcas.containsKey(nome))
                {
                    sp.setMarca(marcas.get(nome));
                } else
                {
                    System.out.println("Qual o custo da Marca ?");
                    Marca oii = new Marca(nome, menu.nextInt());
                    sp.setMarca(oii);
                    marcas.put(nome, oii);
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

    public static void criaQuartoDevice(CasaInteligente nova)
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
            Map<String, Marca> marcas = new HashMap<>();

            switch (op2)
            {
                case 1:
                    //criar novo quarto na casa
                    System.out.println("Diga o nome do quarto");
                    nova.addRoom(menu.next());
                    break;
                case 2:
                    nova.addDevice(criarDevice(marcas));
                    //criar novo device


                    break;
                default:
                    i = 1;
            }
        }
    }


    public static CasaInteligente criarCasa (Map <String, ComercializadorEnergia> comercializadores)
    {
        System.out.println(comercializadores);
        Scanner menu = new Scanner(System.in);
        int i = 0;
        CasaInteligente nova = new CasaInteligente();
        System.out.println("Nome do proprietatário");
        nova.setProprietario(menu.next());
        System.out.println("Morada :");
        //implementar casa com mais de um noime
        nova.setMorada(menu.next());
        System.out.println("Nif :");
        nova.setNIF(menu.nextInt());
        System.out.println("Comercializador de energia :");
        String comerc = menu.next();
        if (comercializadores.containsKey(comerc))
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

    public static void criarNovoSimular (Simulacao simular) throws IOException {
        Scanner menu = new Scanner(System.in);
        int aux = 0;
        Map<String, ComercializadorEnergia> comercializadores = new HashMap<>();

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
                        simular.addCasa(criarCasa(comercializadores));
                        break;

                    case 2:
                        simular.addComercializador(criarComercializador(comercializadores));//adicionar comercializador
                        System.out.println(comercializadores);
                        break;
                    case 3:
                                //simular
                        break;
                    case 4:
                        simular.salvar();
                    default:
                        aux = 1;

                }

            }
    }


        public static void main (String[]args) throws IOException {

            Scanner menu = new Scanner(System.in);

            Simulacao simular = new Simulacao();
            System.out.println("##--Bem vindo a simulação de casas inteligentes--##\n");

            System.out.println("Selecione a sua opção:");
            System.out.println("|----------------------------------------------|");
            System.out.println("| Opção 0 - Usar a configuraçao anterior       |");
            System.out.println("| Opção 1 - Criar nova configuraçao            |");
            System.out.println("| Para sair aperte qualquer tecla              |");
            System.out.println("|----------------------------------------------|");

            int input = menu.nextInt();
            switch (input) {
                //Ler a configuração anterior
                case 0:
                    String arquivo = " ";
                    simular = new Simulacao(arquivo);
                    break;
                // Nova Configuração
                case 1:
                    System.out.println("|----------------------------------------------|");
                    System.out.println("| Opção 0 - Configuração através de ficheiro   |");
                    System.out.println("| Opção 1 - Configuração manual                |");
                    System.out.println("| Para sair aperte qualquer tecla              |");
                    System.out.println("|----------------------------------------------|");
                    int input1 = menu.nextInt();
                    switch (input1) {
                        //Configuração através de ficheiro
                        case 0:
                            String arquivo1 = "";
                            simular = new Simulacao(arquivo1);
                            break;
                        //Configuraçao nova
                        case 1:
                            simular = new Simulacao();
                            break;
                        default:
                            System.out.println("Fechando Progama");
                            System.exit(0);

                    }
                    break;
                default:
                    simular.salvar();
                    System.out.println("Fechando Progama");
                    System.exit(0);

            }
            criarNovoSimular(simular);
            System.out.println(simular);
        }
}



