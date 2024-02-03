import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        FileManager reader = new FileManager();
        ArrayList<String> file =  reader.FileReader("BackEnd/src/constructionplan.txt");
        for (String inputString : file) {
            ArrayList<String> tokens = ExprTokenizer.tokenize(inputString);
            // Print the tokens for the current input string
            ConstructionPlanParser parser = new ConstructionPlanParser(tokens);
            parser.parse();
        }

    }
}