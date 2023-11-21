package comp3607project;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class UnzipTest {

    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    @Test
    public void testUnzipFile() throws IOException {
        
        File zipFile = testFolder.newFile("test.zip");

        File file1 = testFolder.newFile("file1.txt");
        File file2 = testFolder.newFile("file2.txt");

        ZipExampleTestUtil.createZip(zipFile, file1, file2);

        //Unzip unZip = new Unzip();

        File destDirectory = testFolder.newFolder("extracted");
        
        Unzip.unzipFile(zipFile.getAbsolutePath(), destDirectory.getAbsolutePath());



        assertTrue(new File(destDirectory, "file1.txt").exists());
        assertTrue(new File(destDirectory, "file2.txt").exists());


    }
}
