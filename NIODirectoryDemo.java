import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class NIODirectoryDemo {
    public static void main(String[] args) {
        String dirname = "testdir";
        // Create a filter that returns true only for writable files
        DirectoryStream.Filter<Path> how = new DirectoryStream.Filter<>() {
            public boolean accept(Path filename) throws IOException {
                if (Files.isWritable(filename)) return true;
                return false;
            }
        }; 

        // Obtain and manage a directory stream of writable files
        try (DirectoryStream<Path> dirStream = Files.newDirectoryStream(Path.of(dirname), how)) {
            for (Path entry : dirStream) {
                BasicFileAttributes attibs = Files.readAttributes(entry, BasicFileAttributes.class);

                if (attibs.isDirectory()) {
                    System.out.println("<DIR> ");
                } else {
                    System.out.println("      ");
                }

                System.out.println(entry.getName(1));
            }

        } catch (InvalidPathException e) {
            System.out.println("Path exception: " + e);
        } catch (NotDirectoryException e) {
            System.out.println("No dir: " + e);
        } catch (IOException e) {
            System.out.println("I/O exception: " + e);

        }
    }
}
