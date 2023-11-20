package comp3607project;

import java.io.IOException;
import java.util.ArrayList;

public abstract class Evaluator {

    private GeneratePDF pdfgeneration;
    private CalculateScore scoreGen;

    
    /** 
     * @throws IOException
     */
    public void evaluate() throws IOException{

        this.printBreakdown();
        this.runTest();

    }  
    
    public ArrayList<Integer> runTest(){

        ArrayList<Integer> scores = new ArrayList<>();

        return scores;
    }
    
    public void printBreakdown() throws IOException{
        
        pdfgeneration.printBreakdown();
        scoreGen.printBreakdown();
    }

}
