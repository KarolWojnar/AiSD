package Plecak;

import java.util.Random;

public class PlecakMonteCarlo {
    static final int N = 6;
    static final int vMax = 10;

    static final int[]jakosc = {6,4,5,7,10,2};
    static final int[] wielkosc = {6,2,3,2,3,1};

    public static void main(String[] args) {
        String optK = new String();
        int optW = -1;
        int optJ = 0;
        Random los = new Random();

        for(int i = 0; i < 10; i++)//10 prob losowania
        {
            int[] ustaw = new int[N];
            for(int j = 0; j < N; j++) ustaw[j] = j;//wstepne ustawienie przedmiotów od 0 do 5
            for(int j = 0; j < N; j++)//tasowanie
            {
                int randIndex = los.nextInt(N);
                if(randIndex != j)
                {
                    int pom = ustaw[j];//zamiana
                    ustaw[j] = ustaw[randIndex];
                    ustaw[randIndex] = pom;
                }
            }
            String locK = new String();
            int sumW = 0;
            int sumJ = 0;
            int j = 0;
            //wkladamy do plecaka przedmioty juz z przetasowanej tablicy(np najpierw sprawdzamy przedmiot 3 > 2 > 4 a nie 1>2>3>4)
            while((j < N) && ((sumW +wielkosc[ustaw[j]]) <= vMax))
            {
                sumW += wielkosc[ustaw[j]];
                sumJ += jakosc[ustaw[j]];
                locK = locK + " " + ustaw[j];
                j++;
            }
            if(sumJ > optJ)
            {
                optW = sumW;
                optJ = sumJ;
                optK = locK;
            }
        }
        System.out.println("Calkowita objetość: " + optW);
        System.out.println("Calkowita wartosc: " + optJ);
        System.out.println("Konfiguracja: " + optK);
        System.out.println("Niewykorzystana objętość: " + (vMax - optW));
    }
}
