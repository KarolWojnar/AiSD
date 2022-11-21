package zadad;

public class Main {
    public static void main(String[] args) {
        int losowaLiczba = (int) (Math.random()*1000);
        int a = 0, b = 1000;
        int srodek = (a+b)/2;
        int lKrok = 1;
        System.out.println(losowaLiczba);
        while(true)
        {
            System.out.print("Czy Twoja liczba to: " + srodek + "\t");
            if(srodek > losowaLiczba)
            {
                System.out.println("Za duża \t próba " + lKrok);
                 srodek = findMe(a, b = srodek -1);
            }
            else if(srodek < losowaLiczba)
            {
                System.out.println("Za mała \t próba " + lKrok);
                srodek = findMe(a = srodek + 1, b);
            }
            else{
                System.out.println("Trafiłeś!");
                break;
            }
            lKrok++;
        }
    }
    static int findMe(int a, int b)
    {
        return (a + b) / 2;
    }
}