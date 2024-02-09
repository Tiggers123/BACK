package Statement;
import Expr.*;
import GameState.Player;

public class AssignmentStatement implements Statement{
    private Identifier vaiable ;
    private Expression expression ;
    public AssignmentStatement(Identifier variable , Expression expression){
        this.vaiable = variable ;
        this.expression = expression ;
    }
    @Override
    public void execute(Player user) {
//        user.variable.put(vaiable.name , this.expression.evaluate());
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {

        return s;
    }


}
