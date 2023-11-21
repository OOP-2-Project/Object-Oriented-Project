package comp3607project;

import java.io.IOException;

public class CalculateScore extends Evaluator {

    public CalculateScore(String filepath, String Content) {
        super(filepath, Content);
    }

    private Breakdown breakdown;

    

    @Override
    public void printBreakdown(String filepath, String Content) throws IOException {
        breakdown.generate(null, null);;
    }

    @Override
    public String runTest(Class<?>[] fileName) {

       System.out.println("hehe");

       return "hehe";
    }

}
