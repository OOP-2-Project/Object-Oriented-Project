package comp3607project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipExampleTestUtil {

    public static void createZipFile(File zipFile, File... filesToZip) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(zipFile);
             ZipOutputStream zipOut = new ZipOutputStream(fos)) {

            for (File fileToZip : filesToZip) {
                addFileToZip(fileToZip, zipOut, "");
            }
        }
    }

    private static void addFileToZip(File file, ZipOutputStream zipOut, String parentDir) throws IOException {
        if (file.isDirectory()) {
            String dir = parentDir + file.getName() + File.separator;
            zipOut.putNextEntry(new ZipEntry(dir));

            File[] files = file.listFiles();
            if (files != null) {
                for (File fileInside : files) {
                    addFileToZip(fileInside, zipOut, dir);
                }
            }
        } else {
            try (FileInputStream fis = new FileInputStream(file)) {
                String entryName = parentDir + file.getName();
                zipOut.putNextEntry(new ZipEntry(entryName));

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    zipOut.write(buffer, 0, length);
                }
            }
        }
    }
}