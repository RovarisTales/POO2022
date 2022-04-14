import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Teste
{

    public static void main(String[] args)
    {
        /*
        SmartBulb sb1 = new SmartBulb("sb1",1,10,4);
        SmartBulb sb2 = new SmartBulb("sb2",1,20,2);
        SmartCamera sc1= new SmartCamera("sc1'",1,300);
        SmartCamera sc2 = new SmartCamera("sc2",0.6,500);
        SmartCamera sc3 = new SmartCamera("sc3",0.3,700);
        SmartSpeaker sp1 = new SmartSpeaker("sp1", "RUM", 5);
        SmartSpeaker sp2 = new SmartSpeaker("sp2", "TEQUILA", 7);

        CasaInteligente ci1 = new CasaInteligente("Tales","Artur Bivar",917,"PauEmOrelha");
        CasaInteligente ci2 = new CasaInteligente("Breno", "Rua da fonte seca",913, "PauEmOuvido");
        ci1.addDevice(sb1);
        ci1.addRoom("Quarto");
        ci1.addToRoom("Quarto",sb1.getID());
        System.out.println(ci1.existsDevice(sb1.getID()));
        ci1.addRoom("Cozinha");
        ci1.addDevice(sc1);
        ci1.addToRoom("Cozinha",sc1.getID());
        ci1.addRoom("Sala");
        ci1.addDevice(sp1);
        ci1.addToRoom("Sala",sp1.getID());
        //adicionando a casa 2
        ci2.addDevice(sb2);
        ci2.addRoom("Quarto");
        ci2.addToRoom("Quarto",sb2.getID());
        ci2.existsDevice(sb2.getID());
        ci2.addRoom("Cozinha");
        ci2.addDevice(sc2);
        ci2.addToRoom("Cozinha",sc2.getID());
        ci2.addRoom("Sala");
        ci2.addDevice(sp2);
        ci2.addToRoom("Sala",sp2.getID());


        /*System.out.println(ci1.custoDiario() + " Outra " + ci2.custoDiario());
        System.out.println(ci2.getDevices());
        System.out.println(ci1.toString());
        System.out.println("\nESPAÇO\n");
        System.out.println( ci2.toString());
        System.out.println(ci1.equals(ci2) + " outro " +  ci1.equals(ci1.clone()));*/
        /*
        System.out.println("\nTESTAR O CLONE\n");
        System.out.println(ci1.getDevices());
        System.out.println(ci1.getLocations());
        System.out.println(ci1.clone());


        /*CasaInteligente ci3 = ci1.clone();
        ci1.setAllOn(true);
        System.out.println(ci1.equals(ci3));
        System.out.println(ci1.roomHasDevice("Quarto","sb1"));
        System.out.println(ci1.roomHasDevice("Quarto","sb2"));

        System.out.println(ci1.getLocations().toString());
        System.out.println(ci1.getDevices().values());
        */



        /*
        System.out.println(sb1.toString() + sb2.toString());
        System.out.println(sb1.getCustoDiario() + " outro " + sb2.getCustoDiario());
        System.out.println(sb1.custoEnergia() + " outro " + sb2.custoEnergia());
        System.out.println(sb1.equals(sb2));
        SmartBulb sb3 = sb1.clone();
        System.out.println(sb1.equals(sb3) + " " + sb3.toString());
        System.out.println(sb3.toString());


        ComercializadorEnergia ce1 = new ComercializadorEnergia("PauEmOuvido",6.9,0);
        ComercializadorEnergia ce2 = new ComercializadorEnergia("PauEmOrelha",2.8,0);
        ce1.addFatura(910,"au","Octavio");
        System.out.println(ce1.clone().toString());
        System.out.println(ce1.getFaturas());
        System.out.println(ce1.preçoDiaDisp(50));
        System.out.println(ce1.equals(ce1.clone()) + " Outra " + ce1.equals(ce2));
        */


    }
}
