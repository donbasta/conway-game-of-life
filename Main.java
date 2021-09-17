import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        LifeCells lifeCells = new LifeCells(
            new ArrayList<>(
                Arrays.asList(
                    new Coordinate(0, 0),
                    new Coordinate(1, 0),
                    new Coordinate(2, 0),
                    new Coordinate(2, 1),
                    new Coordinate(1, 2)
                )
            )
        );

       Board board = new Board(lifeCells);
       int life = 100;
       while (life --> 0) {
            board.nextTick();
            board.show();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
       }
   } 
}
