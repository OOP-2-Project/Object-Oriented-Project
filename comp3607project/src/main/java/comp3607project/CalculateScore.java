package comp3607project;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
//import org.junit.runner.notification.Failure;

public class CalculateScore extends Evaluator {

    public CalculateScore(String filepath, String Content) {
        super(filepath, Content);
        this.breakdown = new Breakdown();
    }

    private Breakdown breakdown;

    

    @Override
    public void printBreakdown(String filepath, String Content) throws IOException {
        breakdown.generate("comp3607project\\src\\main\\java\\comp3607project\\816032732_Assignment#2", Content);;
    }

    @Override
    public String runTest(List<File> fileName) {
 String testResults = "";
    
        if (fileName.isEmpty()) {
            System.out.println("The list is empty.");
            return "no class files :)";
        }
    
        try {
            URLClassLoader classLoader = new URLClassLoader(new URL[]{});
    
            for (File file : fileName) {
                String className = file.getName().replace(".class", "");
    
                // Load the class from the classpath
                Class<?> dynamicClass = Class.forName("comp3607project.816032732_Assignment#2." + className);
    
                Result result = JUnitCore.runClasses(dynamicClass);
    
                String summary = "Summary For Text File: " +
                        " Tests run: " + result.getRunCount() +
                        " Tests passed: " + (result.getRunCount() - result.getFailureCount()) +
                        " Tests failed: " + result.getFailureCount() +
                        " All tests passed: " + result.wasSuccessful();
                testResults = testResults + summary + " ";
            }
    
            classLoader.close();
    
        } catch (Exception e) {
            e.printStackTrace();
        }
        testResults = testResults.replace("\n", "<br>");
        testResults = testResults.replace("\t", " "); 
        System.out.println(testResults);
        return testResults;
    }

}
