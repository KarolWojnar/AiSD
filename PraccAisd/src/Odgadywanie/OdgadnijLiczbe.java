package Odgadywanie;

import java.util.Random;

public class OdgadnijLiczbe {
    public static void main(String[] args) {
        Random los = new Random();
        System.out.println("Zgadne Twoją liczbe w 10 ruchach max");
        int liczba = los.nextInt(1001);
        System.out.println(liczba);
        int a = 0, b = 1000;
        int krok = 0;
        while(true)
        {
            System.out.print("Krok " + ++krok +", czy Twoja liczba to: " + (a + b) / 2 + "?\t");
            if(liczba > (a + b) / 2)
            {
                System.out.println("Za mała");
                a = zgaduj(a, b);
            }
            else if(liczba < (a + b) / 2)
            {
                System.out.println("Za duża");
                b = zgaduj(a, b);
            }
            else if(liczba == (a + b) / 2)
            {
                System.out.println("To twoja liczba: " + (a + b) / 2);
                break;
            }
        }
    }
    static int zgaduj(int x, int y)
    {
        return (x + y) / 2;
    }
}
