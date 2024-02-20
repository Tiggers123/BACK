package Expr;


import GameState.Player;
import GameState.Territory;
import Parser.ConstructionPlanParser;
import Parser.FileManager;
import Parser.Tokenizer;
import Statement.Statement;

import java.util.List;

public class Main {
    public static void main(String[] args) throws SyntaxErrorException, Parser.SyntaxErrorException {
//        String[] p = {"Ton"};
//        Territory map = new Territory(5, 5, 100, 100, 100, 100, 100, p);
        FileManager reader = new FileManager();

//        List<Player> p1 = map.getPlayer(); 
//        Player p2= p1.get(0);
//        p2.setPlan(file);
        List<String> file =  reader.FileReader("BackEnd/src/constructionplanWithcomment.txt");
        ConstructionPlanParser plan = new ConstructionPlanParser(file);
        List<Statement> state = plan.parse();



    }
}
