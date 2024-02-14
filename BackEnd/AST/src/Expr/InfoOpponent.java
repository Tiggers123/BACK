package Expr;

import GameState.Player;
import GameState.Region;

public class InfoOpponent implements  Expression{
    public  InfoOpponent(){}
    @Override
    public double evaluate(Player user) throws SyntaxErrorException {
        String[] Direction = {"up","upright","downright" , "down" , "downleft","upleft"};
        Region current = user.cityCrew;
        int minDistance = Integer.MAX_VALUE ;
        int MaxofMap = user.territory().getTerritory_col() * user.territory().getTerritory_row();
        for (int i = 0; i < 6; i++) {
            for (int distance = 1; distance <= MaxofMap ; distance++) {
                current = current.moveDirection(Direction[i]);
                if (current.owner != null && current.owner != user){
                    int temp = 10 * distance + i + 1;
                    if(temp < minDistance) {
                        minDistance = temp ;
                        MaxofMap = distance ;
                    }
                }
            }
            current = user.cityCrew;
        }
        if (minDistance == Integer.MAX_VALUE){
            return 0 ;
        } else{
            return minDistance;
        }
    }

    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        s.append("opponent");
        return s ;
    }
}
