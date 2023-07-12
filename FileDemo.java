import java.io.*;

class OnlyExtension implements FilenameFilter {
    String extension;

    public OnlyExtension(String ext) {
        extension = ext;
    }

    public boolean accept(File dir, String name) {
        return name.endsWith(extension);
    }
}

public class FileDemo {
    public static void main(String[] args) {
        File f1 = new File("./testfile1.txt");
        File d1 = new File("./testdir");

        System.out.println("File name: " + f1.getName());
        System.out.println("File path: " + f1.getPath());
        System.out.println("Absolute path: " + f1.getAbsolutePath());

        String n = f1.getName();

        if (n.equals("testfile.txt")) {
            f1.renameTo(new File("testfile1.txt"));
        }

        System.out.println("d1 is a directory: " + d1.isDirectory());
        System.out.println("f1 is a directory: " + f1.isDirectory());

        String[] fileNameList = d1.list();
        String[] fileNameListFiltered = d1.list(new OnlyExtension("txt"));

        File[] fileList = d1.listFiles();
        File[] fileListFiltered = d1.listFiles(new OnlyExtension("txt"));

        for (var d : fileNameList) {
            System.out.println(d);
        }

        System.out.println("========");

          for (var d : fileNameListFiltered) {
            System.out.println(d);
        }

        File newDir = new File("./new_dir");

        if (!newDir.exists()) {
            newDir.mkdir(newDir);
        }
    }
}
