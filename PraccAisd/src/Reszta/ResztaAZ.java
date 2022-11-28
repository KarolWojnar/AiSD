package Reszta;

import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;

public class ResztaAZ {
    public static void main(String[] args)throws IOException {
        try {
            Scanner daj = new Scanner(System.in);
            final int[] Monety = {500, 200, 100, 50, 20, 10, 5, 2, 1};//monetki w zł*100
            int[] ileMonet = {3, 2, 7, 2, 1, 3, 6, 4, 0};//max 27.88
            float zl, gr, r;
            int i = 0;
            System.out.println("podaj reszte jaką mam Ci wydać: ");
            System.out.print("ile zł: ");
            zl = daj.nextInt();
            System.out.print("podaj ile gr Ci wiszę: ");
            gr = daj.nextInt();
            r = zl * 100 + gr;
            System.out.println("Reszta do oddania to: " + r * 0.01 + "zł");
            while (r > 0 && i < Monety.length) {
                if ((ileMonet[i] > 0) && (Monety[i] <= r)) {
                    ileMonet[i]--;
                    r -= Monety[i];
                } else i++;
            }
            System.out.println("Wydane monety: ");
            for (int j = 0; j < Monety.length; j++) {
                System.out.println(Monety[j] * 0.01 + "  zostało: " + ileMonet[j]);
            }
            if(r != 0) System.out.println("Bede winny: " + r * 0.01 + "zł");
        }catch (Exception e)
        {
            System.out.println("Podales nieporawną wartość\n");
            System.out.println("Podaj liczbę: ");
            main(args);
        }
    }
}
