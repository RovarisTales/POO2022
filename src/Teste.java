public class Teste
{

    public static void main(String[] args)
    {
        SmartBulb sb1 = new SmartBulb("b1",0,10,1);
        SmartBulb sb2 = new SmartBulb("b2",1,20,2);

        System.out.println(sb1.toString() + sb2.toString());

        System.out.println(sb1.getCustoEnergia() + " outro " + sb2.getCustoEnergia());

        System.out.println(sb1.custoEnergia() + " outro " + sb2.custoEnergia());
        System.out.println(sb1.equals(sb2));
        SmartBulb sb3 = sb1.clone();
        System.out.println(sb1.equals(sb3) + sb3.toString());

        System.out.println(sb3.toString());
    }
}
