package comp3607project;

import java.io.IOException;

public interface PrintStrategy {
    public void generate(String filePath, String content) throws IOException;
}
