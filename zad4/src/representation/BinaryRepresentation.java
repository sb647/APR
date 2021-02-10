package representation;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class BinaryRepresentation implements Representation{

    public int [] bits;
    public int min;
    public int max;
    private int numberOfBits;
    private int N;
    private int M;


    public BinaryRepresentation(int min, int max, int n, double delta) {
        this.min = min;
        this.max = max;
        N = n;
        M = Math.round((float)log2 ((max - min)/delta + 1));
        this.bits = new int[n*M];
        Random r = new Random();
        for(int i = 0; i < numberOfBits; i++) {
            bits[i] = r.nextBoolean() ? 1 : 0;
        }

        this.numberOfBits = N * M;
    }

    public BinaryRepresentation(BinaryRepresentation b) {
        this.bits = b.bits.clone();
        min = b.min;
        max = b.max;
        N = b.N;
        M = b.M;
        numberOfBits = N * M;
    }

    public BinaryRepresentation clone(){
        return new BinaryRepresentation(this);
    }

    public double[] decode() {
        int[][] data = new int[N][M];
        int index = 0;
        for(int i =0; i < bits.length; i++) {
            data[index][i%M] = bits[i];
            if((i+1) % M == 0) index++;
        }

        double[] result = new double[N];
        index = 0;
        for(int[] b : data) {
            long number = 0;
            for(int i = 0; i < b.length; i++) {
                int t = (b.length - 1)- i;
                number += b[i] * Math.pow(2, t);
            }

            result[index++] =  (number/(Math.pow(2, M) - 1))*(max - min) + min;
        }
        return result;
    }

    public double log2(double x) {
        return Math.log(x)/Math.log(2);
    }

    public String arrayToString(int[] solution) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < solution.length; i++) {
            sb.append(solution[i]);
            sb.append(" ");
        }
        return sb.toString();

    }

    @Override
    public boolean equals(Object o) {
        BinaryRepresentation b = (BinaryRepresentation) o;
        for(int i = 0; i < bits.length; i++) {
            if(b.bits[i] != bits[i]) return false;
        }
       return true;
    }


}
