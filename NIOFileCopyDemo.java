import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class NIOFileCopyDemo {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: Copy from to");
            return;
        }

        try {
            Path source = Path.of(args[0]);
            Path target = Path.of(args[1]);

            Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (InvalidPathException e) {
            System.out.println("Path error: " + e);
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
}
