package com.slavamashkov.apache.math;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

import java.util.Arrays;

/**
 *
 */
public class App {
    public static void main(String[] args) {
        // Create a real matrix with two rows and three columns, using a factory
        // method that selects the implementation class for us.
        double[][] matrixData = {
                {1d, 2d, 3d},
                {2d, 5d, 3d}};

        RealMatrix m = MatrixUtils.createRealMatrix(matrixData);

        // One more with three rows, two columns, this time instantiating the
        // RealMatrix implementation class directly.
        double[][] matrixData2 = {
                {1d, 2d},
                {2d, 5d},
                {1d, 7d},
                {3d, 4d}};
        
        RealMatrix n = new Array2DRowRealMatrix(matrixData2);

        // Note: The constructor copies the input double[][] array in both cases.

        // Now multiply m by n
        if (isMultiplied(m, n)) {
            RealMatrix p = m.multiply(n);
            showMatrix(p);
        } else {
            String cause = m.getColumnDimension() + " != " + n.getRowDimension();
            System.out.println("Can't multiply! Cause: " + cause);
        }

    }

    public static void showMatrix(RealMatrix realMatrix) {
        for (int i = 0; i < realMatrix.getRowDimension(); i++) {
            System.out.println(Arrays.toString(realMatrix.getRow(i)));
        }
    }

    public static boolean isMultiplied(RealMatrix firstMatrix, RealMatrix secondMatrix) {
                return firstMatrix.getColumnDimension() == secondMatrix.getRowDimension();
    }
}
