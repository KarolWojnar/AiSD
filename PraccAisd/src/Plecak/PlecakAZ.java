package Plecak;

public class PlecakAZ {
    static final int N = 6;
    static final int vMax = 10;

    static final int[]jakosc = {6,4,5,7,10,2};
    static final int[] wielkosc = {6,2,3,2,3,1};
    //kolejnosc rosnąca objętość

    static void pakujMale()
    {
        boolean[]rozw = new boolean[N];
        for(int i = 0; i < N; i++) rozw[i] = false; // czyszczenie plecaka
        int sumJ = 0;
        int sumW = 0;

        while(true)
        {
            int minW = Integer.MAX_VALUE;
            int maxPoz = -1;
            for(int i = 0; i < N; i++)//sprawdzamy każdy przedmiot
            {
                if(!rozw[i])//jesli zapakowany to skip
                {
                    if(((sumW + wielkosc[i]) <= vMax) && (wielkosc[i] < minW))//jesli da sie kolejny włożyć i jeśli jest on mniejszy od aktualnie najmniejszego
                    {
                        minW = wielkosc[i];//ustawiamy go najmniejszym
                        maxPoz = i;// bierzemy index tego przedmiotu
                    }
                }
            }
            if(maxPoz > -1)//jesli zmieniła sie wart max poz
            {
                rozw[maxPoz] = true;//pakujemy przedmiot aktualnie najmniejszy
                sumJ += jakosc[maxPoz];//dodajemy jego jakosc
                sumW += wielkosc[maxPoz];//dodajemy jego wielkosc
            }
            else break;
        }
        System.out.println("Wartosc optymalnie zapakowanego plecaka - Pakuj Małe: " + sumJ);
        System.out.println("Przedmioty w plecaku: ");
        System.out.print("[\t");
        for(int i = 0; i < N; i++)
        {
            if(rozw[i] == true) System.out.print(i + "\t");
        }
        System.out.print("]\n");
    }
    //wersja pakuj od najcenniejszych
    static void pakujCenne()
    {
        boolean[]rozw = new boolean[N];
        for(int i = 0; i < N; i++) rozw[i] = false; // czyszczenie plecaka
        int sumJ = 0;
        int sumW = 0;

        while(true)
        {
            int maxJ = Integer.MIN_VALUE;
            int maxPoz = -1;

            for(int i = 0; i < N; i++)
            {
                if(!rozw[i])
                {
                    if(((sumW + wielkosc[i]) <= vMax) && (maxJ < jakosc[i]))
                    {
                        maxJ = jakosc[i];
                        maxPoz = i;
                    }
                }
            }
            if(maxPoz > -1)
            {
                rozw[maxPoz] = true;
                sumJ += jakosc[maxPoz];
                sumW += wielkosc[maxPoz];
            }
            else break;
        }

        System.out.println("Wartosc optymalnie zapakowanego plecaka - Pakuj Cenne: " + sumJ);
        System.out.println("Przedmioty w plecaku: ");
        System.out.print("[\t");
        for(int i = 0; i < N; i++)
        {
            if(rozw[i] == true) System.out.print(i + "\t");
        }
        System.out.print("]\n");
    }
    //pakuj na ilorazie
    static void pakujNaIlorazie()
    {
        boolean[]rozw = new boolean[N];
        for(int i = 0; i < N; i++) rozw[i] = false; // czyszczenie plecaka
        int sumJ = 0;
        int sumW = 0;

        while(true)
        {
            float maxFrac = 0;
            int maxPoz = -1;

            for(int i = 0; i < N; i++)
            {
                float frac = (float) jakosc[i]/wielkosc[i];
                if(!rozw[i])
                {
                    if(((sumW + wielkosc[i]) < vMax) && (maxFrac < frac))
                    {
                        maxFrac = frac;
                        maxPoz = i;
                    }
                }
            }
            if(maxPoz > -1)
            {
                sumJ += jakosc[maxPoz];
                sumW += wielkosc[maxPoz];
                rozw[maxPoz] = true;
            }
            else break;
        }
        System.out.println("Wartosc optymalnie zapakowanego plecaka - Pakuj ilorazem malejąco: " + sumJ);
        System.out.println("Przedmioty w plecaku: ");
        System.out.print("[\t");
        for(int i = 0; i < N; i++)
        {
            if(rozw[i] == true) System.out.print(i + "\t");
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        pakujMale();
        pakujCenne();
        pakujNaIlorazie();
    }
}
