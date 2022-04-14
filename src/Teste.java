import java.util.HashMap;
import java.util.Map;

public class Teste
{

    public static void main(String[] args)
    {
        SmartBulb sb1 = new SmartBulb("b1",0,10,1);
        SmartBulb sb2 = new SmartBulb("b2",1,20,2);
        sb1.setOn(true);
        SmartCamera sc1 = new SmartCamera("b3",true,1,300);
        SmartCamera sc2 = new SmartCamera("b5",true,0.6,500);
        SmartCamera sc3 = new SmartCamera("b6",true,0.3,700);
        SmartSpeaker sp1 = new SmartSpeaker("b7", "RUM", 5);
        SmartSpeaker sp2 = new SmartSpeaker("b8", "TEQUILA", 7);
        
        


        CasaInteligente ci1 = new CasaInteligente()
        CasaInteligente ci2 = new CasaInteligente("Breno", "Rua da fonte seca",913,
                "PauEmOuvido");
        ci1.addDevice(sb1);
        ci1.addRoom("Quarto");
        ci1.addToRoom("Quarto",sb2.getID());
        ci1.existsDevice(sb1.getID());
        /*
        System.out.println(sb1.toString() + sb2.toString());
        System.out.println(sb1.getCustoDiario() + " outro " + sb2.getCustoDiario());
        System.out.println(sb1.custoEnergia() + " outro " + sb2.custoEnergia());
        System.out.println(sb1.equals(sb2));
        SmartBulb sb3 = sb1.clone();
        System.out.println(sb1.equals(sb3) + " " + sb3.toString());
        System.out.println(sb3.toString());
         */
    }
}
