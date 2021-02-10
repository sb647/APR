package matrix;

public class Operations {

    public static Matrix add (Matrix m1, Matrix m2) {
        if (m1.getNumberOfRows() != m2.getNumberOfRows() || m1.getNumberOfColumns() != m2.getNumberOfColumns()) {
            throw new IllegalArgumentException("Incompatible matrices!");
        }

        double elements[][] = new double[m1.getNumberOfRows()][m1.getNumberOfColumns()];

        for(int i = 0; i < m1.getNumberOfRows(); i++) {
            for (int j = 0; j < m1.getNumberOfColumns(); j++) {
                elements[i][j] = m1.getElement(i,j) + m2.getElement(i,j);
            }
        }

        return new Matrix(elements);
    }

    public static Matrix sub (Matrix m1, Matrix m2) {
        if (m1.getNumberOfRows() != m2.getNumberOfRows() || m1.getNumberOfColumns() != m2.getNumberOfColumns()) {
            throw new IllegalArgumentException("Incompatible matrices!");
        }

        double elements[][] = new double[m1.getNumberOfRows()][m1.getNumberOfColumns()];

        for(int i = 0; i < m1.getNumberOfRows(); i++) {
            for (int j = 0; j < m1.getNumberOfColumns(); j++) {
                elements[i][j] = m1.getElement(i,j) - m2.getElement(i,j);
            }
        }

        return new Matrix(elements);
    }

    public static Matrix multiply (Matrix m1, Matrix m2) {
        if(m1.getNumberOfColumns() != m2.getNumberOfRows()) throw new IllegalArgumentException("Incompatible matrices!");
        double[][] elems = new double [m1.getNumberOfRows()][m2.getNumberOfColumns()];
        for(int i = 0; i < m1.getNumberOfRows(); i++) {
            for (int j = 0; j < m2.getNumberOfColumns(); j++) {
                for(int k = 0; k < m1.getNumberOfColumns(); k++) {
                    elems[i][j] += m1.getElement(i,k) * m2.getElement(k,j);
                }
            }
        }
        return new Matrix(elems);
    }

}
