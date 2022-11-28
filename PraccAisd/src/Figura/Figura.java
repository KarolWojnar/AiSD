package Figura;

import java.util.Random;

public class Figura {
    public static void main(String[] args) {
        Random los = new Random();
        int zlicz = 0;
        for(int j = 0; j < 10; j++)
        {
            for(int i = 0; i < 1000; i++)
            {
                double x = los.nextInt(1001)/1000.0;
                double y = los.nextInt(1001)/1000.0;
                if(y < (x/4)) zlicz++;
            }
            System.out.println("Pole = " + zlicz*0.001);
            zlicz = 0;
        }
    }
}
