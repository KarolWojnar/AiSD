package Fibbo;

public class FibboDyn {
    public static void main(String[] args) {
        final int N = 8;
        System.out.println(fibbo(N));
    }
    static int fibbo(int n)
    {
        int[]tab = new int[n + 1];
        tab[1] = 1;
        tab[2] = 1;
        for(int i = 3; i < tab.length; i++)
        {
            tab[i] = tab[i - 1] + tab[i - 2];
        }
        return tab[n];
    }
}
