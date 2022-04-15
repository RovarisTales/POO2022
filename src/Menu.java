import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Menu {

    public static void criarNovoSimular(Simulacao simular) {
        Scanner menu = new Scanner (System.in);
        int aux = 0;
        while(aux == 0) {
            System.out.print("##--Menu para adicionar Casas e Devices--##\n\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| Opção 1 - Nova casa         |\n");
            System.out.print("| Opção 2 - sair           |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");

            int opcao = menu.nextInt();

            switch(opcao) {
                case 1:
                    int i = 0;
                    CasaInteligente nova = new CasaInteligente();
                    System.out.println("Nome do proprietatário");
                    nova.setProprietario(menu.nextLine());
                    System.out.println("Morada :");
                    nova.setMorada(menu.nextLine());
                    System.out.println("Nif :");
                    nova.setNIF(menu.nextInt());
                    System.out.println("Comercializador de energia :");
                    nova.setComercializadorEn(menu.nextLine());
                    while(i == 0){
                        System.out.print("##--Menu para adicionar quartos e Devices--##\n\n");
                        System.out.println("|-------------------------------------------|");
                        System.out.println("| Opção 1 - novo quarto                     |");
                        System.out.println("| Opção 2 - novo device                     |");
                        System.out.println(" aperte qualquer outra tecla para acabar criaçao");
                        System.out.println("|-------------------------------------------|");
                        System.out.println("Digite uma opção: ");
                        int op2 = menu.nextInt();

                        switch(op2) {
                            case 1:
                                //criar novo quarto na casa
                                System.out.println("diga o nomo do quarto");
                                nova.addRoom(menu.nextLine());
                                break;
                            case 2:
                                //criar novo device
                                System.out.println("Qual seria o id do device");
                                String id = menu.nextLine();
                                System.out.println("");
                                System.out.print("##--Menu para adicionar quartos e Devices--##\n\n");
                                System.out.println("|-------------------------------------------|");
                                System.out.println("| Opção 1 - Smar Speaker                    |");
                                System.out.println("| Opção 2 - Smar Camera                     |");
                                System.out.println("| Opção 3 - Smar Bulb                       |");
                                System.out.println(" aperte qualquer outra tecla para acabar criaçao");
                                System.out.println("|-------------------------------------------|");
                                System.out.println("Digite uma opção: ");

                                break;
                            default:
                                i=1;
                        }
                    //Instaçalar os devices nos quartos
                    int inst = 0;
                    while(inst == 0){

                    }
                    }
                case 2:
                    aux = 1;

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


