package comp3607project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileIterator implements InterfaceIterator{
        private static int index;
    private List <File> files;
    private String[] studentFiles;
    private File folder;

    public FileIterator(String folderPath){
        this.folder = new File(folderPath);
        this.studentFiles = this.folder.list();
        this.index = 0;
        this.files = new ArrayList<>();
        this.next();
    }

    public boolean hasNext(){
        return index < studentFiles.length;
    }

    public Object next() {
        if (this.hasNext()) {
            File nextFile = new File(folder, studentFiles[index]);
    
            while (!isTestFile(nextFile)) {
                index++;
    
                if (this.hasNext()) {
                    nextFile = new File(folder, studentFiles[index]);
                } else {
                    break;
                }
            }
    
            if (isTestFile(nextFile)) {
                files.add(nextFile);
                System.out.println("Files: " + files);
            } else {
                System.out.println("Files Collection empty");
            }
        }
    
        return files;
    }
    
    private boolean isTestFile(File file) {
        return file.getName().equals("PassengerTest.java") ||
                file.getName().equals("LuggageSlipTest.java") ||
                file.getName().equals("LuggageManifestTest.java") ||
                file.getName().equals("FlightTest.java");
    }
}
