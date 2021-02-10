import java.awt.event.MouseAdapter;
import java.io.FileNotFoundException;

public class Demo {

    public static void main(String[] args) throws FileNotFoundException {

        Matrix m2 = new Matrix(Parser.parse("a.txt"));
        Matrix v2 = new Matrix(Parser.parse("vectorA.txt"));
        System.out.println("LUP:");
        Matrix p2 = m2.LUPDecomposition();
        Matrix pb2 = Operations.multiply(p2, v2);
        Matrix x2 = Demo.solve(m2.getLMatrix(), pb2, m2.getUMatrix());
        System.out.println(x2);

        /*
        System.out.println("Zadatak 1:");
        double a[][] = {
                {1.0, 2.0, 3.0},
                {2.0, 3.0, 4.0},
                {4.0, 5.0, 6.0}
        };

        double b[][] = {
                {1.0, 2.0, 3.0},
                {2.0, 3.0, 4.0},
                {4.0, 5.0, 6.0}
        };

        Matrix m11 = new Matrix(a);
        Matrix m12 = new Matrix(b);
        System.out.println(m11.equals(m12));
        m11.scalarMultiply(2);
        m11.scalarMultiply(0.5);
        System.out.println(m11.equals(m12));


        System.out.println();
        System.out.println("Zadatak 2:");
        Matrix m2 = new Matrix(Parser.parse("a.txt"));
        Matrix v2 = new Matrix(Parser.parse("vectorA.txt"));
        System.out.println("LUP:");
        Matrix p2 = m2.LUPDecomposition();
        Matrix pb2 = Operations.multiply(p2, v2);
        Matrix x2 = Demo.solve(m2.getLMatrix(), pb2, m2.getUMatrix());
        System.out.println(x2);

        System.out.println("LU:");
        m2.LUDecomposition();
        x2 = Demo.solve(m2.getLMatrix(), v2, m2.getUMatrix());
        System.out.println(x2);


        System.out.println();
        System.out.println("Zadatak 3:");
        Matrix m3 = new Matrix(Parser.parse("b.txt"));
        System.out.println("LUP");
        Matrix p = m3.LUPDecomposition();
        System.out.println("P:");
        System.out.println(p);
        System.out.println("L:");
        System.out.println(m3.getLMatrix());
        System.out.println("U:");
        System.out.println(m3.getUMatrix());
        System.out.println("LU");
        m3.LUDecomposition();
        System.out.println("L:");
        System.out.println(m3.getLMatrix());
        System.out.println("U:");
        System.out.println(m3.getUMatrix());


        System.out.println();
        System.out.println("Zadatak 4:");
        Matrix m4 = new Matrix(Parser.parse("c.txt"));
        Matrix v4 = new Matrix(Parser.parse("vectorC.txt"));
        Matrix p4 = m4.LUPDecomposition();
        Matrix pb4 = Operations.multiply(p4, v4);
        System.out.println("LUP:");
        System.out.println(Demo.solve(m4.getLMatrix(), pb4, m4.getUMatrix()));
        m4.LUDecomposition();
        System.out.println("LU");
        System.out.println(Demo.solve(m4.getLMatrix(), v4, m4.getUMatrix()));



        System.out.println();
        System.out.println("Zadatak 5:");
        Matrix m5 = new Matrix(Parser.parse("d.txt"));
        Matrix v5 = new Matrix(Parser.parse("vectorD.txt"));
        System.out.println("LUP:");
        Matrix p5 = m5.LUPDecomposition();
        Matrix pb5 = Operations.multiply(p5, v5);
        System.out.println(Demo.solve(m5.getLMatrix(), pb5, m5.getUMatrix()));
        System.out.println("LU:");
        m5.LUDecomposition();
        System.out.println(Demo.solve(m5.getLMatrix(), v5, m5.getUMatrix()));


        System.out.println();
        System.out.println("Zadatak 6:");
        Matrix m6 = new Matrix(Parser.parse("e.txt"));
        Matrix v6 = new Matrix(Parser.parse("vectorE.txt"));
        System.out.println("LUP:");
        Matrix p6 = m6.LUPDecomposition();
        Matrix pb6 = Operations.multiply(p6, v6);
        System.out.println(Demo.solve(m6.getLMatrix(), pb6, m6.getUMatrix()));
        System.out.println("LU:");
        m6.LUDecomposition();
        System.out.println(Demo.solve(m6.getLMatrix(), v6, m6.getUMatrix()));


        System.out.println();
        System.out.println("Zadatak 7:");
        Matrix m7 = new Matrix(Parser.parse("b.txt"));
        System.out.println("Inverz matrice :");
        System.out.println(m7.inverse());

        System.out.println();
        System.out.println("Zadatak 8:");
        Matrix m8 = new Matrix(Parser.parse("f.txt"));
        System.out.println("Inverz matrice :");
        System.out.println(m8.inverse());

        System.out.println();
        System.out.println("Zadatak 9:");
        System.out.println("Determinanta :");
        System.out.println(m8.getDeterminant());

        System.out.println();
        System.out.println("Zadatak 10:");
        Matrix m10 = new Matrix(Parser.parse("a.txt"));
        System.out.println("Determinanta: " + m10.getDeterminant());

         */

    }

    public static Matrix solve(Matrix L, Matrix b, Matrix U) {
        Matrix y = L.forwardSubstitution(b);
        Matrix x = U.backwardSubstitution(y);
        return x;
    }
}
