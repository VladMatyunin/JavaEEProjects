package ru.vladmatyunin;

import static ru.vladmatyunin.MyArrayUtils.createNewInstance;
import static ru.vladmatyunin.MyArrayUtils.printMatrix;
import static ru.vladmatyunin.MyArrayUtils.setDisabled;

/**
 * Class to find the result using recursive execution
 */
public class RookExecutor {
    private static int resultCounter = 0;
    private static int iteration;

    /**
     * The enter method of class
     * @param size - desk size
     * @param number - number of rooks to place on desk
     * @return the number of ways to put rooks so the can not hit
     * each other
     */
    public static int Execute (int size, int number){
        // start, for loop is used to complete task if the number
        // of rooks smaller than the desk size
        for (int i = 0; i <= size-number; i++)
        put(i, number, new int[size][size]);

        return resultCounter;
    }

    /**
     * Main recursive method, which returns, when there is no rooks left
     * @param startXPosition - the row, from which to start
     * @param k - number of rooks left
     * @param available - desk instance
     */
    private static void put(int startXPosition, int k, int[][] available){
        // return current execution
        System.out.println("__________________________");
        System.out.println("ITERATION:" + iteration);
        printMatrix(available);

        iteration++;
        //if there is no rooks, then we have completed task
        if (k==0) {
            resultCounter++;
            return;
        }
        else
            for (int j = 0; j < available.length; j++){
                // we have a place for a new rook
                if (available[startXPosition][j]==0){
                    // create new desk instance
                    // needed to save the previous one for next executions
                    int[][] newArray = createNewInstance(available);
                    System.out.println("PUT INTO: "+startXPosition+"  "+j);

                    // move forward without one rook, start with the next row
                    put(startXPosition+1, k-1, setDisabled(startXPosition,j,newArray));
                }
            }

    }
}
