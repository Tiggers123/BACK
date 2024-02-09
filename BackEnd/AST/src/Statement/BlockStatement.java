package Statement;

import GameState.Player;

import java.util.List;
import java.util.Map;

public class BlockStatement implements Statement{
    private List<Statement> statement ;
    BlockStatement(List<Statement> statement){
        this.statement = statement;
    }

    public StringBuilder prettyPrint(StringBuilder s) {

        return s;
    }

    @Override
    public void execute(Player user) {

    }
}
