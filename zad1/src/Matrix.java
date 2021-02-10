import java.util.Arrays;
import java.util.Objects;

public class Matrix {

    private int numberOfRows;
    private int numberOfColumns;
    private double[][] elements;
    private Matrix decomposed;
    public int supstitutions = 0;

    private static final double EPSILON = 1E-9;

    public Matrix(double[][] elements) {
        if(elements == null) throw new IllegalArgumentException("Null object is not allowed!");
        this.elements = elements;
        this.numberOfRows = elements.length;
        this.numberOfColumns = elements[0].length;
    }

    public Matrix(int rows, int columns) {
        if(rows <= 0 || columns <= 0) throw new IllegalArgumentException("Invalid arguments!");

        this.numberOfColumns = columns;
        this.numberOfRows = rows;
        this.elements = new double [rows][columns];

    }

    public Matrix (int n) {
        this(n,n);
    }

    public Matrix (Matrix m) {
        this(m.copyElements());
    }

    public double[][] copyElements () {
        double[][] elems = new double[this.getNumberOfRows()][this.getNumberOfColumns()];
        for (int i = 0; i < this.getNumberOfRows(); i++) {
            for ( int j = 0; j < this.getNumberOfColumns(); j++) {
                elems[i][j] = this.getElement(i,j);
            }
        }
        return elems;
    }

    public Matrix (double[] column) {
        this(column.length,1);
        for (int i = 0; i < column.length; i++) {
            this.setElement(column[i], i, 0);
        }
    }

    public void resize (int rows, int cols) {
        if(rows <= 0 || cols <= 0) throw new IllegalArgumentException("Invalid arguments!");
        this.numberOfRows = rows;
        this.numberOfColumns = cols;
        double [][] oldElements = this.getElements();
        this.elements = new double [rows][cols];

        for (int i = 0; i < rows; i ++) {
            for (int j = 0; j < cols; j++) {
                double elem;
                try {
                    elem = oldElements[i][j];
                } catch (IndexOutOfBoundsException ex) {
                    elem = 0.0;
                }
                this.elements[i][j] = elem;
            }
        }
    }

    public double getElement (int row, int col) {
        double elem;
        try{
            elem = this.elements[row][col];
            return elem;
        } catch (IndexOutOfBoundsException ex) {
            throw new IllegalArgumentException("Nonexistent element!");
        }
    }

    public void setElement(double value, int row, int col) {
        if (row < 0 || col < 0 || row >= numberOfRows || col >= numberOfColumns) {
            throw new IllegalArgumentException("Index out of bound!");
        }
        this.elements[row][col] = value;
    }

    public void swapRows (int i, int j) {
        if(i < 0 || j < 0 || i >= numberOfRows || j >= numberOfRows) {
            throw new IllegalArgumentException();
        }
        double[] array = this.elements[i];
        this.elements[i] = this.elements[j];
        this.elements[j] = array;
    }

    public Matrix transponse() {
        double[][] elems = new double [this.numberOfColumns][this.numberOfRows];
        for (int i = 0; i < numberOfRows; i++) {
            for ( int j = 0; j < numberOfColumns; j++) {
                elems[j][i] = elements[i][j];
            }
        }
        return new Matrix(elems);
    }

    public void add (Matrix m) {
        if (this.getNumberOfRows() != m.getNumberOfRows() || this.getNumberOfColumns() != m.getNumberOfColumns()) {
            throw new IllegalArgumentException("Incompatible matrices!");
        }
        for(int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                elements[i][j] += m.getElement(i,j);
            }
        }
    }

    public void sub (Matrix m) {
        if (this.getNumberOfRows() != m.getNumberOfRows() || this.getNumberOfColumns() != m.getNumberOfColumns()) {
            throw new IllegalArgumentException("Incompatible matrices!");
        }
        for(int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                elements[i][j] -= m.getElement(i,j);
            }
        }
    }


    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    public double[][] getElements() {
        return elements;
    }

    public double getCardinality() {
        return numberOfColumns * numberOfRows;
    }

    public void setRow(int n, double [] row) {
        if(n < 0 || n >= numberOfRows || row == null)  {
            throw new IllegalArgumentException();
        }
        this.elements[n] = row;
    }

    public void setColumn(int n, Matrix column) {

        for(int i = 0; i < column.getNumberOfRows(); i++) {
            this.elements[i][n] = column.getElement(i,0);
        }
    }

    public double[] getColumn(int n) {
        if(n < 0 || n >= numberOfRows)  {
            throw new IllegalArgumentException();
        }
        double[] column = new double[this.numberOfRows];

        for(int i = 0; i < numberOfRows; i++) {
            column[i] = this.getElement(i,n);
        }
        return column;
    }



    @Override
    public String toString() {
        if (elements == null || getCardinality() == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < this.getNumberOfRows(); i++) {
                for (int j = 0; j < this.getNumberOfColumns(); j++) {
                    sb.append(elements[i][j]);
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length()-1);
                sb.append(System.lineSeparator());
            }
            return sb.toString();
        }
    }

    public void scalarMultiply (double scalar) {
        for(int i = 0; i < this.getNumberOfRows(); i++) {
            for (int j = 0; j < this.getNumberOfColumns(); j++) {
                this.elements[i][j] *= scalar;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Matrix)) return false;
        Matrix matrix = (Matrix) o;
        if( numberOfRows != matrix.numberOfRows || numberOfColumns != matrix.numberOfColumns) {
            return false;
        }

        for(int i = 0; i < this.getNumberOfRows(); i++) {
            for (int j = 0; j < this.getNumberOfColumns(); j++) {
                if ( Math.abs(this.elements[i][j] - matrix.getElement(i,j)) > EPSILON) return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(numberOfRows, numberOfColumns);
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }


    public Matrix forwardSubstitution ( Matrix b) {

        if(b.getNumberOfColumns() != 1 || b.getNumberOfRows() != this.numberOfRows) {
            throw new IllegalArgumentException("Invalid vector!");
        }

        double[] y = new double [this.numberOfRows];

        for( int i = 0; i < numberOfRows; i++) {
            y[i] = b.getElement(i,0);
        }

        for(int i = 0; i < numberOfRows-1; i++ ) {
            for (int j = i+1; j < numberOfRows; j++) {
                y[j] -= this.getElement(j,i) * y[i];
            }
        }
        return new Matrix(y);
    }

    public Matrix backwardSubstitution (Matrix y) {

        if(y.getNumberOfColumns() != 1 || y.getNumberOfRows() != this.numberOfRows) {
            throw new IllegalArgumentException("Invalid vector!");
        }

        double[] x = new double [this.numberOfRows];
        for( int i = 0; i < y.numberOfRows; i++) {
            x[i] = y.getElement(i,0);
        }

        for(int i = numberOfRows - 1; i >= 0; i--) {
            x[i] /= this.getElement(i,i);

            for (int j = 0; j <= i -1; j++) {
                x[j] -= this.getElement(j,i) * x[i];
            }
        }
        return new Matrix(x);
    }

    public Matrix LUDecomposition () {

        if(this.numberOfRows != this.numberOfColumns) {
            throw new IllegalArgumentException("Matrix is non-square!");
        }

        Matrix A = new Matrix(this);

        for(int i = 0; i < numberOfRows -1 ; i++) {
            for (int j = i+1; j < numberOfRows; j++) {

                double value = A.getElement(j,i) / A.getElement(i,i);
                A.setElement(value, j, i);

                for(int k = i+1; k < numberOfColumns; k++) {
                    value = A.getElement(j,k) - A.getElement(j,i) * A.getElement(i,k);
                    A.setElement(value, j, k);
                }
            }
        }

        this.decomposed = A;
        return A;
    }


    public Matrix LUPDecomposition() {

        if(this.numberOfRows != this.numberOfColumns) {
            throw new IllegalArgumentException("Matrix is non-square!");
        }

        Matrix A = new Matrix(this); // L i U

        Matrix P = createEyeMatrix(numberOfRows); //P

        int pivot;


        //najveci element u stupcu
        for (int i = 0; i < numberOfColumns- 1; i++) {
            pivot = i;

            for (int j = i + 1; j < numberOfRows; j++) {
                if(Math.abs(A.getElement(j,i)) > Math.abs(A.getElement(pivot,i))) {
                    pivot = j;
                }
            }

            //zamjena redova
            A.swapRows(i, pivot);
            P.swapRows(i, pivot);
            this.supstitutions++;

            for(int j = i+1; j < numberOfRows; j++) {

                if(checkIfPivotIzZerro(A.getElement(i,i))) {
                   System.out.println("Pivot element iz zero!");
                    return null;
                }

                double value = A.getElement(j,i) / A.getElement(i,i);
                A.setElement(value, j,i);

                for(int k = i + 1; k < numberOfColumns; k++) {
                    value = A.getElement(j,k) - A.getElement(j,i) * A.getElement(i, k);
                    A.setElement(value, j ,k);
                }
            }
        }
        if(checkIfPivotIzZerro(A.getElement(numberOfRows-1,numberOfColumns-1))) {
           System.out.println("Pivot element iz zero!");
           return null;
        }
         this.decomposed = A;
         return P;

    }



    public Matrix inverse() {
        Matrix P = this.LUPDecomposition();

        if (P == null) {
            System.out.println("Inverse matrix doesn't exist");
            return null;
        }
        Matrix matrix = this.getDecomposed();
        Matrix inverse = new Matrix(this.numberOfRows, this.numberOfColumns);

        for(int i = 0; i < this.numberOfColumns; i++) {
            Matrix y = matrix.forwardSubstitution(new Matrix(P.getColumn(i)));
            Matrix x = matrix.backwardSubstitution(y);
            inverse.setColumn(i, x);
        }
        return inverse;
    }

    public double getDeterminant() {
        Matrix matrix = new Matrix(this);
        matrix.LUPDecomposition();
        Matrix decomposed = matrix.getDecomposed();
        double det = Math.pow(-1, this.supstitutions);
        for(int i = 0; i < decomposed.getNumberOfRows(); i++) {
            det *= decomposed.getElement(i,i);
        }
        return det;
    }

    public boolean checkIfPivotIzZerro(double pivot) {
        return (Math.abs(pivot) < EPSILON);
    }

    public Matrix getDecomposed() {
        return decomposed;
    }

    public Matrix createEyeMatrix(int n) {
        double[][] pElems = new double[n][n];
        for(int i = 0; i < n; i++) {
            pElems[i][i] = 1;
        }
        return new Matrix(pElems);
    }

    public Matrix getLMatrix() {
            Matrix decomposed = this.getDecomposed();
            if( decomposed == null) {
                System.err.println("LU decomposition is not possible");
                return null;
            }

            Matrix L = new Matrix(this.numberOfRows, this.numberOfColumns);
            for(int i = 0; i < numberOfRows; i++) {
                for (int j = 0; j < numberOfColumns; j++) {
                    if ( i <= j) continue;
                    L.setElement(decomposed.getElement(i,j),i,j);
                }
            }
        return L;
    }

    public Matrix getUMatrix() {
        Matrix decomposed = this.getDecomposed();
        if( decomposed == null) {
            System.err.println("LU decomposition is not possible");
            return null;
        }

        Matrix U = new Matrix(this.numberOfRows, this.numberOfColumns);
        for(int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                if ( i > j) continue;
                U.setElement(decomposed.getElement(i,j),i,j);
            }
        }
        return U;
    }

}