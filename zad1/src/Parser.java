import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static double[][] parse (String path) throws FileNotFoundException {

        BufferedReader br1 = new BufferedReader(new FileReader(new File(path)));

        List<String> lines = br1.lines().collect(Collectors.toList());
        double[][] elements = new double[lines.size()][];
        int n = 0;

        for(String l : lines) {
            String[] parts = l.split("\\s+");
            double[] colElements = new double[parts.length];
            int i = 0;
            for(String p : parts) {
                colElements[i++] = Double.valueOf(p);
            }

            elements[n++] = colElements;

        }
        return  elements;
    }

    public static void writeToFile ( String path, Matrix matrix) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
        if( matrix.getCardinality() != 0) {
            writer.append(matrix.toString());
            writer.close();
        }
    }

    public static void printMatrix (Matrix matrix) {
        System.out.println(matrix.toString());
    }
}
