package recursive;

import java.io.File;

/**
 * Using recursion to print all files in a directory
 */
public class ScanFiles {
    public static void printFiles(String dir) {
        // Get all files and directories from dir
        File[] files = new File(dir).listFiles();
        if (null != files && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    printFiles(file.getPath());
                } else {
                    System.out.print(file.getAbsolutePath() + "\n");
                }
            }
        }

    }

    public static void main(String[] args) {
        // String path = args[0];
        ScanFiles.printFiles("/Users/ericawu/test");
    }
}
