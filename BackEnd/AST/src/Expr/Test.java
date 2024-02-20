package Expr;


import GameState.Player;
import GameState.Territory;
import Parser.ConstructionPlanParser;
import Parser.FileManager;
import Parser.SyntaxErrorException;
import Parser.Tokenizer;
import Statement.Statement;

import java.util.List;

public class Test {
    public static void main(String[] args) throws SyntaxErrorException {
        String[] p = {"Ton"};
        Territory map = new Territory(10, 10, 0, 100, 100, 100, 100, p);
        FileManager reader = new FileManager();
        List<Player> p1 = map.getPlayer();
        Player p2= p1.get(0);
        List<String> file =  reader.FileReader("BackEnd/AST/src/Parser/ConstructionPlanTest/constructionplanWithcomment.txt");
        ConstructionPlanParser plan = new ConstructionPlanParser(file);
        ConstructionPlan i = new ConstructionPlan(plan.parse());


    }
}
