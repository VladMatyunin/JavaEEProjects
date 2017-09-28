package ru.vladmatyunin;

/**
 * Utils to work with matrix
 * Used in RookExecutor
 */
class MyArrayUtils {

    /**
     * Disables row and column on chess desk.
     * This is the way the rook can hit the desk
     * @param i - row
     * @param j - column
     * @param arrayChange - desk state
     * @return - new desk state, where the new rook is placed
     */
    static synchronized int[][] setDisabled(int i, int j, int[][] arrayChange){
        for (int x = 0; x < arrayChange.length; x++){
            arrayChange[i][x] = 1;
        }
        for (int x = 0; x < arrayChange.length; x++){
            arrayChange[x][j] = 1;
        }
        return arrayChange;
    }

    /**
     * Creates a new instance with an other address pointer
     * compatible only with matrix
     * @param arrayToCopy - from which array to copy
     * @return a new array with the same values as inputted
     */
    static synchronized int[][] createNewInstance(int[][] arrayToCopy){
        int[][] copy = new int[arrayToCopy.length][arrayToCopy.length];
        for (int i = 0; i < arrayToCopy.length; i++){
            for (int j = 0; j < arrayToCopy.length; j++){
                copy[i][j] = arrayToCopy[i][j];
            }
        }
        return copy;
    }

    // prints matrix as an array of array
    static synchronized void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+"  ");
            }
            System.out.println();
        }
    }
}
