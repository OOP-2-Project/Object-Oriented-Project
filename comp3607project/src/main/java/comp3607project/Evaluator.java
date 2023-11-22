package comp3607project;


import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class Evaluator {

    private String filepath;
    private String Content;

    public Evaluator(String filepath, String Content){
        this.Content = Content;
        this.filepath = filepath;
    }


    public final void evaluate(List<File> fileName) throws IOException{

       Content = runTest(fileName);
        Content = Content + " ";
        this.printBreakdown(filepath, Content);

    }  
    
    public abstract String runTest(List<File> fileName);
    
    public abstract void printBreakdown(String filepath, String Content) throws IOException;
        
       
}

