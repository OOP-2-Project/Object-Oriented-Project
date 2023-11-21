package comp3607project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Unzips files from a folder given the folder's directory 
 * and stores an unzipped version to another folder given its directory
 */
public class Unzip {

    public static void unzipFile(String zipPath, String destinationPath) {
        List<String> unzippedFileNames = new ArrayList<>();
        File destDir = new File(destinationPath);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        byte[] buffer = new byte[1024];

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipPath))) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                String entryName = zipEntry.getName();
                File entryFile = new File(destinationPath, entryName);

                System.out.println("Unzipping to " + entryFile.getAbsolutePath());

                String fileName = entryName.substring(entryName.lastIndexOf("/") + 1);

                unzippedFileNames.add(fileName);

                if (zipEntry.isDirectory()) {
                    entryFile.mkdirs();
                } else {
                    File parent = entryFile.getParentFile();
                    if (!parent.exists()) {
                        parent.mkdirs();
                    }

                    try (FileOutputStream fos = new FileOutputStream(entryFile)) {
                        int len;
                        while ((len = zipInputStream.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }

                zipInputStream.closeEntry();
                if (entryName.toLowerCase().endsWith(".zip")) {
                    unzipFile(entryFile.getAbsolutePath(), entryFile.getParent());
                }

                zipEntry = zipInputStream.getNextEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

        
    


    

