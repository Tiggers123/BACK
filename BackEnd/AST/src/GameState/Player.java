package GameState;

import java.util.Map;
import Expr.ConstructionPlan;

public class Player {
    public String name;
    public boolean life;
    private Territory territory;
    private ConstructionPlan plan;
    public Region cityCenter;
    public Region cityCrew;
    public final Map<String, Double> variableSet;
    private long budget = 0;

    public Player(String name,Territory territory,ConstructionPlan plan, Map<String, Double> variableSet) {
        this.name = name;
        this.territory = territory;
        this.plan = plan;
        this.variableSet = variableSet;
    }
}
