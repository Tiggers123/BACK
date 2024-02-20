import Expr.TokenizerOneLine;

import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        int i = 0;
        FileManager reader = new FileManager();
        List<String> file =  reader.FileReader("BackEnd/src/constructionplanWithcomment1.txt");
        String y = file.toString();
        TokenizerOneLine tokenizer = new TokenizerOneLine(y);
        System.out.println(y);
    }
}