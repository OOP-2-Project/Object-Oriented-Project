package comp3607project;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class UnzipTest {

    @Rule
    public TemporaryFolder temporaryFolder = new TemporaryFolder();

    @Test
    public void testUnzipFile() throws IOException {
        // Create a temporary zip file for testing
        File zipFile = temporaryFolder.newFile("test.zip");

        // Create some content to be zipped
        // You can replace this with your own content
        File file1 = temporaryFolder.newFile("file1.txt");
        File file2 = temporaryFolder.newFile("file2.txt");

        // Zip the files
        ZipExampleTestUtil.createZipFile(zipFile, file1, file2);

        // Create an instance of the UnZip class
        Unzip unZip = new Unzip();

        // Define the destination directory for extraction
        File destDirectory = temporaryFolder.newFolder("extracted");

        // Perform the unzip operation
        unZip.unzipFile(zipFile.getAbsolutePath(), destDirectory.getAbsolutePath());

        // Verify that the files were successfully extracted
        assertTrue(new File(destDirectory, "file1.txt").exists());
        assertTrue(new File(destDirectory, "file2.txt").exists());
    }
}
