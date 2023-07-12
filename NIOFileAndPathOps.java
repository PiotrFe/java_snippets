import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class NIOFileAndPathOps {
    public static void main(String[] args) {
        Path localFilePath = Path.of("testfile.txt");

        System.out.println("File name: " + localFilePath.getName(0));
        System.out.println("Path: " + localFilePath);
        System.out.println("Absolute path: " + localFilePath.toAbsolutePath());
        System.out.println("Parent: " + localFilePath.getParent());

        if (Files.exists(localFilePath)) {
            System.out.println("File exists");
        } else {
            System.out.println("File doesn't exist");
        }

        try {
            if (Files.isHidden(localFilePath)) {
                System.out.println("File is hidden");
            } else {
                System.out.println("File is not hidden");
            }
        } catch (IOException e) {

        }

        Files.isWritable(localFilePath);
        System.out.println("File is writeable");

        Files.isReadable(localFilePath);
        System.out.println("File is readable");

        try {
            BasicFileAttributes attribs = Files.readAttributes(localFilePath, BasicFileAttributes.class);

            if (attribs.isDirectory()) {
                System.out.println("The file is a directory");
            } else {
                System.out.println("The file is not a directory");
            }

            if (attribs.isRegularFile()) {
                System.out.println("The file is a normal file");
            } else {
                System.out.println("The file is not a normal file");
            }
            
            if (attribs.isSymbolicLink()) {
                System.out.println("The file is a symbolic link");
            } else {
                System.out.println("The file is not a symbolic link");
            }

            System.out.println("File last modified: " + attribs.lastModifiedTime());
            System.out.println("File size: " + attribs.size() + " bytes");
        } catch (IOException e) {
            System.out.println("I/O exception: " + e);
        }
    }
}
