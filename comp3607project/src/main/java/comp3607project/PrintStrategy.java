package comp3607project;

import java.io.IOException;

/**
 * A strategy interface used for printing the results onto text files
 */
public interface PrintStrategy {
    /** 
     * @param filePath The file path of the text file that will store the results
     * @param content A string variable holding all the text to be saved
     * @throws IOException Signals that an I/O exception of some sort has occurred. This class is the general class of exceptions produced by failed or interrupted I/O operations.
     */
    public void generate(String filePath, String content) throws IOException;
}
