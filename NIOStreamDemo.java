import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NIOStreamDemo {
    public static void main(String[] args) {
        int i;

        try (InputStream fin = Files.newInputStream(Path.of("NIOsource.txt")); OutputStream fout = Files.newOutputStream(Path.of("NIOtarget.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            do {
                i = fin.read();
                if (i != -1) {
                    System.out.print((char) i);
                    fout.write(i);
                }
            } while (i != -1);

        } catch (InvalidPathException e) {

        } catch (IOException e) {

        }
    }
}
