package ru.vladmatyunin;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) {
        int chessSize = Integer.parseInt(args[0]);
        int rookNumber = Integer.parseInt(args[1]);

        try {
            int result = new ParallelExecutor(Runtime.getRuntime().availableProcessors()).execute(chessSize, rookNumber);
            System.out.println("RESULT IS: " + result);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
