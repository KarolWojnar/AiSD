package zad2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Masz 25 zł, podaj ile wydajewsz a ja powiem ile masz reszty w jakich monetach");
        Scanner daj = new Scanner(System.in);
        float resztaZl, resztaGr;
        System.out.println("ile zł: ");
        resztaZl = daj.nextFloat();
        System.out.println("ile gr: ");
        resztaGr = daj.nextFloat();
        float doWydania = 2500 - resztaZl*100 - resztaGr;
        int[] tab = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int[] ileMonet = {2, 3, 2, 3, 3, 2, 9, 7, 10};
//        ileOddac(doWydania, tab);
        ileMaszMonet(doWydania, tab, ileMonet);
    }
    static void ileOddac(float oddaj, int[]tab)
    {
        int[]sumuj = {0,0,0,0,0,0,0,0,0};
        System.out.println("Do oddania: \t" + oddaj/100.0);
        for(int i = 0; i <= tab.length-1; i++)
        {
            while((oddaj - tab[i]) >= 0)
            {
                sumuj[i]++;
                System.out.println(sumuj[i]);
                oddaj = oddaj - tab[i];
            }
        }

        for(int i = 0; i <= tab.length-1; i++)
        {
            System.out.println(tab[i]/100.0 + "zł: \t" + sumuj[i]);
        }
    }
    static void ileMaszMonet(float oddaj, int[]tab, int[]monety)
    {
        System.out.println("Do oddania: \t" + oddaj/100.0);
        for(int i = 0; i < tab.length; i++)
        {
            while((oddaj - tab[i]) >= 0)
            {
                if(monety[i] == 0)break;
                else
                {
                    oddaj -= tab[i];
                    monety[i]--;}
            }
        }
        for(int i = 0; i < tab.length; i++)
        {
            System.out.println(tab[i]/100.0 + "zł: pozostało monet:\t" + monety[i]);

        }
        System.out.println("reszta nieoddana: \t" + oddaj/100.0);
    }
}
