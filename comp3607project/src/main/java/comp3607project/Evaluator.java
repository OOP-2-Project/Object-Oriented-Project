package comp3607project;


import java.io.IOException;

public abstract class Evaluator {

    private String filepath;
    private String Content;

    public Evaluator(String filepath, String Content){
        this.Content = Content;
        this.filepath = filepath;
    }

    //protected String content = " ";

    public void evaluate() throws IOException{

        Content = this.runTest(fileName);
        this.printBreakdown(filepath, Content);

    }  
    
    public abstract String runTest(Class<?>[] fileName);
    
    public abstract void printBreakdown(String filepath, String Content) throws IOException;
        
       
}

