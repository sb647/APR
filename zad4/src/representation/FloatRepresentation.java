package representation;

import java.util.Arrays;

public class FloatRepresentation implements Representation{

    public double[] vector;

    public FloatRepresentation(double[] vector) {
        this.vector = vector;
    }

    public double[] decode() {
        return vector;
    }


    public FloatRepresentation clone() {
        return new FloatRepresentation(this.vector.clone());
    }

    @Override
    public boolean equals(Object obj) {
        FloatRepresentation array2 = (FloatRepresentation)obj;

        for(int i = 0; i < vector.length; i++) {
            if(Math.abs(vector[i] - array2.vector[i]) <= 0.000001) return false;
        }
        return true;
    }

    public String arrayToString(double[] solution) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < solution.length; i++) {
            sb.append(solution[i]);
            sb.append(" ");
        }
        return sb.toString();

    }

    @Override
    public String toString() {
        return arrayToString(vector);
    }
}
