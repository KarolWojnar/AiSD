package Fibbo;

public class FibboDZ {
    public static void main(String[] args) {
        System.out.println(fibbo(7));
    }
    static int fibbo(int n)
    {
        if((n == 1) || (n == 2)) return 1;
        return fibbo(n - 1) + fibbo(n - 2);
    }
}
