import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class PrintToFile {

    public static void main(String[] args) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter("rjesenja/zad1.txt", true));
        writer.append("Zadatak 1:" + System.lineSeparator());
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
        writer.append("A:" + System.lineSeparator());
        writer.append(m11.toString());
        writer.append("B:"+ System.lineSeparator());
        writer.append(m12.toString());
        writer.append("A == B : "+  m11.equals(m12)+ System.lineSeparator());
        m11.scalarMultiply(2);
        m11.scalarMultiply(0.5);
        writer.append("A * 2 / 2 == B : "+  m11.equals(m12)+ System.lineSeparator());
        writer.close();


        BufferedWriter writer2 = new BufferedWriter(new FileWriter("rjesenja/zad2.txt", true));
        writer2.append("Zadatak 2:" + System.lineSeparator());
        Matrix m2 = new Matrix(Parser.parse("a.txt"));
        Matrix v2 = new Matrix(Parser.parse("vectorA.txt"));
        writer2.append("LUP:" + System.lineSeparator());
        Matrix p2 = m2.LUPDecomposition();
        Matrix pb2 = Operations.multiply(p2, v2);
        Matrix x2 = Demo.solve(m2.getLMatrix(), pb2, m2.getUMatrix());
        writer2.append(x2.toString());
        writer2.append("LU:"+ System.lineSeparator());
        m2.LUDecomposition();
        x2 = Demo.solve(m2.getLMatrix(), v2, m2.getUMatrix());
        writer2.append(x2.toString());
        writer2.close();


        BufferedWriter writer3 = new BufferedWriter(new FileWriter("rjesenja/zad3.txt", true));
        writer3.append("Zadatak 3:" + System.lineSeparator());
        Matrix m3 = new Matrix(Parser.parse("b.txt"));
        writer3.append("LUP");
        Matrix p = m3.LUPDecomposition();
        writer3.append("P:"+ System.lineSeparator());
        writer3.append(p + System.lineSeparator());
        writer3.append("L:"+ System.lineSeparator());
        writer3.append(m3.getLMatrix() + System.lineSeparator());
        writer3.append("U:"+ System.lineSeparator());
        writer3.append(m3.getUMatrix() + System.lineSeparator());
        writer3.append("LU"+ System.lineSeparator());
        m3.LUDecomposition();
        writer3.append("L:"+ System.lineSeparator());
        writer3.append(m3.getLMatrix() + System.lineSeparator());
        writer3.append("U:"+ System.lineSeparator());
        writer3.append(m3.getUMatrix().toString());
        writer3.close();


        BufferedWriter writer4 = new BufferedWriter(new FileWriter("rjesenja/zad4.txt", true));
        writer4.append("Zadatak 4:" + System.lineSeparator());
        Matrix m4 = new Matrix(Parser.parse("c.txt"));
        Matrix v4 = new Matrix(Parser.parse("vectorC.txt"));
        Matrix p4 = m4.LUPDecomposition();
        Matrix pb4 = Operations.multiply(p4, v4);
        writer4.append("LUP:"+ System.lineSeparator());
        writer4.append(Demo.solve(m4.getLMatrix(), pb4, m4.getUMatrix()).toString()+ System.lineSeparator());
        m4.LUDecomposition();
        writer4.append("LU"+ System.lineSeparator());
        writer4.append(Demo.solve(m4.getLMatrix(), v4, m4.getUMatrix()).toString());
        writer4.close();



        BufferedWriter writer5 = new BufferedWriter(new FileWriter("rjesenja/zad5.txt", true));
        writer5.append("Zadatak 5:" + System.lineSeparator());
        Matrix m5 = new Matrix(Parser.parse("d.txt"));
        Matrix v5 = new Matrix(Parser.parse("vectorD.txt"));
        writer5.append("LUP:"+ System.lineSeparator());
        Matrix p5 = m5.LUPDecomposition();
        Matrix pb5 = Operations.multiply(p5, v5);
        writer5.append(Demo.solve(m5.getLMatrix(), pb5, m5.getUMatrix()).toString()+ System.lineSeparator());
        writer5.append("LU:"+ System.lineSeparator());
        m5.LUDecomposition();
        writer5.append(Demo.solve(m5.getLMatrix(), v5, m5.getUMatrix()).toString()+ System.lineSeparator());
        writer5.close();


        BufferedWriter writer6 = new BufferedWriter(new FileWriter("rjesenja/zad6.txt", true));
        writer6.append("Zadatak 6:" + System.lineSeparator());
        Matrix m6 = new Matrix(Parser.parse("e.txt"));
        Matrix v6 = new Matrix(Parser.parse("vectorE.txt"));
        writer6.append("LUP:"+ System.lineSeparator());
        Matrix p6 = m6.LUPDecomposition();
        Matrix pb6 = Operations.multiply(p6, v6);
        writer6.append(Demo.solve(m6.getLMatrix(), pb6, m6.getUMatrix()).toString()+ System.lineSeparator());
        writer6.append("LU:"+ System.lineSeparator());
        m6.LUDecomposition();
        writer6.append(Demo.solve(m6.getLMatrix(), v6, m6.getUMatrix()).toString());
        writer6.close();


        BufferedWriter writer7 = new BufferedWriter(new FileWriter("rjesenja/zad7.txt", true));
        writer7.append("Zadatak 7:" + System.lineSeparator());
        Matrix m7 = new Matrix(Parser.parse("b.txt"));
        writer7.append("Inverz matrice :"+ System.lineSeparator());
        writer7.append(m7.inverse() + System.lineSeparator() );
        writer7.close();

        BufferedWriter writer8 = new BufferedWriter(new FileWriter("rjesenja/zad8.txt", true));
        writer8.append("Zadatak 8:" + System.lineSeparator());
        Matrix m8 = new Matrix(Parser.parse("f.txt"));
        writer8.append("Inverz matrice :"+ System.lineSeparator());
        writer8.append(m8.inverse() + System.lineSeparator() );
        writer8.close();

        BufferedWriter writer9 = new BufferedWriter(new FileWriter("rjesenja/zad9.txt", true));
        writer9.append("Zadatak 9:" + System.lineSeparator());
        writer9.append("Determinanta :"+ System.lineSeparator());
        writer9.append(String.valueOf(m8.getDeterminant()));
        writer9.close();

        BufferedWriter writer10 = new BufferedWriter(new FileWriter("rjesenja/zad10.txt", true));
        writer10.append("Zadatak 10:" + System.lineSeparator());
        Matrix m10 = new Matrix(Parser.parse("a.txt"));
        writer10.append("Determinanta: " + m10.getDeterminant() + System.lineSeparator());
        writer10.close();

    }

    public static Matrix solve(Matrix L, Matrix b, Matrix U) {
        Matrix y = L.forwardSubstitution(b);
        Matrix x = U.backwardSubstitution(y);
        return x;
    }


}
