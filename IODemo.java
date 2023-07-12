import java.io.*;
import java.util.*;

public class IODemo {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File outputFile = new File("./outputFile.txt");

        if (!outputFile.exists()) {
            outputFile.createNewFile();
        }

        // **************************
        // Byte Streams
        // **************************

        // FileInputStream & FileOutputStream
        // ByteArrayInputStream & ByteArrayOutputStream
        // FilterInputStream & FilterOutputStream --> wrappers around underlying input and output streams providing extended level of functionality; no new methods
        // BufferedInputStream & BufferedOutputStream --> allow to read and write bigger chunks of data (not only single bytes); good for optimization
        // PushbackInputStream --> allows to return read data back to the stream
        // SequenceInputStream --> allows to concatenate multiple streams; fulfills each request from first stream, then moves on to the second one
        // PrintStream --> provides output capabilities from the System file handle, System.out
        // DataInputStream & DataOutputStream --> enables to write or read primitive data to or from a stream

        // **************************
        // Character Streams
        // **************************
        
        // FileReader & FileWriter
        // CharArrayReader & CharArrayWriter
        // BufferedReader && BufferedWriter
        // PushbackReader
        // PrintWriter --> character-oriented version of PrintStream

        // **************************
        // Other
        // **************************

        // ObjectInputStream & ObjectOutputStream --> for object serialization (see SerializationDemo.java)
        // RandomAccessFile
        // Console


        //  FileInputStream & FileOutputStream

        try (FileInputStream fileInputStream = new FileInputStream("./testfile.txt"); FileOutputStream fileOutputStream = new FileOutputStream("outputfile.txt", true)) {
            int size = fileInputStream.available();
            System.out.println("Total available bytes in fileInputStream: " + size);

            for (int i = 0; i < size; i++) {
                int b = fileInputStream.read();
                char c = (char) b;
                System.out.print(c);
                fileOutputStream.write(b);
            }
        }

        // ByteArrayInputStream & ByteArrayOutputStream

        String exampleStr = "This is a quite long example string";
        byte[] byteArr = exampleStr.getBytes();
        
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArr);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int c;

        while ((c = byteArrayInputStream.read()) != -1) {
            System.out.print((char) c);
            byteArrayOutputStream.write(c);

        }

        System.out.println();
        System.out.println(byteArrayOutputStream);

        // FilterInputStream & FilterOutputStream --> wrappers around underlying input and output streams providing extended level of functionality; no new methods
        
        // BufferedInputStream & BufferedOutputStream --> allow to read and write bigger chunks of data (not only single bytes); good for optimization
        exampleStr = "This is a &copy; copyright symbol but this is &copy not.\n";
        byteArr = exampleStr.getBytes();
        Boolean marked = false;

        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(byteArr)); BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new ByteArrayOutputStream())) {
            while ((c = bufferedInputStream.read()) != -1) {
                switch(c) {
                    case '&': 
                        if(!marked) {
                            bufferedInputStream.mark(32);
                            marked = true;
                        } else {
                            marked = false;
                        }
                        break;
                    case ';': 
                        if (marked) {
                            marked = false;
                            System.out.print("(c)");
                        } else {
                            System.out.print((char) c);
                        }
                        break;
                    case ' ':
                        if (marked) {
                            marked = false;
                            bufferedInputStream.reset();
                            System.out.print("&");
                        } else {
                            System.out.print((char) c);
                        }
                        break;
                    default:
                        if (!marked) {
                            System.out.print((char) c);
                        }
                        break;
                }
            }
        }

        // PushbackInputStream --> allows to peek into a stream without disrupting it
        exampleStr = "if (a == 4) a = 0;\n";
        byteArr = exampleStr.getBytes();
        byteArrayInputStream = new ByteArrayInputStream(byteArr);

        try (PushbackInputStream pushbackInputStream = new PushbackInputStream(byteArrayInputStream)) {
            while ((c = pushbackInputStream.read()) != -1) {
                switch(c) {
                    case '=':
                        if ((c = pushbackInputStream.read()) == '=') {
                            System.out.print(".eq.");
                        } else {
                            System.out.print("<-");
                            pushbackInputStream.unread(c); // unread allows to "return" the byte (or array of bytes) back to the PushbackInputStream
                        }
                    break;
                    default:
                        System.out.print((char) c);
                        break;
                }
            }
        }

        // SequenceInputStream --> allows to concatenate multiple streams; fulfills each request from first stream, then moves on to the second one
        SequenceInputStream sequenceInputStream = new SequenceInputStream(new ByteArrayInputStream(byteArr), new ByteArrayInputStream(byteArr));

        // PrintStream --> provides output capabilities from the System file handle, System.out
        String printStreamString = "This is a string prepared for PrintStream";
        byteArr = printStreamString.getBytes();
        byteArrayInputStream = new ByteArrayInputStream(byteArr);
        
        PrintStream printStream = new PrintStream(new ByteArrayOutputStream(), true);
        // below examples from System.out (which is also a PrintStream)
        System.out.printf("%d - %d = %d", 10, 4, 6);

        // DataInputStream & DataOutputStream --> enable to write or read primitive data to or from a stream
     
        try (DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data.txt"))) {
            dataOutputStream.writeInt(4);
            dataOutputStream.writeChar('r');
            dataOutputStream.writeBoolean(false);
        }
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream("data.txt"))) {
            int i1 = dataInputStream.readInt();
            char c1 = dataInputStream.readChar();
            boolean bool1 = dataInputStream.readBoolean();

            System.out.println();
            System.out.println("Values from dataInputStream: " + i1 + " " + c1 + " " + bool1);
        }
      

        // **************************
        // Character Streams
        // **************************

        // FileReader
        try (FileReader fileReader = new FileReader("FileReaderDoc.txt")) {
            int fileReaderVar;

            while ((fileReaderVar = fileReader.read()) != -1) {
                System.out.print((char) fileReaderVar);
            }

        } catch (IOException e) {
            System.out.println("IO Error: " + e);
        }

        // FileWriter
        String stringForFileWriter = "Now it's time for all good men to come forward";
        char[] buffForFileWriter = new char[stringForFileWriter.length()];
        stringForFileWriter.getChars(0, stringForFileWriter.length(), buffForFileWriter, 0);

        try (FileWriter fileWriter = new FileWriter("FileWriterDoc.txt")) {
            for (int i = 0; i < buffForFileWriter.length; i++) {
                fileWriter.write(buffForFileWriter[i]);
            }
        } catch (IOException e) {
              System.out.println("IO Error: " + e);
        }

           System.out.println();

        // CharArrayReader
        String charArrayReaderStr = "abcdef";
        char[] buffForArrayReader = new char[charArrayReaderStr.length()];
        charArrayReaderStr.getChars(0, charArrayReaderStr.length(), buffForArrayReader, 0);
        int charArrReaderVar;

        System.out.println(buffForArrayReader);

        try (CharArrayReader charArrayReader = new CharArrayReader(buffForArrayReader)) {
            // while ((charArrReaderVar = charArrayReader.read()) != 1)  {
            //     System.out.print((char) charArrReaderVar);
            // }
            // System.out.println();
        } 
        // catch (IOException e) {
        //     System.out.println("IO Error: " + e);
        // }

        // CharArrayWriter
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        String strForCharArrWriter = "I have been written";
        char[] buffForCharArrWriter = new char[stringForFileWriter.length()];
        
        strForCharArrWriter.getChars(0, strForCharArrWriter.length(), buffForCharArrWriter, 0);

        try {
            charArrayWriter.write(buffForCharArrWriter);
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println();
        System.out.println(charArrayWriter.toString());

        // BufferedReader & BufferedWriter --> same as in BufferedInputStream & BufferedOutputStream
        // PushbackReader --> same as PushbackInputStream
        // PrintWriter --> character-oriented version of PrintStream

        // **************************
        // Other
        // **************************

        // Console  
        String consoleStr;
        Console console;

        console = System.console();

        if (console == null) return;

        consoleStr = console.readLine("Enter your string: ");
        console.printf("Here is your string: %s\n", consoleStr);
    }
}
