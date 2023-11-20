package comp3607project;

import java.io.File;
import java.util.ArrayList;

public class FileCollection implements InterfaceAggregate{
    
    private String folderpath;
    private ArrayList <File> files; 

    public FileCollection (String folderpath){
        this.files = new ArrayList<File>();
        this.folderpath = folderpath;
    }
    
    public void addFile(File file){
        files.add(file);
    }

     public void removeFile(File file){
        files.remove(file);
    }

    public InterfaceIterator createIterator(String folderpath){
        FileIterator fileIterator = new FileIterator(folderpath);

        return fileIterator;
    }
}
