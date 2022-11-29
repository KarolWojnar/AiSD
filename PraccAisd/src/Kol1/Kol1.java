package Kol1;

import java.util.Random;

public class Kol1 {
    public static void main(String[] args) {
        for(int i = 0; i < 1; i++)
        {
            System.out.println(pole());
        }
    }
    static void zad1()
    {
        final double grupa = 100000;
        int dzien = 1;
        int pierwszyDzien = 10;
        double liczbaZarazonych = 0;
        int[]tab = new int[120];
        tab[1] = pierwszyDzien;
        while(true)
        {
            System.out.print("\nDzień: " + dzien);
            System.out.print(", [ ");
            System.out.print(tab[dzien]);
            dzien++;
            liczbaZarazonych = tab[dzien - 1] + tab[dzien - 1];
            if(dzien >= 7) liczbaZarazonych -= tab[dzien - 7];
            tab[dzien] = (int) liczbaZarazonych;
            System.out.print(" ]\t");
            if(tab[dzien] > (grupa/2))
            {
                System.out.println("Połowę chorych grupa przekroczy w dniu: " + dzien + " i bedzie to " + tab[dzien] + " chorych");
                break;
            }
        }

    }
    static float pole()
    {
        Random los = new Random();
        int licz = 0;
        for(int i = 0; i < 100; i++)
        {
            float a = (float) (los.nextFloat(700)/1000.0);
            System.out.println("a: " + a);
            float b = (float) (0.4 + los.nextFloat(700)/1000.0);
            System.out.println("b: " + b);
            if(a < (Math.pow(b/10, b)))
            {
                licz++;
            }
        }
        return (float) (licz/100.0);
    }
}
