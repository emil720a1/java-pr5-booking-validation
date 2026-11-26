# Booking Validation – Java Practical Work 05

This project demonstrates Java exception handling, a custom checked exception, and text file input/output with character encodings.

## Topics covered

- Checked exceptions and the `throws` declaration (`FileNotFoundException`)
- Unchecked exceptions such as `ArithmeticException`
- Catch block ordering and the `finally` block
- Wrapping `NumberFormatException` in a custom checked `InvalidBookingException`, while preserving the original cause
- Writing and reading UTF-8 text with `BufferedWriter` and `BufferedReader`
- Comparing a writer that is not closed with try-with-resources
- The effect of reading a file with a charset that differs from the one used to write it

## Project structure

```text
src/main/java/
├── Main.java
└── InvalidBookingException.java
data.txt
pom.xml
```

`Main.main()` currently divides `10` by `2`, writes a sample booking to `data.txt` using try-with-resources, reads it back as UTF-8, and prints the result. The other examples are present as methods or commented calls so they can be enabled individually.

## Run

Open the project in IntelliJ IDEA and run `Main`.

Alternatively, with a JDK and Maven installed, compile the project from its root directory:

```bash
mvn compile
```

The Maven configuration currently sets Java source and target compatibility to version 27.

## Try the examples

In `Main.java`, uncomment one experiment at a time:

- Call `openFile()` to explore handling a checked file exception.
- Change `10 / 2` to `10 / 0` to see an unchecked arithmetic exception and the `finally` block.
- Call `parseToInt("abc")` and enable the `InvalidBookingException` catch to inspect the wrapped exception and its cause.
- Call `writeTextWithoutClosing()` instead of `writeText()` to compare file output when the writer is not closed. Buffered output may not be fully flushed until the writer is closed.
- Change the charset used by `readText()` to `windows-1251` while the file is written as UTF-8 to observe garbled text; restore UTF-8 for correct output.

The sample booking written to `data.txt` is:

```text
Бронювання готелю
Кількість місць: 2
```
