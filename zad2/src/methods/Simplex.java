package methods;

import goalFunctions.Function2;
import goalFunctions.GoalFunction;
import interval.Vector;

import java.util.ArrayList;
import java.util.List;


public class Simplex {

   // private static double step = 1;
    private static double e = 10E-6;
    private static double alpha = 1;
    private static double beta = 0.5;
    private static double gamma = 2;
    private static double sigma = 0.5;



    public static Vector simplexMethod (Vector x0, GoalFunction f, int step) {
        List<Vector> X = calculatePoints(x0, step);

        int h, l;
        Vector Xc, Xr, Xe, Xk;
        do {

            h = findMax(X, f);
            l = findMin(X, f);
            Xc = calculateCentroid(X, X.get(h));
            Xr = reflection(Xc, X.get(h)); //najlosija tocka se reflektira u odnosu na centroid


            if(f.calculate(Xr) < f.calculate(X.get(l))) {
                Xe = expansion(Xc, Xr); // udaljavanje Xr od centroida

                if(f.calculate(Xe) < f.calculate(X.get(l)))
                    X.set(h, Xe);
                else
                    X.set(h, Xr);
            } else {
                if(compare(Xr, X, f)) { //Xr ima najvecu vrijednost funkcije
                    if(f.calculate(Xr) < f.calculate(X.get(h)))
                        X.set(h, Xr);
                    Xk = contraction(Xc, X.get(h)); //priblizavanje centroidu
                    if(f.calculate(Xk) < f.calculate(X.get(h)))
                        X.set(h, Xk);
                    else {
                        X = shiftPoints(X, X.get(l));
                    }

                }else {
                    X.set(h, Xr);
                }
            }
            System.out.println("Xc = " + Xc);
            System.out.println("f(Xc) = " + f.calculate(Xc));
            f.setNumberOfCalls(f.getNumberOfCalls()-1);

        } while(!checkIfEnd(X, Xc, f));

        return X.get(l);
    }

    public static List<Vector> shiftPoints (List<Vector> X, Vector Xl) {
        List<Vector> newX = new ArrayList<>();

        for(Vector x : X) {
            newX.add(x.scalarMultiply(sigma).add(Xl.scalarMultiply(sigma)));
        }
        return newX;
    }


    public static boolean compare (Vector Xr, List<Vector> X, GoalFunction f) {
        double value = f.calculate(Xr);
        for(Vector x : X) {
            if (value <= f.calculate(x)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkIfEnd(List<Vector> X, Vector centroid, GoalFunction f){
        double value = f.calculate(centroid);
        double res = 0;
        for(Vector x : X) {
            res += Math.pow(value - f.calculate(x), 2);
        }

        return (Math.sqrt(res / centroid.size()) <= e);
    }


    public static List<Vector> calculatePoints(Vector x0, int step) {

        List<Vector> points = new ArrayList<>();
        points.add(x0);

        Vector temp;
        for(int i = 0; i < x0.size(); i++) {
            temp = x0.copy();
            temp.setValue(i, x0.getValueAt(i) + step);
            points.add(temp);
        }
        return points;

    }

    public static int findMax(List<Vector> X, GoalFunction f) {
        int index = 0;
        double max = 0;
       for( int i = 0; i < X.size(); i++) {
           Vector v = X.get(i);
           double value = f.calculate(v);
           if(value > max) {
               max = value;
               index = i;
           }

       }
       return index;
    }

    public static int findMin(List<Vector> X, GoalFunction f) {
        int index = 0;
        double min = 0;
        for( int i = 0; i < X.size(); i++) {
            Vector v = X.get(i);
            double value = f.calculate(v);
            if(value < min) {
                min = value;
                index = i;
            }
        }
        return index;
    }

    public static Vector reflection (Vector c, Vector h ) {
        Vector x1 = c.scalarMultiply(alpha + 1);
        Vector x2 = h.scalarMultiply(alpha);

        return x1.sub(x2);
    }

    public static Vector expansion(Vector c, Vector r) {
        Vector x1 = c.scalarMultiply(1 - gamma);
        Vector x2 = r.scalarMultiply(gamma);

        return x1.add(x2);
    }

    public static Vector contraction(Vector c, Vector h) {
        Vector x1 = c.scalarMultiply(1 - beta);
        Vector x2 = h.scalarMultiply(beta);

        return x1.add(x2);

    }

    public static Vector calculateCentroid (List<Vector> X, Vector h) {
        double [] values = new double[h.size()];

        for(Vector x : X) { //najlosija tocka
            if(x.equals(h)) continue;

            for (int i = 0; i < x.size(); i++) {
                values[i] += x.getValueAt(i);
            }
        }

        for (int i = 0; i < values.length; i++) {
            values[i] /= (X.size()-1) ;
        }

        return new Vector(values);
    }
}
