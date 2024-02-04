import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        FileManager reader = new FileManager();
        ArrayList<String> file =  reader.FileReader("BackEnd/src/constructionplanWithcomment.txt");
        for (String inputString : file) {
            ExprTokenizer tokens1 = new ExprTokenizer(inputString);
            for (int i = 0; i < tokens1.line.size(); i++){
                System.out.println(tokens1.consume());
            }
        }

    }
}