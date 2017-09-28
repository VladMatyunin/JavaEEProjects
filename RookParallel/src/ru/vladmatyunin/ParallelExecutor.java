package ru.vladmatyunin;

import java.util.concurrent.*;

import static ru.vladmatyunin.MyArrayUtils.setDisabled;

/**
 * Using RookExecutor
 * Algorithm description:
 * 1. create future to execute rook task
 *    number of tasks is the desk size
 *    each task is assumed that we've placed a rook and find out
 *    all places of left according to this
 * 2. Wait for their execution
 * 3. Sum result
 */
public class ParallelExecutor {

    private int threadNumber;

    public ParallelExecutor(int threadNum){
        this.threadNumber = threadNum;
    }

    public int execute(int size, int number) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadNumber);
        // needed to await futures
        CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
        // create tasks
        for (int i = 0; i <= size-number; i++){
            for (int j = 0; j < size; j++) {
                // init task
                Callable<Integer> task = new RookExecutor(i+1, size, number-1,setDisabled(i,j,new int[size][size]));
                completionService.submit(task);
            }
        }
        Integer sum = 0;
        // sum tasks
        for (int h = 0; h < size*(size-number+1); h++){
            Future<Integer> task = completionService.take();
            sum+=task.get();
        }
        executorService.shutdown();
        executorService.awaitTermination(5,TimeUnit.MINUTES);
        return sum;
    }
}
