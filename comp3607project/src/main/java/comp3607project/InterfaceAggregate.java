package comp3607project;

import java.io.File;

public interface InterfaceAggregate {
    public void addFile(File file);
    public void removeFile(File file);
    public InterfaceIterator createIterator(String folderpath);
}
