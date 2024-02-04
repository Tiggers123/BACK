import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        int i = 0;
        FileManager reader = new FileManager();
        ArrayList<String> file =  reader.FileReader("BackEnd/src/constructionplanWithcomment.txt");
        for (String inputString : file) {
            i++ ;
            ExprTokenizer tokens1 = new ExprTokenizer(inputString);
            ConstructionPlanParser h = new ConstructionPlanParser(tokens1);
            h.parse();
        }

    }
}