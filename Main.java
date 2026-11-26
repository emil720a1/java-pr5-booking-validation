import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        try
        {
//            openFile();

            int result = 10 / 2;
            System.out.println(result);

//            parseToInt("abc");

            writeText();
            readText();
//            writeTextWithoutClosing();

//            writeText();
        }
        catch (FileNotFoundException e) {
            System.out.println("FileNotFound");
        }
        catch (ArithmeticException ea) {
            System.out.println("It's ArithmeticException");
        }
//        catch (InvalidBookingException e) {
//            e.printStackTrace();
//        }
        catch (Exception e) {
            System.out.println("Exception");
        }
        finally {
            System.out.println("It's finally block");
        }
    }

    static void openFile() throws FileNotFoundException {
        FileReader reader = new FileReader("data.txt");
    }

    static void parseToInt(String message) throws InvalidBookingException {
        try {
            Integer.parseInt(message);
        }
        catch (NumberFormatException e) {
            throw new InvalidBookingException("Некоректні дані бронювання: " + message, e);
        }
    }

    static void writeTextWithoutClosing() throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Path.of("data.txt"),
                StandardCharsets.UTF_8);

        writer.write("Бронювання готелю");
        writer.newLine();
        writer.write("Кількість місць: 2");
        writer.newLine();
    }

    static void writeText() throws IOException {
        try (BufferedWriter writer =

        Files.newBufferedWriter(Path.of("data.txt"), StandardCharsets.UTF_8)) {
            writer.write("Бронювання готелю");
            writer.newLine();
            writer.write("Кількість місць: 2");
            writer.newLine();
        }
    }

    static void readText() throws IOException {
        try (var reader = Files.newBufferedReader(
                Path.of("data.txt"),
                StandardCharsets.UTF_8))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                System.out.println(line);
            }
        }
    }
}