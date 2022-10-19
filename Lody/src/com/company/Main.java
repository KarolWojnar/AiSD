package com.company;

public class Main {

        static int tab[][] = {{0,7, 20, 21, 12, 23},
            {27, 0, 13, 16, 46, 5},
            {53, 15, 0, 25, 27, 6},
            {16, 2, 35, 0, 47, 10},
            {31, 29, 5, 18, 0, 4},
            {28, 24, 1, 17, 5, 0}};
        final static int N = 6; // permutacje n-elementowe
        private static int[] L = new int[N];
        static String najKol = "";
        static int najPer = Integer.MAX_VALUE;
        static String pieknaOdpowiedz= "";

        public static void main(String[] args) {

            permutacje(0);
            System.out.println(pieknaOdpowiedz);
        }
        static void permutacje(int i) {
            pieknaOdpowiedz = "";
            int naPoczatek = 0;
            int ostatnie = 0;
            int sum = 0;
            String rozw = "";
            String odp = "";
            if (i == N)
            {
                for (int j = 0; j < N-1; j++)
                {
                    ostatnie = L[j+1]+1;
                    naPoczatek = tab[L[j+1]-1][L[0]-1];
                    sum+=tab[L[j]-1][L[j+1]-1];
                }
                sum+=naPoczatek;
                if(sum<=najPer)
                {
                    for (int j = 0; j < N-1; j++)
                    {
                        int x = tab[L[j]-1][L[j+1]-1];
                        rozw += String.valueOf(x)+", ";
                        odp += String.valueOf(L[j])+", ";
                    }
                    odp+= String.valueOf(L[0]);
                    rozw+=naPoczatek;
                    najPer=sum;
                    najKol = odp;
                }

            }
            else
            {
                for (int j = 1; j <= N; j++)
                {
                    int k;
                    for (k = 0; k < i; k++)
                    {
                        if (L[k] == j)
                        {
                            break;
                        }
                    }
                    if (k == i)
                    {
                        L[k] = j;
                        permutacje(i + 1);
                    }
                }
            }
            pieknaOdpowiedz = "Najlepszy czas zrobienia wszystkich smaków to: "+najPer+" i wychodzi na to, że najlepsza kolejność to np: "+najKol;
        }
    }
