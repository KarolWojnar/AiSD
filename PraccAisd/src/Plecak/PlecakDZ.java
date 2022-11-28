package Plecak;

public class PlecakDZ {

    static final int N = 6;
    static final int vMax = 10;
    static final int[]jakosc = {6,4,5,7,10,2};
    static final int[] wielkosc = {6,2,3,2,3,1};
    public static int plecak(int x, int y)
    {
        if(x == 0 && y < wielkosc[0]) return 0;//brak miejsca dal czegokolwiek
        if(x == 0 && y >= wielkosc[0]) return jakosc[0];//miejsce na 1 przedmiot w[0]
        int w1 = plecak(x-1, y);//stara wartosc przypisanie
        int w2 = jakosc[x] + plecak(x - 1, y - wielkosc[x]);// wartosci nowe
        if( x > 0 && y < wielkosc[x]) return w1;//brak miejsca na kolejny rozedmiot wiec zwracamy wartosc z ostatniego przypisania plecaka
        return Math.max(w1, w2);//wybranie bardziej wartościowego plecaka
    }

    public static void main(String[] args) {
        System.out.println("Max wartosc to:\n" + plecak(N-1, vMax));
    }

}
