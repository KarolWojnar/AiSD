package Newton;

public class NewtonDyn {
    final static int N = 5;
    final static int K = 3;

    public static void main(String[] args) {
        int[][]tab = new int[K+1][N+1];
        for(int i = 0; i <= N ; i++) tab[0][i] = 1;
        for(int i = 0; i <= K; i++) tab[i][i] = 1;
        for(int i = 1; i <= K; i++)
        {
            for(int j = 2; j <= N; j++)
            {
                if(j < i) continue;
                tab[i][j] = tab[i - 1][j - 1] + tab[i][j - 1];
            }
        }
        for (int i=0; i<=K; i++)
        {
            for (int j=0; j<=N; j++)
            {
                int val = tab[i][j];
                if (val<100) System.out.print(" ");
                if (val<10) System.out.print(" ");
                System.out.print(val+"  ");
            }
            System.out.println();
        }
    }
}
