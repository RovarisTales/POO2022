import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Menu
{

    public static void criarNovoSimular(Simulacao simular)
    {
        Scanner menu = new Scanner (System.in);
        int aux = 0;
        while(aux == 0){
            System.out.print("##-----Menu para adicionar Casas e Devices------##\n\n");
            System.out.println("|----------------------------------------------|");
            System.out.print("| Opção 1 - Nova casa                            |\n");
            System.out.print("| Opção 2 - Simular                              |\n");
            System.out.print("|------------------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            int opcao = menu.nextInt();

            switch(opcao){
                case 1:
                    int i = 0;
                    CasaInteligente nova = new CasaInteligente();
                    //Não ta funcionando
                    System.out.println("Nome do proprietatário");
                 
                    NAO TA FUNCIONANDO VER PQ
                    nova.setProprietario(menu.nextLine());
                    System.out.println("Morada :");
                    nova.setMorada(menu.nextLine());
                    System.out.println("Nif :");
                    nova.setNIF(menu.nextInt());
                    System.out.println("Comercializador de energia :");
                    nova.setComercializadorEn(menu.nextLine());

                    while(i == 0){
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

                        switch (op2){
                            case 1:
                                //criar novo quarto na casa
                                System.out.println("Diga o nome do quarto");
                                nova.addRoom(menu.nextLine());
                                break;
                            case 2:
                                //criar novo device
                                System.out.println("Qual seria o id do device");
                                String id = menu.nextLine();
                                System.out.println("");
                                System.out.print("##--Menu para adicionar quartos e Devices--##\n\n");
                                System.out.println("|----------------------------------------------|");
                                System.out.println("| Opção 1 - SmartSpeaker                       |");
                                System.out.println("| Opção 2 - SmartCamera                        |");
                                System.out.println("| Opção 3 - SmartBulb                          |");
                                System.out.println("|Aperte qualquer outra tecla para acabar criaçao");
                                System.out.println("|----------------------------------------------|");
                                System.out.println("Digite uma opção: ");

                                switch (menu.nextInt()){
                                    case 1:
                                        SmartSpeaker sp = new SmartSpeaker(id);
                                        System.out.println("Volume do SmartSpeaker : ");
                                        sp.setVolume(menu.nextInt());
                                        System.out.println("Channel do SmartSpeaker : ");
                                        sp.setChannel(menu.nextLine());
                                        System.out.println("Qual o nome da Marca ?");
                                        String nome = menu.nextLine();
                                        if (marcas.containsKey(nome)){
                                            sp.setMarca(marcas.get(nome));
                                        }
                                        else{
                                            System.out.println("Qual o custo da Marca ?");
                                            Marca oii = new Marca(nome, menu.nextInt());
                                            sp.setMarca(oii);
                                            marcas.put(nome, oii);
                                        }
                                        break;
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
                                        nova.addDevice(sc);
                                        break;

                                    case 3:
                                        SmartBulb sb = new SmartBulb(id);
                                        System.out.println("Intensidade?");
                                        System.out.println("Warm - 2; Neutral - 1; Cold - 0");
                                        sb.setTone(menu.nextInt());
                                        System.out.println("Dimensão da lâmpada");
                                        sb.setDimensao(menu.nextInt());
                                        System.out.println("Custo diário de energia?");
                                        sb.setCustoEnergia(menu.nextInt());
                                        nova.addDevice(sb);
                                        break;
                                    default:
                                        continue;
                                }


                                break;
                            default:
                                i = 1;
                                
                            }
                        /*
                    //Instalar os devices nos quartos
                    int inst = 0;
                    while(inst == 0)
                    {

                    }

                    }

                         */
                        /*case 2:
                            aux = 1;
                            break;*/
                     }
                case 2:
                    //Simulação
                    break;
                default:
                    aux = 1;
                    break;

            }


        }
    }
    public static void main(String[] args) throws FileNotFoundException
    {

        Scanner menu = new Scanner (System.in);

        Simulacao simular = new Simulacao();
        System.out.println("##--Bem vindo a simulação de casas inteligentes--##\n");

        System.out.println("Selecione a sua opção:");
        System.out.println("|----------------------------------------------|");
        System.out.println("| Opção 0 - Usar a configuraçao anterior       |");
        System.out.println("| Opção 1 - Criar nova configuraçao            |");
        System.out.println("| Para sair aperte qualquer tecla              |");
        System.out.println("|----------------------------------------------|");

        int input = menu.nextInt();
        switch (input)
        {
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
                switch (input1)
                {
                    //Configuração através de ficheiro
                    case 0:
                        String arquivo1 = "";
                        simular = new Simulacao(arquivo1);
                        break;
                    //Configuraçao nova
                    case 1:
                        Simulacao simular1 = new Simulacao();

                        break;
                    default:
                        System.out.println("Fechando Progama");
                        System.exit(0);

                }
                break;
            default:
                System.out.println("Fechando Progama");
                System.exit(0);

        }
        criarNovoSimular(simular);
    }
}



