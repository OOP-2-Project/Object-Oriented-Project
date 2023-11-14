package comp3607project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipExampleTestUtil {

    public static void createZip(File zipFile, File... filesToZip) throws IOException {
        try (FileOutputStream fin = new FileOutputStream(zipFile);
             ZipOutputStream zipOut = new ZipOutputStream(fin)) {

            for (File fileToZip : filesToZip) {
                addFileToZip(fileToZip, zipOut, "");
            }
        }
    }

    public static void addFileToZip(File file, ZipOutputStream zipOut, String parentDir) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        String entryName = parentDir + file.getName();
        ZipEntry zipEntry = new ZipEntry(entryName);
        
        try {
            zipOut.putNextEntry(zipEntry);

            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }

            zipOut.closeEntry();
        } finally {
            fis.close();
        }
    }

}
        
    
