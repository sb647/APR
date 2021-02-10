package demo;

import goalFunctions.Function6;
import interval.Vector;
import methods.Simplex;


public class Zadatak5 {
    private static double e = 10E-6;

    public static void main(String[] args) {
        Function6 f6 = new Function6(2);

        int counter = 0;

        for(int i = 0; i < 1001; i++) {

            double x1 = getRandomNumber(-50, 50);
            double x2 = getRandomNumber(-50, 50);
            Vector v = Simplex.simplexMethod(new Vector(x1,x2), f6, 1);
            if(f6.calculate(v) < 1e-4)
                counter++;
        }

        double p = (double) counter / 1000 * 100 ;
        System.out.println("p = " +p + "%");
    }

    public static double getRandomNumber(int min, int max) {
        return (double) ((Math.random() * (max - min)) + min);
    }

}
