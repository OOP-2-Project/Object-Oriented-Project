package comp3607project;

import java.io.IOException;

public class CalculateScore {

    private Breakdown breakdown;

    public CalculateScore(String filePath, String content) throws IOException{
        breakdown.generate(filePath, content);;
    }
    
}
