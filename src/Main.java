import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main (String[]args) throws IOException {

        Scanner menu = new Scanner(System.in);
        Menu me = new Menu();
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
                simular = new Simulacao("anterior.txt");
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
        me.criarNovoSimular(simular);

        System.out.println(simular);
    }
}