package Newton;

public class Newton {


    public static void main(String[] args) {
        final int N  = 5;
        final int K  = 3;
        System.out.println(newton(N, K));
    }
    static int newton(int n, int k)
    {
        if(k == 0 || n == k) return 1;
        else return newton(n - 1, k - 1) + newton(n - 1 , k);
    }
}
