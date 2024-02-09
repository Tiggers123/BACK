import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception {
        int i = 0;
        FileManager reader = new FileManager();
        List<String> file =  reader.FileReader("BackEnd/src/constructionplanWithcomment.txt");
        Tokenizer test = new Tokenizer(file);
        ConstructionPlanParser x = new ConstructionPlanParser(test);
        x.parse();

    }
}