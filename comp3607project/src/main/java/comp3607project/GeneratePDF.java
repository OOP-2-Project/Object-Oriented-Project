package comp3607project;

import java.io.File;
import java.io.IOException;
import java.net.URLClassLoader;
import java.util.List;
import java.net.URL;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class GeneratePDF extends Evaluator {

    public static int count = 1;
    
    public GeneratePDF(String filepath, String Content) {
        super(filepath, Content);
        this.pdfGenerator = new PDFGenerator();
    }

    private PDFGenerator pdfGenerator;


    

    @Override
    public void printBreakdown(String filepath, String Content) throws IOException {
        count = count + 1;
        String pdfName = "comp3607project\\src\\main\\java\\comp3607project\\816032732_Assignment#2\\Breakdown" + count + ".pdf";
        pdfGenerator.generate(pdfName, Content);;
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
    
                System.out.println("\nRunning tests for class: " + className);
    
                // Load the class from the classpath
                Class<?> dynamicClass = Class.forName("comp3607project.816032732_Assignment#2." + className);
    
                Result result = JUnitCore.runClasses(dynamicClass);
    
                for (Failure failure : result.getFailures()) {
                    String resultMessage = "\nTest Failed: " + failure.getDescription() +
                            " \nException: " + failure.getTrace() +
                            " ----------";
                    testResults = testResults + resultMessage;
                }
    
                String summary = "\nSummary: " +
                        " \nTests run: " + result.getRunCount() +
                        " \nTests passed: " + (result.getRunCount() - result.getFailureCount()) +
                        " \nTests failed: " + result.getFailureCount() +
                        " \nAll tests passed: " + result.wasSuccessful();
                testResults = testResults + summary + " ";
            }
    
            classLoader.close();
    
        } catch (Exception e) {
            e.printStackTrace();
        }
       // testResults = testResults.replace("\n", "<br>");
        testResults = testResults.replace("\t", " "); 
        testResults = testResults.replace("\r", " "); 
        System.out.println(testResults);
        return testResults;
    }
    
}
