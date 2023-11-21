package comp3607project;

import java.io.IOException;
import java.net.URLClassLoader;
import java.net.URL;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class GeneratePDF extends Evaluator {
    
    public GeneratePDF(String filepath, String Content) {
        super(filepath, Content);
    }

    private PDFGenerator pdfGenerator;


    

    @Override
    public void printBreakdown(String filepath, String Content) throws IOException {
        pdfGenerator.generate("comp3607project\\src\\main\\java\\comp3607project\\816032732_Assignment#2", Content);;
    }

    @Override
    public String runTest(Class<?>[] fileNames) {
        String testResults = " ";
    
        String classFilesDirectory = "comp3607project\\src\\main\\java\\comp3607project\\816032732_Assignment#2";
    
        try {
            URL url = new URL("file://" + classFilesDirectory);
    
            URLClassLoader classLoader = new URLClassLoader(new URL[]{url});
    
            for (Class<?> fileName : fileNames) {
                Class<?> dynamicClass = classLoader.loadClass(fileName.getName());
    
                Result result = JUnitCore.runClasses(dynamicClass);
    
                for (Failure failure : result.getFailures()) {
                    String resultMessage = "Test Failed: " + failure.getDescription() +
                            "\nException: " + failure.getTrace() +
                            "\n----------";
                    testResults = testResults + resultMessage;
                }
    
                String summary = "Summary: " +
                        "\nTests run: " + result.getRunCount() +
                        "\nTests passed: " + (result.getRunCount() - result.getFailureCount()) +
                        "\nTests failed: " + result.getFailureCount() +
                        "\nAll tests passed: " + result.wasSuccessful();
                testResults = testResults + summary;
            }

            classLoader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return testResults;
    }

}
