import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        int i = 0;
        FileManager reader = new FileManager();
        ArrayList<String> file =  reader.FileReader("BackEnd/src/constructionplanWithcomment.txt");
        List<String> u = new ArrayList<>();
        for (String inputString : file) {
            ExprTokenizer tokens1 = new ExprTokenizer(inputString);
            u.addAll(tokens1.line);
        }
        ExprTokenizer y = new ExprTokenizer();
        y.line= u;
//        System.out.println(u);
        ConstructionPlanParser x= new ConstructionPlanParser(y);
        x.parse();

    }
}