package ru.vladmatyunin;

import java.util.concurrent.Callable;

import static ru.vladmatyunin.MyArrayUtils.createNewInstance;
import static ru.vladmatyunin.MyArrayUtils.printMatrix;
import static ru.vladmatyunin.MyArrayUtils.setDisabled;

/**
 * Class to find the result using recursive execution
 */
public class RookExecutor implements Callable<Integer>{
    private int resultCounter = 0;
    private int startXPosition;
    private int size;
    private int number;
    private int[][] desk;
    /**
     * @param size - desk size
     * @param number - number of rooks to place on desk
     * @return the number of ways to put rooks so the can not hit
     * each other
     */
    public RookExecutor(int startXPosition, int size, int number, int[][] desk){
        this.startXPosition = startXPosition;
        this.size = size;
        this.number = number;
        this.desk = desk;
    }
    /**
     * Main recursive method, which returns, when there is no rooks left
     * @param startXPosition - the row, from which to start
     * @param k - number of rooks left
     * @param available - desk instance
     */
    private void put(int startXPosition, int k, int[][] available){
        //System.out.println(Thread.currentThread().getId());
        // return current execution
        //System.out.println("__________________________");
        //System.out.println("ITERATION:" + iteration);
        printMatrix(available);

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
                    //System.out.println("PUT INTO: "+startXPosition+"  "+j);

                    // move forward without one rook, start with the next row
                    put(startXPosition+1, k-1, setDisabled(startXPosition,j,newArray));
                }
            }

    }

    @Override
    public Integer call() throws Exception {
        put(startXPosition, number, desk);
        return resultCounter;
    }
}
