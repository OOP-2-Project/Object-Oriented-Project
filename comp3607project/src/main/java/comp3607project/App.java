package comp3607project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        // System.out.println("Hello World");
        // System.out.println("test");

        Unzip.unzipFile("comp3607project\\src\\main\\java\\comp3607project\\816032732_Assignment#2.zip", "comp3607project\\src\\main\\java\\comp3607project");

        String folderPath = "C:\\Users\\mbabz\\Desktop\\Object-Oriented-Project\\comp3607project\\src\\main\\java\\comp3607project\\816032732_Assignment#2";
        FileCollection fileCollection = new FileCollection (folderPath);
        fileCollection.createIterator(folderPath);

        // Class<?>[] classes = convertToClasses(filteredFiles);

        // ArrayList<Evaluator> evaluators = new ArrayList<>();
        // evaluators.add(new GeneratePDF("comp3607project\\src\\main\\java\\comp3607project", "yes"));

        // for (Evaluator evaluator : evaluators) {
        //     evaluator.evaluate(classes);
        // }
    }

}