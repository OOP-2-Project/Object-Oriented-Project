package comp3607project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Unzip {

    public static void main(String[] args) {
        String zipPath = "C:\\Users\\surie\\OneDrive\\Desktop\\Comp3607_ProjectTest\\comp3607\\src\\ziptest.zip";
        String destinationPath = "C:\\Users\\surie\\OneDrive\\Desktop\\Comp3607_ProjectTest\\comp3607\\uncompressedFiles";

        unzipFile(zipPath, destinationPath);
    }

    public static void unzipFile(String zipPath, String destinationPath) {

        File dir = new File(destinationPath);

        if (!dir.exists()) dir.mkdirs();

        byte[] buffer = new byte[1024];

        try (FileInputStream fileInputStream = new FileInputStream(zipPath);
             ZipInputStream zipInputStream = new ZipInputStream(fileInputStream)) {

            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                String fileName = zipEntry.getName();
                File newFile = new File(destinationPath + File.separator + fileName);

                System.out.println("Unzipping to " + newFile.getAbsolutePath());

                new File(newFile.getParent()).mkdirs();
                try (FileOutputStream fileOutputStream = new FileOutputStream(newFile)) {

                    int len;

                    while ((len = zipInputStream.read(buffer)) > 0) {
                        fileOutputStream.write(buffer, 0, len);
                    }
                }

                zipEntry = zipInputStream.getNextEntry();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

        
    


    

