public class Main {

    static int[][] miasto = {
            {0, 300, 402, 350, -1, -1, -1, -1, -1},
            {300, 0, -1, -1, 440, 474, -1, -1, -1},
            {402, -1, 0, -1, -1, 330, -1, -1, -1},
            {365, -1, -1, 0, -1, -1, 823, -1, -1},
            {-1, 440, -1, -1, 0 ,-1 ,-1 ,430, -1},
            {-1, 474, 330, -1, -1, 0, 813, 365, 774},
            {-1, -1, -1, 823, -1, 812, 0, -1, 403},
            {-1, -1, -1, -1, 430, 365, -1, 0, 768},
            {-1, -1, -1, -1, -1, 774, 403, 768, 0},
    };
    final static int N = 9;
    static int suma;
    static String[] przystanki = {"Warszawa", "Katowice", "Zakopane", "Lwów", "Wiedeń", "Budapeszt",
    "Bukareszt", "Zagrzeb", "Sofia"};
    static String droga= " ";
    static String najlepDroga  =" ";
    static int najkrtDroga = 999999;
    static String wynik = " ";
    private static int[] l = new int[N];
    public static void main(String[] args)
    {
        permutacje(0);
        System.out.println(wynik);
    }
    static void permutacje(int i)
    {
        if (i == N) {
            if (l[0] - 1 == 0) {
                for (int j = 0; j < N - 1; j++)
                {
                    if (miasto[l[j] - 1][l[j + 1] - 1] != -1)
                    {

                        if (l[j] - 1 != 8)
                        {
                            droga += przystanki[l[j]-1]+" ,";
                            suma += miasto[l[j] - 1][l[j + 1] - 1];
                        }else
                        {
                            droga += przystanki[l[j]-1];
                            break;
                        }
                    }
                    else
                    {
                        suma = 0;
                        break;
                    }
                }
                if(suma!=0 && suma<najkrtDroga)
                {
                    najlepDroga = droga;
                    najkrtDroga = suma;
                }
                suma = 0;
                droga = " ";
            }
        }
        else
        {
            for(int j = 1; j <= N; j++)
            {
                int k;
                for(k = 0; k < i; k++)
                {
                    if (l[k] == j) break;
                }
                if (k == i)
                {
                    l[k] = j;
                    permutacje(i+1);
                }
            }
        }
        wynik = "Najkrótsza droga zajmie: "+ najkrtDroga +"km, a przystanki na: "+najlepDroga;
    }
}