package ru.vladmatyunin;

public class Main {

    public static void main(String[] args) {
        int chessSize = Integer.parseInt(args[0]);
        int rookNumber = Integer.parseInt(args[1]);

        int result = RookExecutor.Execute(chessSize, rookNumber);
        System.out.println("RESULT IS: " + result);
    }
}
