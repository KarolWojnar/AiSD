package Reszta;

import java.util.Random;
import java.util.Scanner;

public class ResztaMonteCarlo {
    public static void main(String[] args) {
        try{
            Scanner daj = new Scanner(System.in);
            Random los = new Random();
            final int[] Monety = {500, 200, 100, 50, 20, 10, 5, 2, 1};
            final int limitMonet = 500;
            final int ileLosowan = 100;
            int minMonetUzytych = limitMonet;
            int[]uzyteTeraz = new int[limitMonet];
            int[]najmnijeUzytych = new int[limitMonet];
            int r, zl, gr, moneta;
            System.out.println("Podaj ile zl: ");
            zl = daj.nextInt();
            System.out.println("ile groszy: ");
            gr = daj.nextInt();
            System.out.println("Do wydania: " + (zl * 100 + gr) * 0.01 + "zł");
            for(int i = 0; i < ileLosowan; i++)
            {
                r = zl * 100 + gr;
                int ileUzytychTeraz = 0;
                while((r > 0) && (ileUzytychTeraz < limitMonet))
                {
                    moneta = Monety[los.nextInt(Monety.length)];
                    if(r >= moneta)
                    {
                        r -= moneta;
                        uzyteTeraz[ileUzytychTeraz] = moneta;
                        ileUzytychTeraz++;
                    }
                }
                if(minMonetUzytych > ileUzytychTeraz)
                {
                    minMonetUzytych = ileUzytychTeraz;
                    for(int j = 0; j < minMonetUzytych; j++)
                    {
                        najmnijeUzytych[j] = uzyteTeraz[j];
                    }
                }
            }
            if(minMonetUzytych < limitMonet)
            {
                System.out.println("Reszta podana w:");
                for (int i = 0; i < minMonetUzytych; i++)
                {
                    System.out.println(najmnijeUzytych[i] * 0.01 + "zł");
                }
            }
            else System.out.println("Nie zmiesciles sie w limicie :(");


        }catch (Exception e){
            System.out.println("bledne dane, powtórz próbę: \n\n");
            main(args);
        }
    }
}
