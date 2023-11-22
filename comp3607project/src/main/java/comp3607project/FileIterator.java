package comp3607project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileIterator implements InterfaceIterator {
    private int index;
    public ArrayList<File> files;
    private String[] studentFiles;
    private File folder;

    public FileIterator(String folderPath) {
        this.folder = new File(folderPath);
        this.studentFiles = this.folder.list();
        this.index = 0;
        this.files = new ArrayList<>();
        this.next();
    }

    public boolean hasNext() {
        return index < studentFiles.length;
    }

    public List<File> next() {
        while (this.hasNext()) {
            File nextFile = new File(folder, studentFiles[index]);

            if (endsWith("Test.class", nextFile)) {
                files.add(nextFile);
                System.out.println("\n" + "Added Files: " + nextFile.getName());
            }

            index++;
        }

        return files;
    }

    private boolean endsWith(String suffix, File file) {
        return file.getName().endsWith(suffix);
    }
}
