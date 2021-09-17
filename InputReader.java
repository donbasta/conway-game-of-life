import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputReader {
    public static List<Coordinate> readContent(String filePath) {
        try {
            File fileObj = new File(filePath);
            Scanner scanner = new Scanner(fileObj);
            List<Coordinate> inputs = new ArrayList<>();
            while (scanner.hasNextLine()) {
                Integer a = scanner.nextInt();
                Integer b = scanner.nextInt();
                Coordinate ab = new Coordinate(a, b);
                inputs.add(ab);
            }
            scanner.close();
            return inputs;
        }  catch (FileNotFoundException e) {
            return null;
        }
    }

    public static List<Coordinate> getInput(String filePath) throws Exception {
        List<Coordinate> input = InputReader.readContent(filePath);
        if (input == null) {
            throw new Exception("input error");
        }
        return input;
    }
}
