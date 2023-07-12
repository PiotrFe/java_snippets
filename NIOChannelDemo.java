import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class NIOChannelDemo {
    public static void main(String[] args) {
        
        // ***************
        // For Channel-Based IO
        // ***************

        // --- READING ---

        int count;
        Path filepath = null;

        // First, try to obtain a path to the file
        try {
            filepath = Path.of("NIOOutputFile.txt");

        } catch (InvalidPathException e) {
            System.out.println("Path error " + e);
        }

        // Next, obtain a channel to that file
        try (SeekableByteChannel seekableByteChannel = Files.newByteChannel(filepath)) {
            // Allocate a buffer.
            ByteBuffer myBuff = ByteBuffer.allocate(128);

            do {
                // Read into the buffer.
                count = seekableByteChannel.read(myBuff);

                // Stop when the end of file is reached.
                if (count != 1) {
                    // Rewind the buffer so that it can be read.
                    myBuff.rewind();

                    // Read byted from the buffer and show them on the screen as characters.
                    for (int i = 0; i < count; i++) {
                        System.out.print((char) myBuff.get());
                    }
                }
            } while (count != -1);
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println();

        // Example of mapping a file to a buffer
        // Casting the SeekableByteChannel to FileChannel to enable mapping
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Path.of("NIOOutputFile.txt"))) {
            // Get the size of the file
            long fileSize = fileChannel.size();

            // Map the file into a buffer
            MappedByteBuffer mappedBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);

            // Read and display the bytes from buffer

            for (int i = 0; i < fileSize; i++) {
                System.out.print((char) mappedBuffer.get());
            }
            System.out.println();
        } catch (InvalidPathException e) {
            System.out.println("Path exception: " + e);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }

        // --- WRITING ---
        
        // Obtain a channel to the file
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Path.of("NIOInputFile.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            // Create a buffer.
            ByteBuffer byteBuffer = ByteBuffer.allocate(26);

            // Write some bytes to the buffer
            for (int i = 0; i < 26; i++) {
                byteBuffer.put((byte) ('A' + i));
            }

            // Reset the buffer so that it can be written.
            byteBuffer.rewind();

            // Write the buffer to the output file.
            fileChannel.write(byteBuffer);
        } catch (InvalidPathException e) {
        System.out.println("Path exception: " + e);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }

        // Example of mapping a file to a buffer
        try (FileChannel fileChannel = (FileChannel) Files.newByteChannel(Path.of("NIOInputFile.txt"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE)) {
            // Create a mapped buffer
            MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 26);
            for (int i = 0; i < 26; i++) {
                // No explicit write operation needed. Because buffer is mapped to the file, changes to it are automatically reflected in the underlying file.
                mappedByteBuffer.put((byte) ('A' + i));
            }
        } catch (InvalidPathException e) {
        System.out.println("Path exception: " + e);
        } catch (IOException e) {
            System.out.println("IO exception: " + e);
        }


    }
}
