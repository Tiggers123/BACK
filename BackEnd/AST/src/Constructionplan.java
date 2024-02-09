import Expr.Node;

import java.util.List;

public class Constructionplan implements Node {
    private List<String> Plan ;
    public Constructionplan(List<String> list){
        this.Plan = list;
    }
    @Override
    public StringBuilder prettyPrint(StringBuilder s) {
        return null;
    }
}
