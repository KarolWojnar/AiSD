package Plecak;

public class PlecakDyn {
    final static int[]vi = {6, 2, 3, 2, 3, 1};
    final static int[]wi = {6, 4, 5, 7, 10, 2};
    final static int maxV = 10;
    final static int N = 6;
    public static void main(String[] args) {
        int[][]x = new int[N][maxV+1];
        //pierwszy wiersz
        for(int i = 0; i <= maxV; i++)
        {
            if(i < vi[0]) x[0][i] =  0;
            else x[0][i] = wi[0];
        }
        //reszta
        for(int i = 1; i < N; i++)
        {
            for(int j = 0; j <= maxV; j++)
            {
                if(j < vi[i]) x[i][j] = x[i-1][j];
                else
                {
                    int p1 = x[i-1][j];
                    int p2 = wi[i] + x[i-1][j - vi[i]];
                    x[i][j] = Math.max(p1,p2);
                }
            }
        }
        System.out.println("v:\t 0  1   2   3   4   5   6   7   8   9   10");
        System.out.println("---------------------");
        for(int i = 0; i < N; i++)
        {
            System.out.println("\ni:\t" + i + ": ");
            for(int j = 0; j <= maxV; j++)
            {
                int var = x[i][j];
                if(var < 100) System.out.print("  ");
                if(var < 10) System.out.print(" ");
                System.out.print(x[i][j]);
            }
        }
    }
}
